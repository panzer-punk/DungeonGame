package com.mygdx.game.terrain;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.build.NewTexturePack;

/**
 * Created by Даниил on 14.08.2018.
 */
public class Sand extends Terrain {
    public Sand() {
        super(2, "Sand", NewTexturePack.sand, false);
    }

    public Sand(int m, String n, TextureRegion texture) {
        super(m, n, texture, false);
    }
}
