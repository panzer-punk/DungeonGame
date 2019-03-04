package com.mygdx.game.terrain;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.build.NewTexturePack;

public class Floor_mid extends Terrain {
    public Floor_mid() {
        super(2, "Floor -2", NewTexturePack.floor1, false);
    }

    public Floor_mid(int m, String n, Texture texture) {
        super(m, n, texture, false);
    }
}
