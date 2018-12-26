package com.mygdx.game.terrain;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.build.NewTexturePack;

/**
 * Created by Даниил on 07.10.2018.
 */
public class Dirt extends Terrain {
    public Dirt() {
        super(1, "Dirt", NewTexturePack.dirt, false);
    }

    public Dirt(int m, String n, TextureRegion texture) {
        super(m, n, texture, false);
    }
}
