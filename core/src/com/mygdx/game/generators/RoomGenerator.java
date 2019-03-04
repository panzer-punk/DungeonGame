package com.mygdx.game.generators;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.build.Map;
import com.mygdx.game.build.Room;
import com.mygdx.game.terrain.Terrain;
import com.mygdx.game.build.TexturePack;
import com.mygdx.game.terrain.TerrainPack;

/**
 * Created by Даниил on 01.06.2018.
 */
public class RoomGenerator {

    TexturePack texturePack;
    TerrainPack terrainPack;

    public RoomGenerator(TexturePack texturePack) {

        this.texturePack = texturePack;
        terrainPack = new TerrainPack(texturePack);

    }


}
