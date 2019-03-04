package com.mygdx.game.terrain;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.build.NewTexturePack;
import com.mygdx.game.graphics.RenderType2D;

/**
 * Created by Даниил on 20.02.2019.
 */
public class Test2DDirt extends  Terrain{

    public Test2DDirt() {
        super(1, "Test", NewTexturePack.tomb1, false);
    }

    public Test2DDirt(int m, String n, Sprite sprite) {
        super(m, n, sprite);
    }

}
