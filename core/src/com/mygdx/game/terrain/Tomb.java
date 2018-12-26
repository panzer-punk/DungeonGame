package com.mygdx.game.terrain;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.build.NewTexturePack;

/**
 * Created by Даниил on 03.12.2018.
 */
public class Tomb extends Terrain {
    public Tomb(Texture texture) {
        super(3, "Tomb", NewTexturePack.tomb1, false);
    }

    public Tomb(int m, String n, TextureRegion texture) {
        super(m, n, texture, false);
    }
}
