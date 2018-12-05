package com.mygdx.game.particles;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Даниил on 05.12.2018.
 */
public class ArrowParticle extends MovingParticle {
    public ArrowParticle(Sprite sprite, Vector2 from, Vector2 to) {
        super(sprite, 9f, from, to);
    }
}
