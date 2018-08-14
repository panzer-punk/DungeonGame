package com.mygdx.game.build;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.terrain.Terrain;

/**
 * Created by Даниил on 13.04.2018.
 */
public class Map{

    private Terrain tiles[][];
    private Terrain defaultTerrain;//пустые поля должны быть закрашены по дефолту
    private int l, c;
    private int capacity;

    public Map(int l, int c, Terrain d){

        this.l = l;
        this.c = c;
        defaultTerrain = d;
        capacity = l*c;
        tiles = new Terrain[l][c];

    }

    public void addTile(Terrain t){

        Sprite sprite;

        if(capacity > 0) {
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < c; j++) {
                    if (tiles[i][j] == null && t != null) {
                        tiles[i][j] = t;
                        t = null;
                        sprite = tiles[i][j].getSprite();
                        sprite.setPosition(i, j);
                        tiles[i][j].setSprite(sprite);
                        break;
                    }
                }


            }
            capacity--;
        }

    }

    public void draw(SpriteBatch batch){

        Sprite sprite;

        for(int i = 0; i < l; i++){
            for (int j = 0; j < c; j++) {

                if(tiles[i][j] == null) {
                  //  defaultTerrain.draw(batch, i, j);
                    tiles[i][j] = defaultTerrain;
                    sprite = tiles[i][j].getSprite();
                    sprite.setPosition(i, j);
                    tiles[i][j].setSprite(sprite);
                    tiles[i][j].draw(batch);
                }else {
                    sprite = tiles[i][j].getSprite();
                    sprite.setPosition(i, j);
                    tiles[i][j].setSprite(sprite);
                    tiles[i][j].draw(batch);
                }
            }

        }

    }
    public void addTile(Terrain t, int x, int y){tiles[x][y] = t;}
    public Terrain getDefaultTerrain(){return defaultTerrain;}
    public Terrain[][] getTiles(){return tiles;}

    public int getL() {
        return l;
    }

    public int getC() {
        return c;
    }
}
