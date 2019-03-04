package com.mygdx.game.particles;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.decals.Decal;
import com.badlogic.gdx.graphics.g3d.decals.DecalBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.build.NewTexturePack;
import com.mygdx.game.particles.movingPatterns.Straight;

/**
 * Created by Даниил on 05.12.2018.
 */
public class ArrowParticle extends MovingParticle {
    Straight direction;
    public ArrowParticle(Vector3 from, Vector3 to) {
        super(Decal.newDecal(0.35f, 0.35f, new TextureRegion(NewTexturePack.arrow), true), 0.05f, from, to);
        direction = new Straight(this, to);
    }

    @Override
    public void draw(DecalBatch decalBatch) {



        System.out.println("SPRITE " + sprite.getX() + "_" + sprite.getZ());


            direction.move();
            decalBatch.add(sprite);




    }
}
