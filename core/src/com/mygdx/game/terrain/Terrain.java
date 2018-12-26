package com.mygdx.game.terrain;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.decals.Decal;
import com.badlogic.gdx.graphics.g3d.decals.DecalBatch;

/**
 * Created by Даниил on 13.04.2018.
 */
public class Terrain{

    private Decal sprite;
    private int movementCost;
    private int movementPrice = 0;
    public String name;
    public boolean flag;
    private  boolean killFlag;
    private float x, y;

    public Terrain(int m, String n, TextureRegion texture, boolean k ){

        movementCost = m;
        sprite = Decal.newDecal(1,1,texture,false);
      //  sprite.setSize(1,1);//debug code
        name = n;
        sprite.rotateX(90);
        flag = false;
        killFlag = k;

    }

    public Terrain(int m, String n, Decal sprite){

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
    public Decal getSprite(){return sprite;}
    public void setSprite(Decal sprite){this.sprite = sprite;}
    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
        sprite.setPosition(x, -0.5f, y + 0.5f);
    }

    public void draw(ModelBatch modelBatch, DecalBatch decalBatch){
        decalBatch.add(sprite);
    }

}
