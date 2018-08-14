package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Plane;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.Ray;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.build.GameObjectPack;
import com.mygdx.game.build.Map;
import com.mygdx.game.build.Room;
import com.mygdx.game.terrain.Terrain;
import com.mygdx.game.build.TexturePack;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.terrain.TerrainPack;
import com.mygdx.game.tools.Printer;


public class EditorScreen implements Screen, InputProcessor {

    private MyGdxGame gdxGame;
    private int tab;
    private boolean flag = false;
    private TerrainPack terrainPack;
    private GameObjectPack gameObjectPack;
    private Room room;
    private Map map;
    //
    SpriteBatch batch;
    OrthographicCamera cam;
    FillViewport viewport;
    TexturePack texturePack;
    final Matrix4 matrix = new Matrix4();
    final Plane xzPlane = new Plane(new Vector3(0,1,0), 0);
    final Vector3 intersection = new Vector3();
    final Vector3 curr = new Vector3();
    final Vector3 last = new Vector3(-1,-1,-1);
    final Vector3 delta = new Vector3();
    Sprite lastSelectedTile = null;
    GameObject lastSelectedObject = null;
    Terrain lastSelectedTerrain = null;

    public EditorScreen(MyGdxGame gdxGame) {

        texturePack = new TexturePack();
        terrainPack = new TerrainPack(texturePack);
        gameObjectPack = new GameObjectPack(texturePack);

        map = new Map(10,10, new Terrain(1000, "Lava",texturePack.getHole(), true));
        room = new Room(10, 10, map);
        this.gdxGame = gdxGame;
        cam = new OrthographicCamera(10 * 1.3f, 10 *(Gdx.graphics.getHeight()/(float)Gdx.graphics.getWidth()));
        cam.position.set(5,5,10);
        cam.direction.set(-1,-1,-1);
        cam.near = 1;
        cam.far = 500;
        matrix.setToRotation(new Vector3(1,0,0), 90);
        viewport = new FillViewport(cam.viewportWidth,cam.viewportHeight,cam);
        viewport.apply(true);
        batch = new SpriteBatch();
        Gdx.input.setInputProcessor(this);

    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode){

            case Input.Keys.E:
                tab++;
                break;

            case Input.Keys.D:
                tab--;
                break;

            case Input.Keys.F:
                if(flag)
                    flag = false;
                else
                    flag = true;
                break;



        }
        return false;
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

        checkTileTouched();

    }

    private void checkTileTouched() {

        if(Gdx.input.justTouched()) {

            Ray pickRay = cam.getPickRay(Gdx.input.getX(), Gdx.input.getY());
            Intersector.intersectRayPlane(pickRay, xzPlane, intersection);
            int x = (int) intersection.x;
            int z = (int) intersection.z;

            if (x >= 0 && x < 10 && z >= 0 && z < 10) {
                if (lastSelectedTile != null)
                    lastSelectedTile.setColor(1, 100, 10, 1);

                if (x >= 0 && z >= 0 && x < room.getC() && z < room.getL()) {

                    if(!flag){

                        Map map = room.getTileMap();

                        Printer.print(map.getTiles()[x][z].name + "\n");

                        map.addTile(terrainPack.getById(tab),x,z);

                    }else{

                        room.setObject(x, z, gameObjectPack.getObjectById(tab));



                    }


                }

            }
        }
    }

    @Override
    public void resize(int width, int height) {

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

    }
}
