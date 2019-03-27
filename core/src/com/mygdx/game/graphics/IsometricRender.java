package com.mygdx.game.graphics;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.build.NewTexturePack;
import com.mygdx.game.build.Room;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.terrain.Terrain;


/**
 * Created by Даниил on 20.02.2019.
 */
public class IsometricRender implements Render {

    protected Room room;
    protected Sprite background;
    protected SpriteBatch spriteBatch;
    protected OrthographicCamera camera;
    protected Viewport viewport;

    public IsometricRender(Room room, SpriteBatch spriteBatch, OrthographicCamera camera, Viewport viewport) {
        this.room = room;
        this.spriteBatch = spriteBatch;
        this.camera = camera;
        this.viewport = viewport;
        background = new Sprite(NewTexturePack.dirt);
        background.setSize(2, 1);
        background.flip(false, true);
        background.setX(0);
        background.setY(0);

    }

    protected void drawTerrain(Terrain terrain[][]){

        RenderType2D defTerrain = room.getTileMap().getDefaultTerrain();

        for(int i = 0; i < room.getL(); i++) {
            for (int j = 0; j < room.getC(); j++) {
                     float x = 0, y = 0;
                Sprite sprite = terrain[i][j].getSprite();
                //     if(!camera.frustum.pointInFrustum(isoTo2d(sprite))){//TODO FRUSTUM
                         x = j;
                         y = i;
                         setIsometricCoordinatesRenderType2D(sprite, x, y);
                         terrain[i][j].draw(spriteBatch);
                   //  }
            }
        }
    }

    private void setIsometricCoordinatesRenderType2D(Sprite sprite, float x, float y) {

        float finalX, finalY;
        finalX = x - y;
        finalY = x + y;
        finalY /= 2;
        sprite.setX(finalX);
        sprite.setY(finalY);
      //  System.out.println(sprite.getX() + "_" + sprite.getY());

    }

    public static Vector3 isoTo2d(float x, float y){

        return new Vector3( (2*y +x)/2, (2*y - x)/2, 0);

    }

    public static Vector3 orthoToiso(float x, float y){
        return new Vector3(x - y, (x + y)/2, 0);
    }

    protected void drawGameObjects(GameObject gameObjects[][]) {

        for (int i = 0; i < room.getL(); i++) {
            for (int j = 0; j < room.getC(); j++) {
                if (gameObjects[i][j] != null) {
                    if (gameObjects[i][j].getHP() <= 0)
                        gameObjects[i][j] = null;
                    else {
                        GameObject gameObject = gameObjects[i][j];
                        Sprite sprite = ((RenderType2D) (gameObjects[i][j])).getSprite();
                        setIsometricCoordinatesRenderType2D(sprite, j - 0.3f, i - 0.7f);
                        RenderType2D presentation = (RenderType2D) gameObjects[i][j];
                        presentation.draw(spriteBatch);
                    }
                }
            }
        }
    }


    public static void setIsometricCoordinatesRenderType2D(RenderType2D isometricCoordinatesGameObject){

        if(isometricCoordinatesGameObject != null) {
            Sprite sprite = isometricCoordinatesGameObject.getSprite();
            if (isometricCoordinatesGameObject.getRealX() == sprite.getX()
                    && isometricCoordinatesGameObject.getRealY() == sprite.getY()) {
                sprite.setX(sprite.getX() - sprite.getY() + sprite.getWidth());
                sprite.setY(((sprite.getX() + sprite.getY()) / 2) + sprite.getHeight());

            }
        }
    }



    @Override
    public void render() {
        camera.update();
        if(viewport != null)
        viewport.apply();
        drawTerrain(room.getTileMap().getTiles());
        room.checkUnactiveObjects();
        drawGameObjects(room.getMap());
    }

    @Override
    public void setRoom(Room room) {
        this.room = room;
    }

}
