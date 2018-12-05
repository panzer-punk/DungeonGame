package com.mygdx.game.interfaces;

import com.badlogic.gdx.graphics.g2d.Batch;

/**
 * Created by Даниил on 05.12.2018.
 */
public interface Particle {

    void draw(Batch batch);
    boolean isActive();
    void dispose();

}
