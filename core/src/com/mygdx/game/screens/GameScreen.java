package com.mygdx.game.screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Plane;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.Ray;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.build.Location;
import com.mygdx.game.generators.*;
import com.mygdx.game.scene.HUD;
import com.mygdx.game.build.Map;
import com.mygdx.game.build.Room;
import com.mygdx.game.terrain.Terrain;
import com.mygdx.game.build.TexturePack;
import com.mygdx.game.enumerations.Classification;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.objects.Door;
import com.mygdx.game.objects.Entity;
import com.mygdx.game.playable.Hero;
import com.mygdx.game.playable.Spider;
import com.mygdx.game.tools.*;
import com.mygdx.game.weaponry.rangeweapon.Arrow;
import com.mygdx.game.weaponry.rangeweapon.Bow;

public class GameScreen implements Screen, InputProcessor {
    SpriteBatch batch;
    OrthographicCamera cam;
    HUD hud;
    TestTrigger trigger;
    Viewport viewport;
    TexturePack texturePack;
    RoomGenerator roomGenerator;
    EnemyGenerator enemyGenerator;
    Door door;
    int turn;
    int worldWidth;
    int worldHeight;
    final Matrix4 matrix = new Matrix4();
    PriorityQueue queque;//sorted by initiative
    Room room;
    Location location;
    LocationGenerator locationGenerator;
    GameObject enemy, enemy1, enemy2;
    GameObject current;
    GameObject player, wall;
    final Plane xzPlane = new Plane(new Vector3(0,1,0), 0);
    final Vector3 intersection = new Vector3();
    final Vector3 curr = new Vector3();
    final Vector3 last = new Vector3(-1,-1,-1);
    final Vector3 delta = new Vector3();
    Sprite lastSelectedTile = null;
    GameObject lastSelectedObject = null;
    Terrain lastSelectedTerrain = null;

    MyGdxGame game;

    public GameScreen(MyGdxGame game, TexturePack texturePack, int width, int height) {
        WeaponGenerator weaponGenerator = new WeaponGenerator();
        ArmorGenerator armorGenerator = new ArmorGenerator();


        batch = new SpriteBatch();
        this.texturePack = texturePack;
       // roomGenerator = new RoomGenerator(texturePack);
        locationGenerator = new LocationGenerator(texturePack, this);
        location = locationGenerator.generate(5);

        worldWidth = 5 + Dice.d10();
        worldHeight = 5 + Dice.d10();


       // room =  roomGenerator.generateRoom(worldWidth, worldHeight);
       // genRoom = roomGenerator.generateRoom(10, 10);
        room = location.getMainRoom();
        turn = room.getTurn();

        //Код для теста
        trigger = new TestTrigger(room, 2);
        trigger.addPoint(new Point(5,5));
        room.addTrigger(trigger);
        //

        enemyGenerator = new EnemyGenerator(texturePack);
       // door = new Door(texturePack.getDoor(), room, roomGenerator.generateRoom(10,10), this);

        cam = new OrthographicCamera(10 * 1.3f, 10 *(Gdx.graphics.getHeight()/(float)Gdx.graphics.getWidth()));
        cam.position.set(5,5,5);
        cam.direction.set(0,-1,-1);
        cam.near = 1;
        cam.far = 500;
        matrix.setToRotation(new Vector3(1,0,0), 90);
        viewport = new ScreenViewport();
        viewport.apply(true);

        Sprite sprite = new Sprite(texturePack.getFloor_min());
        sprite.setSize(1,1 );
        Terrain terrain = new Terrain(2,"test", texturePack.getHole(), true);
        sprite = terrain.getSprite();
        sprite.setSize(1,1);
        sprite.flip(false, true);


        enemy = enemyGenerator.createEemy(armorGenerator.createArmor(), weaponGenerator.createWeapon());
        enemy1 = enemyGenerator.createEemy(armorGenerator.createArmor(), weaponGenerator.createWeapon());;
        //enemy2 = enemyGenerator.createEemy(armorGenerator.createArmor(), weaponGenerator.createWeapon(), buffPool);

        sprite = new Sprite(texturePack.getPlayer());
        Bow bow = new Bow();
        bow.setShell(new Arrow(10, bow));
        player = new Hero("Donny", 10000, 10,sprite,5, 1,
                0, 10, 16, 14,
                0, Classification.Playable);
        player.equipWeapon(bow);
        player.equipArmor(armorGenerator.createArmor());

        sprite = new Sprite(texturePack.getWall_1());
        wall = new Entity("Wall", sprite);


        room.setObject(wall);
        room.setObject(enemy);
        room.setObject(enemy1);
        room.setObject(enemy2);
        room.setObject(player);
        room.setObject(door);
        queque = room.getInitiativeQueue();

        hud = new HUD(batch, this, texturePack.getSkin(), width, height, worldWidth, worldHeight);
        Printer.setHud(hud);

      //  queque.display();
        Printer.show(room);


        Gdx.input.setInputProcessor(this);
        this.game = game;

    }

    @Override
    public void show() {

    }

    public GameObject getCurrent (){

        return current;

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        cam.update();
        batch.setProjectionMatrix(cam.combined);
        batch.setTransformMatrix(matrix);

        batch.begin();
        viewport.apply();
        room.drawMap(batch);
        room.drawObjects(batch);
        batch.end();
        //batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.getViewport().apply();
        hud.stage.draw();


        checkTileTouched();
        checkTurnEnded();


    }

    private void checkTurnEnded() {
        if(!queque.isEmpty() && (current == null || current.getMP() <= 0 || current.getHP() <= 0)) {
            current = queque.remove();
            hud.showCurrent(current);
        }else if (queque.isEmpty()){
            room.resetMp();
            queque.insert(room.getPlayableObjects());
            turn++;
            room.setTurn(turn);
            hud.showTurn(turn);
         
        }
    }

    private void checkTileTouched() {

        if(Gdx.input.justTouched()) {



            Ray pickRay = cam.getPickRay(Gdx.input.getX(), Gdx.input.getY());
            Intersector.intersectRayPlane(pickRay, xzPlane, intersection);
            int x = (int) intersection.x ;
            int z = (int) intersection.z;
            Sprite sprite;

           /* Printer.print("\n" + "L: " + room.getL() + " C: " + room.getC() + "\n"
                    + "x: " + x + " y: "+ z + "\n"
                    + "wW: " + worldWidth + " wH: "+ worldHeight + "\n");*/

            if (x >= 0 && x <= room.getL() && z >= 0 && z <= room.getC()) {
                if (lastSelectedTile != null)
                    lastSelectedTile.setColor(1, 1, 1, 1);


                if ((x >= 0 && z >= 0 )&& (x <= room.getL() - 1 && z <= room.getC() - 1)) {
                    if (room.getObject(x, z) != null && room.getObject(x, z).getClass() != Entity.class) {
                        sprite = room.getObject(x, z).getSprite();
                        Printer.show(room.getObject(x,z));
                        hud.show(room.getObject(x,z));

                        if(lastSelectedObject != null && lastSelectedObject != room.getObject(x,z) && lastSelectedObject.getMP() > 0 && lastSelectedObject == current && isInRange(lastSelectedObject, room.getObject(x,z))){
                            lastSelectedObject.makeStep(1000);//1000 чтобы закончить ход
                            lastSelectedObject.getWeapon().makeDamage(lastSelectedObject, room.getObject(x,z));
                            unselect();

                        }else {
                            if(room.getObject(x, z) == current) {
                                lastSelectedObject = room.getObject(x, z);
                                lastSelectedObject.getBuffPool().use();
                                PathFinder.drawWays(batch, room, x, z, room.getL(), room.getC());
                            }
                        }
                    } else {
                        Map map = room.getTileMap();
                        sprite = map.getTiles()[x][z].getSprite();
                        if(lastSelectedObject != null && lastSelectedObject.getMP() > 0 && lastSelectedObject == current){
                            if(room.getTileMap().getTiles()[x][z].flag == true && room.move(lastSelectedObject.getX(), lastSelectedObject.getY(), x, z)) {
                                lastSelectedObject.makeStep(room.getTileMap().getTiles()[x][z].getMovementPrice());
                                unselect();
                            }
                        }

                      //  Printer.print("" + map.getTiles()[x][z].getMovementCost()+"\n"  + map.getTiles()[x][z].getMovementPrice() + "\n");
                    }if(sprite != null) {
                        sprite.setColor(1,1,5,25);
                        lastSelectedTile = sprite;
                    }
                }else{
                    unselect();
                }

            }

            update();

        }
    }

    private boolean isInRange(GameObject lastSelectedObject, GameObject object) {


        if((double)(lastSelectedObject.getWeapon().getDistance()) < (Math.sqrt(Math.pow((object.getX() - lastSelectedObject.getX()),2) + Math.pow((object.getY() - lastSelectedObject.getY()),2))))
        return false;
        else
            return true;

    }

    public void update(){

        if(lastSelectedObject == null)
            room.clearTiles();


    }

    public void unselect(){

        lastSelectedObject = null;
        lastSelectedTerrain = null;
        lastSelectedTile = null;

    }

    @Override
    public void resize(int width, int height) {

        viewport.update(width, height);
        hud.resize(width, height);

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode){

            case Input.Keys.ENTER:
                current.makeStep(1000);
                unselect();
                update();
                break;

            case Input.Keys.I:
                room.delete(current.getX(), current.getY());
                current = null;
                lastSelectedObject = null;
                update();
                checkTurnEnded();
                break;

            case Input.Keys.A://использовать только для теста!
            //   moveToRoom();
                break;
            case Input.Keys.K:
               // queque.display();
                break;
            case Input.Keys.C:
                Printer.show(current);
                break;

            case Input.Keys.R:
                Printer.show(room);
                break;


        }
        return false;
    }

    public void moveToRoom(Door door){

        room = door.getNextRoom(room);
        worldWidth = room.getL();
        worldHeight = room.getC();
        turn = room.getTurn();
        queque = room.getInitiativeQueue();
        current = null;
        lastSelectedObject = null;
        room.resetMp();
        checkTurnEnded();


    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        last.set(-1,-1,-1);
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        Ray pickRay = cam.getPickRay(screenX, screenY);
        Intersector.intersectRayPlane(pickRay, xzPlane, curr);

        if(!(last.x == -1 && last.y == -1 && last.z == -1)) {
            pickRay = cam.getPickRay(last.x, last.y);
            Intersector.intersectRayPlane(pickRay, xzPlane, delta);
            delta.sub(curr);
            cam.position.add(delta.x, delta.y, delta.z);
        }
        last.set(screenX, screenY, 0);
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
