package com.mygdx.game.graphics;

import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.decals.DecalBatch;
import com.mygdx.game.build.Room;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.interfaces.Particle;
import com.mygdx.game.terrain.Terrain;
import com.mygdx.game.tools.Trigger;

import java.util.ArrayList;

/**
 * Created by Даниил on 23.01.2019.
 */
public class Render3D implements Render {

    protected Environment environment;
    protected Room room;
    protected DecalBatch decalBatch;
    protected ModelBatch modelBatch;
    protected PerspectiveCamera camera;

    public Render3D(Environment environment, Room room, DecalBatch decalBatch, ModelBatch modelBatch, PerspectiveCamera camera) {
        this.environment = environment;
        this.room = room;
        this.decalBatch = decalBatch;
        this.modelBatch = modelBatch;
        this.camera = camera;
    }

    private  void drawTerrain(Terrain terrain[][], DecalBatch decalBatch,
                              int xSize, int ySize, PerspectiveCamera camera){

        for(int i = 0; i < ySize; i++){
            for(int j = 0; j < xSize; j++){
                if(camera.frustum.pointInFrustum(i+ terrain[i][j].getSprite().getWidth(),0,j + terrain[i][j].getSprite().getHeight())
                        || camera.frustum.pointInFrustum(i - terrain[i][j].getSprite().getWidth(),0,j - terrain[i][j].getSprite().getHeight())
                        || camera.frustum.pointInFrustum(i + terrain[i][j].getSprite().getWidth(),0,j)
                        ||  camera.frustum.pointInFrustum(i,0,j + terrain[i][j].getSprite().getHeight()*2.2f)){
                    decalBatch.add(terrain[i][j].getSprite());
                }
            }
        }

    }

    private  void drawGameObjects(GameObject gameObjects[][], DecalBatch decalBatch, ModelBatch modelBatch,
                                        int xSize, int ySize, PerspectiveCamera camera){

        for(int i = 0; i < ySize; i++){
            for(int j = 0; j < xSize; j++){
                if (gameObjects[i][j] != null)
                if((camera.frustum.pointInFrustum(i + 1,0,j + 1))
                        || (camera.frustum.pointInFrustum(i - 1,0,j - 1))
                        || (camera.frustum.pointInFrustum(i + 1,0,j))
                        || (camera.frustum.pointInFrustum(i, 0, j + 2.2f))){
                    RenderType3D object = (RenderType3D)gameObjects[i][j];
                    object.draw(modelBatch, decalBatch, environment);
                }
            }
        }
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setDecalBatch(DecalBatch decalBatch) {
        this.decalBatch = decalBatch;
    }

    public void setModelBatch(ModelBatch modelBatch) {
        this.modelBatch = modelBatch;
    }

    public void setCamera(PerspectiveCamera camera) {
        this.camera = camera;
    }

    public void setEnvironment(Environment environment) {

        this.environment = environment;
    }

    @Override
    public void render() {
        camera.update();
        modelBatch.begin(camera);
        drawTerrain(room.getTileMap().getTiles(), decalBatch, room.getC(), room.getL(), camera);
        drawGameObjects(room.getMap(), decalBatch, modelBatch, room.getC(), room.getL(), camera);
        room.drawPatricles(decalBatch);
        room.checkUnactiveObjects();
        modelBatch.end();
        decalBatch.flush();
    }
}
