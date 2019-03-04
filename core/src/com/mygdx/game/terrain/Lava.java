package com.mygdx.game.terrain;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.build.NewTexturePack;

public class Lava extends Terrain {

    public Lava() {
        super(1000, "Lava", NewTexturePack.hole, true);
    }

    public Lava(int m, String n, Texture texture) {
        super(m, n, texture, true);
    }
}
