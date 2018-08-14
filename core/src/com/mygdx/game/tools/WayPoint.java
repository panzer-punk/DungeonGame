package com.mygdx.game.tools;

import com.mygdx.game.terrain.Terrain;

/**
 * Created by Даниил on 13.05.2018.
 */
public class WayPoint {

    private Terrain tile;

    public WayPoint(Terrain tile) {
        this.tile = tile;
    }

    public Terrain getTile() {
        return tile;
    }

}
