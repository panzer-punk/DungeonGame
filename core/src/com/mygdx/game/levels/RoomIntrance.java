package com.mygdx.game.levels;

import com.mygdx.game.build.Map;
import com.mygdx.game.build.Room;
import com.mygdx.game.playable.Orc;
import com.mygdx.game.terrain.Terrain;
import com.mygdx.game.terrain.TerrainPack;

/**
 * Created by Даниил on 11.10.2018.
 */
public class RoomIntrance extends Room {

    Map map;


    public RoomIntrance(TerrainPack pack) {

        super(10,7, new Map(10,7, null));

        map = getTileMap();

        map.addTile(pack.getDirt(),0,0);
        map.addTile(pack.getDirt(),1,0);
        map.addTile(pack.getFloor_min(),2,0);
        map.addTile(pack.getFloor_min(),3,0);
        map.addTile(pack.getFloor_min(),4,0);
        map.addTile(pack.getDirt(),5,0);
        map.addTile(pack.getDirt(),6,0);
        map.addTile(pack.getDirt(),7,0);
        map.addTile(pack.getDirt(),8,0);
        map.addTile(pack.getDirt(),8,0);
        map.addTile(pack.getDirt(),9,0);
        map.addTile(pack.getDirt(),0,1);
        map.addTile(pack.getDirt(),1,1);
        map.addTile(pack.getFloor_min(),2,1);
        map.addTile(pack.getFloor_min(),3,1);
        map.addTile(pack.getFloor_min(),4,1);
        map.addTile(pack.getFloor_min(),5,1);
        map.addTile(pack.getDirt(),6,1);
        map.addTile(pack.getDirt(),7,1);
        map.addTile(pack.getDirt(),8,1);
        map.addTile(pack.getDirt(),9,1);
        map.addTile(pack.getDirt(),0,2);
        map.addTile(pack.getDirt(),1,2);
        map.addTile(pack.getDirt(),2,2);
        map.addTile(pack.getDirt(),3,2);
        map.addTile(pack.getDirt(),4,2);
        map.addTile(pack.getDirt(),5,2);
        map.addTile(pack.getDirt(),6,2);
        map.addTile(pack.getDirt(),7,2);
        map.addTile(pack.getDirt(),8,2);
        map.addTile(pack.getDirt(),9,2);
        map.addTile(pack.getDirt(),0,3);
        map.addTile(pack.getDirt(),1,3);
        map.addTile(pack.getDirt(),2,3);
        map.addTile(pack.getDirt(),3,3);
        map.addTile(pack.getDirt(),4,3);
        map.addTile(pack.getDirt(),5,3);
        map.addTile(pack.getDirt(),6,3);
        map.addTile(pack.getDirt(),7,3);
        map.addTile(pack.getDirt(),8,3);
        map.addTile(pack.getDirt(),9,3);
        map.addTile(pack.getDirt(),0,4);
        map.addTile(pack.getDirt(),1,4);
        map.addTile(pack.getDirt(),2,4);
        map.addTile(pack.getDirt(),3,4);
        map.addTile(pack.getDirt(),4,4);
        map.addTile(pack.getDirt(),5,4);
        map.addTile(pack.getDirt(),6,4);
        map.addTile(pack.getDirt(),7,4);
        map.addTile(pack.getDirt(),8,4);
        map.addTile(pack.getDirt(),9,4);
        map.addTile(pack.getDirt(),0,5);
        map.addTile(pack.getDirt(),1,5);
        map.addTile(pack.getDirt(),2,5);
        map.addTile(pack.getDirt(),3,5);
        map.addTile(pack.getDirt(),4,5);
        map.addTile(pack.getDirt(),5,5);
        map.addTile(pack.getDirt(),6,5);
        map.addTile(pack.getDirt(),7,5);
        map.addTile(pack.getDirt(),8,5);
        map.addTile(pack.getDirt(),9,5);
        map.addTile(pack.getDirt(),0,6);
        map.addTile(pack.getDirt(),1,6);
        map.addTile(pack.getDirt(),2,6);
        map.addTile(pack.getDirt(),3,6);
        map.addTile(pack.getDirt(),4,6);
        map.addTile(pack.getDirt(),5,6);
        map.addTile(pack.getDirt(),6,6);
        map.addTile(pack.getDirt(),7,6);
        map.addTile(pack.getDirt(),8,6);
        map.addTile(pack.getDirt(),9,6);




    }

}
