package com.mygdx.game.terrain;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.decals.Decal;
import com.badlogic.gdx.graphics.g3d.decals.DecalBatch;
import com.mygdx.game.graphics.RenderType2D;

/**
 * Created by Даниил on 13.04.2018.
 */
public class Terrain implements RenderType2D{

    private Sprite sprite;
    private int movementCost;
    private int movementPrice = 0;
    public String name;
    public boolean flag;
    private  boolean killFlag;
    private float x, y;

    public Terrain(int m, String n, Texture texture, boolean k ){

        movementCost = m;
        sprite = new Sprite(texture);
        sprite.setSize(2,1);//TODO ISOMETRIC TERRAIN
        sprite.flip(false, true);
      //  sprite.setSize(1,1);//debug code
        name = n;
        flag = false;
        killFlag = k;

    }

    public Terrain(int m, String n, Sprite sprite){

        movementCost = m;
        this.sprite = sprite;
       // this.sprite.setSize(1,1);
        name = n;

    }


    public boolean getKillFlag(){return killFlag;}

   // public void draw(SpriteBatch batch){sprite.draw(batch);}

    public int getMovementCost(){return movementCost;}
    public void setMovementPrice(int m){

        if(m < movementPrice || movementPrice == 0)
        movementPrice = m;

    }
    public int getMovementPrice(){return movementPrice;}

    @Override
    public void draw(SpriteBatch spriteBatch) {

        sprite.draw(spriteBatch);

    }

    @Override
    public Sprite getSprite() {
        return sprite;
    }

    @Override
    public float getRealX() {
        return x;
    }

    @Override
    public float getRealY() {
        return y;
    }


    public void setSprite(Sprite sprite){this.sprite = sprite;}
    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
        sprite.setPosition(x, y);
    }


}
