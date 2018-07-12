package com.mygdx.game.generators;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.build.Map;
import com.mygdx.game.build.Room;
import com.mygdx.game.build.Terrain;

/**
 * Created by Даниил on 01.06.2018.
 */
public class RoomGenerator {

    public Room generateRoom(int sizeX, int sizeY){

        Map map = generateTileMap(sizeX, sizeY);


        return new Room(sizeX, sizeY, map);
    }

    private Map generateTileMap(int sizeX, int sizeY){

        Map mp = new Map(sizeX, sizeY,new Terrain(1, "test", new Sprite(new Texture(Gdx.files.internal("floor.png")))));

        for(int i = 0; i <= sizeX; i++){
            for (int j = 0; j <= sizeY; j++){

                int rand = (int)(Math.random()*9) + 1;

                switch (rand){
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                        mp.addTile(new Terrain(1, "test", new Sprite(new Texture(Gdx.files.internal("floor.png")))));
                        break;
                    case 6:
                    case 7:
                    case 8:
                        mp.addTile(new Terrain(2, "test", new Sprite(new Texture(Gdx.files.internal("floor1.png")))));
                        break;
                    case 9:
                    case 10:
                        mp.addTile(new Terrain(1, "test", new Texture(Gdx.files.internal("hole.png")), true));
                }

            }
        }

        return mp;
    }

}
