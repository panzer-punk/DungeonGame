package com.mygdx.game.interfaces;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g3d.decals.DecalBatch;

/**
 * Created by Даниил on 05.12.2018.
 */
public interface Particle {

    void draw(DecalBatch decalBatch);
    boolean isActive();
    void dispose();

}
