package com.mygdx.game.levels;

import com.mygdx.game.build.GameObjectPack;
import com.mygdx.game.build.Map;
import com.mygdx.game.build.Room;
import com.mygdx.game.build.TexturePack;
import com.mygdx.game.terrain.TerrainPack;

/**
 * Created by Даниил on 02.12.2018.
 */
public class RoomFountain extends Room {
    public RoomFountain(TerrainPack terrainPack, TexturePack texturePack, GameObjectPack gameObjectPack) {
        super(6,6, new Map(6,6, null));

       Map map = getTileMap();

        map.addTile(terrainPack.getLava(),     0,0);
        map.addTile(terrainPack.getLava(),     1,0);
        map.addTile(terrainPack.getLava(),     2,0);
        map.addTile(terrainPack.getLava(),     3,0);
        map.addTile(terrainPack.getFloor_min(),4,0);
        map.addTile(terrainPack.getLava(),     5,0);
        map.addTile(terrainPack.getLava(),     0,1);
        map.addTile(terrainPack.getFloor_min(),1,1);
        map.addTile(terrainPack.getFloor_min(),2,1);
        map.addTile(terrainPack.getFloor_min(),3,1);
        map.addTile(terrainPack.getFloor_min(),4,1);
        map.addTile(terrainPack.getFloor_min(),5,1);
        map.addTile(terrainPack.getLava(),     0,2);
        map.addTile(terrainPack.getFloor_min(),1,2);
        map.addTile(terrainPack.getFloor_min(),2,2);
        map.addTile(terrainPack.getFloor_min(),3,2);
        map.addTile(terrainPack.getFloor_min(),4,2);
        map.addTile(terrainPack.getFloor_min(),5,2);
        map.addTile(terrainPack.getLava(),     0,3);
        map.addTile(terrainPack.getFloor_min(),1,3);
        map.addTile(terrainPack.getFloor_min(),2,3);
        map.addTile(terrainPack.getFloor_min(),3,3);
        map.addTile(terrainPack.getFloor_min(),4,3);
        map.addTile(terrainPack.getFloor_min(),5,3);
        map.addTile(terrainPack.getLava(),     0,4);
        map.addTile(terrainPack.getFloor_min(),1,4);
        map.addTile(terrainPack.getFloor_min(),2,4);
        map.addTile(terrainPack.getFloor_min(),3,4);
        map.addTile(terrainPack.getFloor_min(),4,4);
        map.addTile(terrainPack.getFloor_min(),5,4);
        map.addTile(terrainPack.getFloor_min(),0,5);
        map.addTile(terrainPack.getFloor_min(),1,5);
        map.addTile(terrainPack.getFloor_min(),2,5);
        map.addTile(terrainPack.getFloor_min(),3,5);
        map.addTile(terrainPack.getFloor_min(),4,5);
        map.addTile(terrainPack.getFloor_min(),5,5);
    }
}
