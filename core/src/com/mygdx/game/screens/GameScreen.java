package com.mygdx.game.screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.decals.CameraGroupStrategy;
import com.badlogic.gdx.graphics.g3d.decals.Decal;
import com.badlogic.gdx.graphics.g3d.decals.DecalBatch;
import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Plane;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.Ray;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.armor.ChainArmor;
import com.mygdx.game.armor.IronArmor;
import com.mygdx.game.build.*;
import com.mygdx.game.generators.*;
import com.mygdx.game.interfaces.Particle;
import com.mygdx.game.interfaces.Property;
import com.mygdx.game.items.CelticFire;
import com.mygdx.game.levels.ArtifactRoom;
import com.mygdx.game.levels.DemoLevelsLocation;
import com.mygdx.game.build.Room;
import com.mygdx.game.objects.BlueFountain;
import com.mygdx.game.objects.Column;
import com.mygdx.game.objects.ModelEntity;
import com.mygdx.game.scene.HUD;
import com.mygdx.game.systems.Damager;
import com.mygdx.game.systems.DialogManager;
import com.mygdx.game.systems.GameScreenManager;
import com.mygdx.game.systems.RoomManager;
import com.mygdx.game.terrain.Terrain;
import com.mygdx.game.enumerations.Classification;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.objects.Door;
import com.mygdx.game.playable.Hero;
import com.mygdx.game.terrain.TerrainPack;
import com.mygdx.game.tools.*;
import com.mygdx.game.weaponry.meleeweapon.IronSword;
import com.mygdx.game.weaponry.meleeweapon.Spear;
import com.mygdx.game.weaponry.rangeweapon.Arrow;
import com.mygdx.game.weaponry.rangeweapon.Bow;
import com.mygdx.game.weaponry.rangeweapon.Shell;


import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;

public class GameScreen implements Screen, InputProcessor {
    DecalBatch batch;
    AssetManager assetManager;
    Decal testBg;
    MeshPartBuilder meshBuilder;
    ModelBatch modelBatch;
    Array<Decal> decals = new Array<Decal>();
    PerspectiveCamera camera;
    FPSLogger logger = new FPSLogger();
    public Model model, model2;
    public ModelInstance instance, instance2;
    Viewport viewport;
    TexturePack texturePack;
    RoomGenerator roomGenerator;
    EnemyGenerator enemyGenerator;
    Door door;
    int turn;
    int worldWidth;
    Decal decal;
    int worldHeight;
    final Matrix4 matrix = new Matrix4();
    PriorityQueue queque;//sorted by initiative
    Room room;
   // Location location;
    LocationGenerator locationGenerator;
    GameObject current;
    GameObject player, wall;
    final Plane xzPlane = new Plane(new Vector3(0,1,0), 0);
    final Vector3 intersection = new Vector3();
    final Vector3 curr = new Vector3();
    final Vector3 last = new Vector3(-1,-1,-1);
    final Vector3 delta = new Vector3();
    Decal lastSelectedTile = null;
    GameObject lastSelectedObject = null;
    Terrain lastSelectedTerrain = null;
    DemoLevelsLocation demoLevelsLocation;
    HUD hud;
    public static  PerspectiveCamera perspectiveCamera;
    private  volatile boolean inputBlock;

    MyGdxGame game;

    public GameScreen(MyGdxGame game, TexturePack texturePack, int width, int height) {

        GameScreenManager.init(this);

        assetManager = new AssetManager();
        assetManager.load("wall.obj", Model.class);
        assetManager.load("door.obj", Model.class);
        assetManager.finishLoading();

        RoomManager.init(this);

        NewTexturePack.init();

        inputBlock = false;


        player = new Hero("Donny", 100, 10,
                Decal.newDecal(1,1,
                        new TextureRegion(new Texture(Gdx.files.internal("player.png"))),
                        true), 10,1,1,14,14,
                14,1, Classification.Playable, new ArrayList<Property>());
        player.equipWeapon(new IronSword());
        player.equipArmor(new IronArmor());

        demoLevelsLocation = new DemoLevelsLocation(texturePack, new TerrainPack(texturePack), new GameObjectPack(texturePack, assetManager), this, assetManager);

        hud = new HUD(this, texturePack.getSkin(), Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), player);
        Printer.setHud(hud);

        DialogManager.init(hud);

        camera = new PerspectiveCamera(25, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.near = 1;
        camera.far = 100;
        camera.position.set(5, 6, 10);
        camera.direction.set(-1,-1,-1);

        camera.rotate(camera.combined);

        room = demoLevelsLocation.getMainRoom();

       // CelticFire celticFire = new CelticFire("Celtic fire", Decal.newDecal(0.45f,0.45f, new TextureRegion(new Texture(Gdx.files.internal("celtic_fire.png"))), true));

       // Column column = new Column(Decal.newDecal(2,2, new TextureRegion(new Texture(Gdx.files.internal("crumbled_column.png"))), true));
      //  BlueFountain blueFountain = new BlueFountain(Decal.newDecal(0.8f, 0.8f, new TextureRegion(new Texture(Gdx.files.internal("blue_fountain.png"))), true));

      // ModelEntity wall = new ModelEntity("Wall", assetManager.get("wall.obj", Model.class));


        queque = room.getInitiativeQueue();

        testBg = Decal.newDecal(room.getL(), room.getC(), new TextureRegion(new Texture(Gdx.files.internal("background.jpg"))));
        testBg.setPosition(4.5f,3f, 0f);

        Gdx.input.setInputProcessor(this);
        batch = new DecalBatch(new CameraGroupStrategy(camera));

        room.setObject(player);


        modelBatch = new ModelBatch();
        camera.lookAt(-1, -1, -1);
        camera.update();
        initcamera(camera);
    }

    static  void initcamera(PerspectiveCamera camera){

        perspectiveCamera = camera;

    }

    @Override
    public void show() {

    }

    private void initSystems(){

        RoomManager.init(this);

    }

    public GameObject getCurrent (){

        return current;

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        Gdx.gl.glEnable(GL20.GL_DEPTH_TEST);
        camera.update();
        modelBatch.begin(camera);
        batch.add(testBg);//DEMO TEST
        room.draw(modelBatch, batch);
        //modelBatch.render(instance2);
        modelBatch.end();
        batch.flush();
        checkTurnEnded();
        checkTileTouched();
        camera.transform(matrix);
        hud.show();
        hud.stage.draw();

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

        if(!inputBlock && player.getHP() > 0)
       if(current != null && current.getController() == null ) {

            if (Gdx.input.justTouched()) {


                Ray pickRay = perspectiveCamera.getPickRay(Gdx.input.getX(), Gdx.input.getY());
                Intersector.intersectRayPlane(pickRay, xzPlane, intersection);

                System.out.println(intersection.x +" " +intersection.z);
                System.out.println("fixed: " + (intersection.x + 0.1f) +" " + (intersection.z - 0.7f));



                int x = (int) (intersection.x + 0.1f);//погрешности измерений
                int z = (int) (intersection.z - 0.7f);

                Decal sprite;

                System.out.println(x +" " +z);



                if (x >= 0 && x <= room.getL() && z >= 0 && z <= room.getC()) {
                    if (lastSelectedTile != null)
                        lastSelectedTile.setColor(1, 1, 1, 1);


                    if ((x >= 0 && z >= 0) && (x <= room.getL() - 1 && z <= room.getC() - 1)) {
                        if (room.getObject(x, z) != null && room.getObject(x, z).getClass() != ModelEntity.class) {
                            sprite = room.getObject(x, z).getSprite();
                            Printer.show(room.getObject(x, z));


                            if (lastSelectedObject != null && lastSelectedObject != room.getObject(x, z) && lastSelectedObject.getMP() > 0 && lastSelectedObject == current && isInRange(lastSelectedObject, room.getObject(x, z))) {
                                if(room.getObject(x,z).getClassification() != Classification.OBJECT)
                                 lastSelectedObject.makeStep(1000);//1000 чтобы закончить ход
                               // lastSelectedObject.getWeapon().makeDamage(lastSelectedObject, room.getObject(x, z));
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
                                if (room.getTileMap().getTiles()[x][z].flag == true && room.move(lastSelectedObject.getX(), lastSelectedObject.getY(), x, z)) {
                                    lastSelectedObject.makeStep(room.getTileMap().getTiles()[x][z].getMovementPrice());
                                    unselect();
                                }else
                                    unselect();
                            }

                            //  Printer.print("" + map.getTiles()[x][z].getMovementCost()+"\n"  + map.getTiles()[x][z].getMovementPrice() + "\n");
                        }
                        if (sprite != null) {
                            sprite.setColor(1, 1, 1, 25);
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
            PathFinder.drawWays(batch, room, current.getX(), current.getY(), room.getL(), room.getC());
            current.getController().makeTurn(room);


        }

    }

    public synchronized void blockInput(){inputBlock = true;}

    public synchronized void unblockInput(){inputBlock = false;}

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

    if(camera != null){
        camera.viewportWidth = width;
        camera.viewportHeight = height;
        camera.update();
    }

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
        testBg.setHeight(room.getL());
        testBg.setWidth(room.getC());

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

            Ray pickRay = camera.getPickRay(screenX, screenY);
            Intersector.intersectRayPlane(pickRay, xzPlane, curr);

            if (!(last.x == -1 && last.y == -1 && last.z == -1)) {
                pickRay = camera.getPickRay(last.x, last.y);
                Intersector.intersectRayPlane(pickRay, xzPlane, delta);
                delta.sub(curr);
                camera.position.add(delta.x, delta.y, delta.z);
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
        camera.fieldOfView -= -amount * Gdx.graphics.getDeltaTime() * 100;
        return false;
    }

    public void addParticle(Particle particle){

        room.addParticle(particle);

    }

    public void removeParticle(Particle particle){

        room.removeParticle(particle);

    }

}

