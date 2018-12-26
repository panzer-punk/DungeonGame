package com.mygdx.game.terrain;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.build.NewTexturePack;

public class Floor_min extends Terrain {
    public Floor_min() {
        super(1, "Floor ", NewTexturePack.floor, false);
    }

    public Floor_min(int m, String n, TextureRegion texture) {
        super(m, n, texture, false);
    }
}
