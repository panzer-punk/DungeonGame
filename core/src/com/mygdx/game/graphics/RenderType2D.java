package com.mygdx.game.graphics;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Даниил on 24.01.2019.
 */
public interface RenderType2D {

    void draw(SpriteBatch spriteBatch);
    Sprite getSprite();
    float getRealX();
    float getRealY();
}
