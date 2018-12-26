package com.mygdx.game.terrain;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.build.NewTexturePack;

/**
 * Created by Даниил on 14.08.2018.
 */
public class Water extends Terrain {
    public Water() {
        super(5, "Water", NewTexturePack.water, false);
    }

    public Water(int m, String n, TextureRegion texture) {
        super(m, n, texture, false);
    }
}
