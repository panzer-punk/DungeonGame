package com.mygdx.game.levels;

import com.mygdx.game.build.GameObjectPack;
import com.mygdx.game.build.Location;
import com.mygdx.game.build.Room;
import com.mygdx.game.build.TexturePack;
import com.mygdx.game.objects.Door;
import com.mygdx.game.screens.GameScreen;
import com.mygdx.game.terrain.TerrainPack;

import java.util.Stack;

/**
 * Created by Даниил on 02.12.2018.
 */
public class DemoLevelsLocation{

    RoomIntrance roomIntrance;
    RoomOrcIntrance orcIntrance;
    RoomFountain roomFountain;
    ArtifactRoom artifactRoom;

    public DemoLevelsLocation(TexturePack texturePack,TerrainPack terrainPack, GameObjectPack gameObjectPack, GameScreen gameScreen) {


        roomIntrance = new RoomIntrance(terrainPack, texturePack, gameObjectPack);
        roomFountain = new RoomFountain(terrainPack, texturePack, gameObjectPack);
        orcIntrance = new RoomOrcIntrance(terrainPack, texturePack, gameObjectPack);
        artifactRoom = new ArtifactRoom(terrainPack);

        roomIntrance.setObject(1,3, gameObjectPack.getObjectById(6));

        orcIntrance.setObject(0,2,new Door(texturePack.getDoor(),roomFountain, orcIntrance));
        orcIntrance.setObject(0,3,new Door(texturePack.getDoor(),roomFountain, orcIntrance));

        orcIntrance.setObject(0,0, gameObjectPack.getObjectById(5));
        orcIntrance.setObject(0,1, gameObjectPack.getObjectById(5));
        orcIntrance.setObject(0,4, gameObjectPack.getObjectById(5));
        orcIntrance.setObject(0,5, gameObjectPack.getObjectById(5));
        orcIntrance.setObject(0,6, gameObjectPack.getObjectById(5));
        orcIntrance.setObject(1,0, gameObjectPack.getObjectById(5));
        orcIntrance.setObject(3,6, gameObjectPack.getObjectById(5));
        orcIntrance.setObject(4,6, gameObjectPack.getObjectById(5));
        orcIntrance.setObject(5,6, gameObjectPack.getObjectById(5));


        roomFountain.setObject(5,3, gameObjectPack.getObjectById(5));
        roomFountain.setObject(5,2, gameObjectPack.getObjectById(5));
        roomFountain.setObject(5,1, gameObjectPack.getObjectById(5));
        roomFountain.setObject(5,0, gameObjectPack.getObjectById(5));
        roomFountain.setObject(0,0, gameObjectPack.getObjectById(5));
        roomFountain.setObject(0,1, gameObjectPack.getObjectById(5));
        roomFountain.setObject(0,4, gameObjectPack.getObjectById(5));
        roomFountain.setObject(0,3, gameObjectPack.getObjectById(5));
        roomFountain.setObject(0,2, gameObjectPack.getObjectById(5));
        roomFountain.setObject(1,0, gameObjectPack.getObjectById(5));
        roomFountain.setObject(2,0, gameObjectPack.getObjectById(5));
        roomFountain.setObject(3,0, gameObjectPack.getObjectById(5));
        roomFountain.setObject(3,2, gameObjectPack.getObjectById(4));
        roomFountain.setObject(5,4, new Door(texturePack.getDoor(),orcIntrance,roomFountain));
        roomFountain.setObject(5,5, new Door(texturePack.getDoor(),orcIntrance,roomFountain));
        roomFountain.setObject(4,0, new Door(texturePack.getDoor(), artifactRoom, roomFountain));

        artifactRoom.setObject(0,0,gameObjectPack.getObjectById(5));
        artifactRoom.setObject(0,1,gameObjectPack.getObjectById(5));
        artifactRoom.setObject(0,2,gameObjectPack.getObjectById(5));
        artifactRoom.setObject(0,4,gameObjectPack.getObjectById(5));
        artifactRoom.setObject(0,5,gameObjectPack.getObjectById(5));
        artifactRoom.setObject(0,6,gameObjectPack.getObjectById(5));
        artifactRoom.setObject(0,7,gameObjectPack.getObjectById(5));
        artifactRoom.setObject(1,0,gameObjectPack.getObjectById(5));
        artifactRoom.setObject(2,0,gameObjectPack.getObjectById(5));
        artifactRoom.setObject(3,0,gameObjectPack.getObjectById(5));
        artifactRoom.setObject(4,0,gameObjectPack.getObjectById(5));
        artifactRoom.setObject(5,0,gameObjectPack.getObjectById(5));
        artifactRoom.setObject(5,1,gameObjectPack.getObjectById(5));
        artifactRoom.setObject(5,2,gameObjectPack.getObjectById(5));
        artifactRoom.setObject(5,3,gameObjectPack.getObjectById(5));
        artifactRoom.setObject(5,4,gameObjectPack.getObjectById(5));
        artifactRoom.setObject(5,5,gameObjectPack.getObjectById(5));
        artifactRoom.setObject(5,6,gameObjectPack.getObjectById(5));
        artifactRoom.setObject(5,7,gameObjectPack.getObjectById(5));
        artifactRoom.setObject(1,7,gameObjectPack.getObjectById(5));
        artifactRoom.setObject(2,7,gameObjectPack.getObjectById(5));
        artifactRoom.setObject(3,7,gameObjectPack.getObjectById(5));
        artifactRoom.setObject(4,7,gameObjectPack.getObjectById(5));
        artifactRoom.setObject(0,3, new Door(texturePack.getDoor(), roomFountain, artifactRoom));
        artifactRoom.setObject(4,2, gameObjectPack.getObjectById(6));
        artifactRoom.setObject(4,5, gameObjectPack.getObjectById(6));
        roomIntrance.setObject(3,0, new Door(texturePack.getDoor(), orcIntrance, roomIntrance));
    }

    public Room getMainRoom(){return roomIntrance;}
}
