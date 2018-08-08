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
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Scene.HUD;
import com.mygdx.game.build.Map;
import com.mygdx.game.build.Room;
import com.mygdx.game.build.Terrain;
import com.mygdx.game.build.TexturePack;
import com.mygdx.game.enumerations.Classification;
import com.mygdx.game.generators.ArmorGenerator;
import com.mygdx.game.generators.EnemyGenerator;
import com.mygdx.game.generators.RoomGenerator;
import com.mygdx.game.generators.WeaponGenerator;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.objects.Door;
import com.mygdx.game.objects.Entity;
import com.mygdx.game.playable.Hero;
import com.mygdx.game.playable.Spider;
import com.mygdx.game.tools.BuffPool;
import com.mygdx.game.tools.PathFinder;
import com.mygdx.game.tools.Printer;
import com.mygdx.game.tools.PriorityQueue;

public class GameScreen implements Screen, InputProcessor {
    SpriteBatch batch;
    BuffPool buffPool;
    OrthographicCamera cam;
    HUD hud;
    FillViewport viewport;
    TexturePack texturePack;
    RoomGenerator roomGenerator;
    EnemyGenerator enemyGenerator;
    Door door;
    int turn;
    final Matrix4 matrix = new Matrix4();
    PriorityQueue queque;//sorted by initiative
    Room room, genRoom;
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

    public GameScreen(MyGdxGame game) {
        WeaponGenerator weaponGenerator = new WeaponGenerator();
        ArmorGenerator armorGenerator = new ArmorGenerator();

        texturePack = new TexturePack();
        roomGenerator = new RoomGenerator(texturePack);



        genRoom = roomGenerator.generateRoom(10, 10);
        room = genRoom;
        buffPool = room.getBuffPool();
        turn = room.getTurn();
        enemyGenerator = new EnemyGenerator(texturePack);
        door = new Door(texturePack.getDoor(), room, roomGenerator.generateRoom(10,10), this);

        cam = new OrthographicCamera(10 * 1.3f, 10 *(Gdx.graphics.getHeight()/(float)Gdx.graphics.getWidth()));
        cam.position.set(5,5,10);
        cam.direction.set(-1,-1,-1);
        cam.near = 1;
        cam.far = 500;
        matrix.setToRotation(new Vector3(1,0,0), 90);
        viewport = new FillViewport(cam.viewportWidth,cam.viewportHeight,cam);
        viewport.apply(true);

        Sprite sprite = new Sprite(texturePack.getFloor_min());
        sprite.setSize(1,1 * (Gdx.graphics.getWidth()/Gdx.graphics.getHeight()));
        Terrain terrain = new Terrain(2,"test", texturePack.getHole(), true);
        sprite = terrain.getSprite();
        sprite.setSize(1,1);
        sprite.flip(false, true);


        enemy = new Spider(new Sprite(texturePack.getSpider()), buffPool);
        enemy.equipArmor(armorGenerator.createArmor());
        enemy1 = new Spider(new Sprite(texturePack.getSpider()), buffPool);;
        enemy1.equipArmor(armorGenerator.createArmor());
        //enemy2 = enemyGenerator.createEemy(armorGenerator.createArmor(), weaponGenerator.createWeapon(), buffPool);

        sprite = new Sprite(texturePack.getPlayer());
        player = new Hero("Donny", 10000, 10,sprite,5, 1,
                0, 10, 16, 14,
                0, Classification.Playable);
        player.equipWeapon(weaponGenerator.createWeapon());
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
        queque.display();
        Printer.show(room);

        batch = new SpriteBatch();
        Gdx.input.setInputProcessor(this);
        hud = new HUD(batch, cam.viewportWidth, cam.viewportHeight);

        this.game = game;

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        cam.update();
        batch.setProjectionMatrix(cam.combined);
        batch.setTransformMatrix(matrix);

        batch.begin();
        room.drawMap(batch);
        room.drawObjects(batch);
        batch.end();
        batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();


        checkTileTouched();
        checkTurnEnded();


    }

    private void checkTurnEnded() {
        if(!queque.isEmpty() && (current == null || current.getMP() <= 0 || current.getHP() <= 0)) {
           hud.showTurn(turn);
            current = queque.remove();
        }else if (queque.isEmpty()){
            room.resetMp();
            queque.insert(room.getPlayableObjects());
            turn++;
            room.setTurn(turn);
            checkBuffPool();
        }
    }

    private void checkBuffPool() {

        buffPool.use();

    }

    private void checkTileTouched() {

        if(Gdx.input.justTouched()) {

            Ray pickRay = cam.getPickRay(Gdx.input.getX(), Gdx.input.getY());
            Intersector.intersectRayPlane(pickRay, xzPlane, intersection);
            int x = (int) intersection.x ;
            int z = (int) intersection.z;
            Sprite sprite;

            if (x >= 0 && x < 10 && z >= 0 && z < 10) {
                if (lastSelectedTile != null)
                    lastSelectedTile.setColor(1, 1, 1, 1);

                if (x >= 0 && z >= 0 && x < room.getC()&& z < room.getL()) {
                    if (room.getObject(x, z) != null && room.getObject(x, z).getClass() != Entity.class) {
                        sprite = room.getObject(x, z).getSprite();
                        Printer.show(room.getObject(x,z));
                        hud.show(room.getObject(x,z));

                        if(lastSelectedObject != null && lastSelectedObject != room.getObject(x,z) && lastSelectedObject.getMP() > 0 && lastSelectedObject == current){
                            lastSelectedObject.makeStep(1000);//1000 чтобы закончить ход
                            lastSelectedObject.getWeapon().makeDamage(lastSelectedObject, room.getObject(x,z));
                            unselect();

                        }else {
                            if(room.getObject(x, z) == current) {
                                lastSelectedObject = room.getObject(x, z);
                                PathFinder.drawWays(batch, room, x, z);
                            }
                        }
                    } else {
                        Map map = room.getTileMap();
                        sprite = map.getTiles()[x][z].getSprite();
                        if(lastSelectedObject != null && lastSelectedObject.getMP() > 0 && lastSelectedObject == current){
                            if(room.getTileMap().getTiles()[x][z].flag == true && room.move(lastSelectedObject.getX(), lastSelectedObject.getY(), x, z)) {
                                lastSelectedObject.makeStep(room.getTileMap().getTiles()[x][z].getMovementCost());
                                unselect();
                            }
                        }

                        Printer.print("" + map.getTiles()[x][z].getMovementCost()+"\n");
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
                break;

            case Input.Keys.A://использовать только для теста!
               moveToRoom();
                break;
            case Input.Keys.K:
                queque.display();
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

    public void moveToRoom(){

        room = door.getNextRoom(room);
        buffPool = room.getBuffPool();
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
