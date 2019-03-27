package com.mygdx.game.screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.decals.CameraGroupStrategy;
import com.badlogic.gdx.graphics.g3d.decals.Decal;
import com.badlogic.gdx.graphics.g3d.decals.DecalBatch;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.environment.PointLight;
import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Plane;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.Ray;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.*;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.armor.ChainArmor;
import com.mygdx.game.armor.IronArmor;
import com.mygdx.game.armor.LeatherArmor;
import com.mygdx.game.build.*;
import com.mygdx.game.generators.*;
import com.mygdx.game.graphics.IsometricRender;
import com.mygdx.game.graphics.Render;
import com.mygdx.game.graphics.Render3D;
import com.mygdx.game.graphics.RenderType2D;
import com.mygdx.game.interfaces.Particle;
import com.mygdx.game.interfaces.Property;
import com.mygdx.game.items.CelticFire;
import com.mygdx.game.levels.DemoLevelsLocation;
import com.mygdx.game.build.Room;
import com.mygdx.game.levels.RoomIntrance;
import com.mygdx.game.levels.Test2DLevel;
import com.mygdx.game.levels.TestBossFightArena;
import com.mygdx.game.objects.*;
import com.mygdx.game.playable.Orc;
import com.mygdx.game.playable.Skeleton;
import com.mygdx.game.playable.Spider;
import com.mygdx.game.scene.HUD;
import com.mygdx.game.systems.*;
import com.mygdx.game.terrain.Terrain;
import com.mygdx.game.enumerations.Classification;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.playable.Hero;
import com.mygdx.game.terrain.TerrainPack;
import com.mygdx.game.tools.*;
import com.mygdx.game.weaponry.meleeweapon.IronSword;
import com.mygdx.game.weaponry.meleeweapon.WoodenSword;
import com.sun.org.apache.bcel.internal.generic.NEW;


import java.util.ArrayList;

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
    IsometricRender render;
    // Location location;
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
    private boolean inputBlock;

    public GameScreen(MyGdxGame game, TexturePack texturePack, int width, int height) {
        WeaponGenerator weaponGenerator = new WeaponGenerator();
        ArmorGenerator armorGenerator = new ArmorGenerator();


        NewTexturePack.init();
        Sprite sprite = new Sprite(NewTexturePack.player);
        sprite.setSize(1,1);
        sprite.flip(false, true);

        batch = new SpriteBatch();
        this.texturePack = texturePack;

        room = new RoomIntrance(new TerrainPack(texturePack), texturePack, new GameObjectPack(texturePack, null));
        player =  new Hero("Linni Unnamed", 17, 10, 8, 3,
                5000, 16,16,12,
                7, Classification.Playable, new ArrayList<Property>(), new Sprite(NewTexturePack.player));

        player.equipWeapon(new IronSword());
        player.equipArmor(new ChainArmor());

        // roomGenerator = new RoomGenerator(texturePack);
        // locationGenerator = new LocationGenerator(texturePack, this);
        //  location = locationGenerator.generate(5);

        //  worldWidth = 5 + Dice.d10();
        //  worldHeight = 5 + Dice.d10();





        // room =  roomGenerator.generateRoom(worldWidth, worldHeight);
        // genRoom = roomGenerator.generateRoom(10, 10);
        // room = location.getMainRoom();
        //  turn = room.getTurn();

        //Код для теста
        // trigger = new TestTrigger(room, 2);
        //  trigger.addPoint(new Point(5,5));
        //  room.addTrigger(trigger);
        //

        enemyGenerator = new EnemyGenerator(texturePack);
        // door = new Door(texturePack.getDoor(), room, roomGenerator.generateRoom(10,10), this);

        cam = new OrthographicCamera(10 * 1.3f, 10 *(Gdx.graphics.getHeight()/(float)Gdx.graphics.getWidth()));
        cam.position.set(5,5,5);
        cam.direction.set(0,-1,-1);
        cam.near = 1;
        cam.far = 500;
        matrix.setToRotation(new Vector3(1,0,0), 90);
        viewport = new FillViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        viewport.apply(true);
        render = new IsometricRender(room, batch,cam, viewport);




        // room.setObject(wall);
      //  room.setObject(enemy);
      //  room.setObject(enemy1);
      //  room.setObject(enemy2);
      //  room.move(0,0,5,5);
        // room.setObject(enemy1);
        // room.setObject(enemy2);
    //    room.setObject(player);
        // room.setObject(door);
        queque = room.getInitiativeQueue();
        room.setObject(player);
        room.setObject(new Skeleton());
        room.setObject(new Orc());
        room.setObject(new Spider());
        room.setObject(new Column());
        room.setObject(new BlueFountain());
        room.setObject(new CelticFire());
        room.setObject(new Chest());
        hud = new HUD(this, texturePack.getSkin(), width, height, player);
        Printer.setHud(hud);


        //  queque.display();
     //   Printer.show(room);


        Gdx.input.setInputProcessor(this);
        this.game = game;

        initSystems();


    }

    @Override
    public void show() {

    }

    private void initSystems(){

        DialogManager.init(hud);
        RoomManager.init(this);

    }

    public GameObject getCurrent (){

        return current;

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 255);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        cam.update();
        batch.setProjectionMatrix(cam.combined);
        batch.setTransformMatrix(matrix);
        batch.begin();
        render.render();


        batch.end();
        batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.getViewport().apply();
        hud.stage.draw();

        checkTurnEnded();
        checkTileTouched();

        //System.out.println(Gdx.input.getX() + " : " + Gdx.input.getY());





    }
    
    public synchronized void blockInput(){inputBlock = true;}

    public synchronized void unblockInput(){inputBlock = false;}


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



          /*  if (Gdx.input.justTouched()) {


                Ray pickRay = cam.getPickRay(Gdx.input.getX(), Gdx.input.getY());
                Intersector.intersectRayPlane(pickRay, xzPlane, intersection);
                int x = (int) intersection.x;
                int z = (int) intersection.z;
            }*/
        if(current != null && current.getController() == null) {

            if (Gdx.input.justTouched()) {



                Ray pickRay = cam.getPickRay(Gdx.input.getX(), Gdx.input.getY());
                Intersector.intersectRayPlane(pickRay, xzPlane, intersection);
                Vector3 cartisianCoords = IsometricRender.isoTo2d(intersection.x, intersection.z);
                int x = (int) cartisianCoords.y;
                int z = (int) cartisianCoords.x;
                System.out.println(x + "_o_" + z);

                Sprite sprite;



           /* Printer.print("\n" + "L: " + room.getL() + " C: " + room.getC() + "\n"
                    + "x: " + x + " y: "+ z + "\n"
                    + "wW: " + worldWidth + " wH: "+ worldHeight + "\n");*/

                if (x >= 0 && x <= room.getL() && z >= 0 && z <= room.getC()) {
                    if (lastSelectedTile != null)
                        lastSelectedTile.setColor(1, 1, 1, 1);


                    if ((x >= 0 && z >= 0) && (x <= room.getL() - 1 && z <= room.getC() - 1)) {
                        if (room.getObject(x, z) != null && room.getObject(x, z).getClass() != Entity.class) {
                            sprite = ((RenderType2D )(room.getObject(x, z))).getSprite();
                            Printer.show(room.getObject(x, z));
                            hud.show();

                            if (lastSelectedObject != null && lastSelectedObject != room.getObject(x, z) && lastSelectedObject.getMP() > 0 && lastSelectedObject == current && isInRange(lastSelectedObject, room.getObject(x, z))) {
                                lastSelectedObject.makeStep(1000);//1000 чтобы закончить ход
                              //  lastSelectedObject.getWeapon().makeDamage(lastSelectedObject, room.getObject(x, z));
                                Damager.makeDamage(lastSelectedObject, room.getObject(x,z));
                                unselect();

                            } else {
                                if (room.getObject(x, z) == current) {
                                    lastSelectedObject = room.getObject(x, z);
                                    lastSelectedObject.getBuffPool().use();
                                    PathFinder.drawWays(batch, room, x, z, room.getL(), room.getC());
                                }
                            }
                        } else {
                            Map map = room.getTileMap();
                            sprite = map.getTiles()[x][z].getSprite();
                            if (lastSelectedObject != null && lastSelectedObject.getMP() > 0 && lastSelectedObject == current) {
                                if (room.getTileMap().getTiles()[x][z].flag == true && room.move((int) lastSelectedObject.getX(), (int) lastSelectedObject.getY(), x, z)) {
                                    lastSelectedObject.makeStep(room.getTileMap().getTiles()[x][z].getMovementPrice());
                                    unselect();
                                }
                            }

                            //  Printer.print("" + map.getTiles()[x][z].getMovementCost()+"\n"  + map.getTiles()[x][z].getMovementPrice() + "\n");
                        }
                        if (sprite != null) {
                            sprite.setColor(1, 1, 5, 25);
                            lastSelectedTile = sprite;
                        }
                    } else {
                        unselect();
                    }

                }


                update();

            }
        }else if(current != null){

            Printer.show(current);
            PathFinder.drawWays(batch, room, (int) current.getX(), (int) current.getY(), room.getL(), room.getC());
            current.getController().makeTurn(room);


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
        viewport.apply(true);
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

    public void moveToRoom(Room room){

        this.room = room;
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

