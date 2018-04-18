package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.io.Serializable;

/**
 * Created by Даниил on 13.04.2018.
 */
public class Terrain{

    private Texture texture;
    private int movementCost;
    public String name;

    public Terrain(int m, String n, Texture texture){

        movementCost = m;
        this.texture = texture;
        name = n;

    }

    public void draw(SpriteBatch batch, int x, int y){batch.draw(texture, x * 50, y * 50);}

    public int getMovementCost(){return movementCost;}


}
