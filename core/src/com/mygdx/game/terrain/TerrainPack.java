package com.mygdx.game.terrain;

import com.mygdx.game.build.TexturePack;

public class TerrainPack {

    private TexturePack texturePack;

    public TerrainPack(TexturePack texturePack) {

        this.texturePack = texturePack;

    }

    public Terrain getLava(){

        return new Lava(texturePack.getHole());

    }

    public Terrain getFloor_min(){

        return new Floor_min(texturePack.getFloor_min());

    }

    public  Terrain getFloor_mid(){

        return new Floor_mid(texturePack.getFloor_mid());

    }

    public Terrain getById(int id){

        Terrain t = null;

        switch (id){

            case 1:
                t = getFloor_min();
                break;

            case 2:
                t = getFloor_mid();
                break;

            case 3:
                t = getLava();
                break;


        }

        return t;

    }
}
