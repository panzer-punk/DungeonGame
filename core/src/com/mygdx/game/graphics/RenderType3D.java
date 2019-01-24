package com.mygdx.game.graphics;

import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.decals.DecalBatch;

/**
 * Created by Даниил on 24.01.2019.
 */
public interface RenderType3D {

    void draw(ModelBatch modelBatch, DecalBatch decalBatch, Environment environment);
}
