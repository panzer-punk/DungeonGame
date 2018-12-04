package com.mygdx.game.levels;

import com.mygdx.game.build.Map;
import com.mygdx.game.build.Room;
import com.mygdx.game.terrain.TerrainPack;

/**
 * Created by Даниил on 03.12.2018.
 */
public class ArtifactRoom extends Room {
    public ArtifactRoom(TerrainPack terrainPack) {
        super(6,8, new Map(6,8, terrainPack.getLava()));

        Map map = getTileMap();

        map.addTile(terrainPack.getFloor_min(),0,0);
        map.addTile(terrainPack.getFloor_min(),0,1);
        map.addTile(terrainPack.getFloor_min(),0,2);
        map.addTile(terrainPack.getFloor_min(),0,3);
        map.addTile(terrainPack.getFloor_min(),0,4);
        map.addTile(terrainPack.getFloor_min(),0,5);
        map.addTile(terrainPack.getFloor_min(),0,6);
        map.addTile(terrainPack.getFloor_min(),0,7);

        map.addTile(terrainPack.getFloor_min(),1,0);
        map.addTile(terrainPack.getFloor_min(),1,1);
        map.addTile(terrainPack.getFloor_min(),1,2);
        map.addTile(terrainPack.getFloor_min(),1,3);
        map.addTile(terrainPack.getFloor_min(),1,4);
        map.addTile(terrainPack.getFloor_min(),1,5);
        map.addTile(terrainPack.getFloor_min(),1,6);
        map.addTile(terrainPack.getFloor_min(),1,7);

        map.addTile(terrainPack.getFloor_min(),5,0);
        map.addTile(terrainPack.getFloor_min(),5,1);
        map.addTile(terrainPack.getFloor_min(),5,2);
        map.addTile(terrainPack.getFloor_min(),5,3);
        map.addTile(terrainPack.getFloor_min(),5,4);
        map.addTile(terrainPack.getFloor_min(),5,5);
        map.addTile(terrainPack.getFloor_min(),5,6);
        map.addTile(terrainPack.getFloor_min(),5,7);

        map.addTile(terrainPack.getTomb(),     2,2);
        map.addTile(terrainPack.getTomb(),     3,2);
        map.addTile(terrainPack.getTomb(),     4,2);
        map.addTile(terrainPack.getTomb(),2,3);
        map.addTile(terrainPack.getTomb(),3,3);
        map.addTile(terrainPack.getTomb(),4,3);
        map.addTile(terrainPack.getTomb(),2,4);
        map.addTile(terrainPack.getTomb(),3,4);
        map.addTile(terrainPack.getTomb(),4,4);
        map.addTile(terrainPack.getTomb(),2,5);
        map.addTile(terrainPack.getTomb(),3,5);
        map.addTile(terrainPack.getTomb(),4,5);
        map.addTile(terrainPack.getFloor_min(),2,7);
        map.addTile(terrainPack.getFloor_min(),3,7);
        map.addTile(terrainPack.getFloor_min(),4,7);

        map.addTile(terrainPack.getFloor_min(),2,0);
        map.addTile(terrainPack.getFloor_min(),3,0);
        map.addTile(terrainPack.getFloor_min(),4,0);
        map.addTile(terrainPack.getFloor_min(),5,0);
        map.addTile(terrainPack.getFloor_min(),2,6);
        map.addTile(terrainPack.getFloor_min(),3,6);
        map.addTile(terrainPack.getFloor_min(),4,6);
        map.addTile(terrainPack.getFloor_min(),5,6);

        map.addTile(terrainPack.getFloor_mid(), 2, 1);
        map.addTile(terrainPack.getFloor_mid(), 3, 1);
        map.addTile(terrainPack.getFloor_mid(), 4, 1);
        map.addTile(terrainPack.getFloor_mid(), 2, 6);
        map.addTile(terrainPack.getFloor_mid(), 3, 6);
        map.addTile(terrainPack.getFloor_mid(), 4, 6);
    }
}
