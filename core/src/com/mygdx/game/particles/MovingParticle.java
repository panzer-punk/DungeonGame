package com.mygdx.game.particles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g3d.decals.Decal;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.enumerations.Direction;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.interfaces.Particle;
import com.mygdx.game.systems.GameScreenManager;

/**
 * Created by Даниил on 05.12.2018.
 */
public abstract class MovingParticle implements Particle {//TODO добавить Polygon к каждому GameObject и свой метод draw

    Direction direction;
    Decal sprite;
    float movingSpeed;
    Vector3  from, to;
    Polygon currentPos, toPos;

    public MovingParticle(Decal sprite, float movingSpeed, Vector3 from, Vector3 to) {
        this.sprite = sprite;
        sprite.setPosition(from.x, 0.5f, from.z);
        sprite.rotateX(90);
        System.out.println("from: " + from.x + "_" + from.y + "_" + from.z);
        this.movingSpeed = movingSpeed;
        currentPos = new Polygon(new float[]{0f, 0f, sprite.getWidth()*0.55f, sprite.getHeight()*0.55f, 0f, sprite.getHeight()});
        currentPos.setPosition(from.x, from.z);
        currentPos.setOrigin(from.x + sprite.getX(), from.z + sprite.getZ() + 1.5f);
        toPos = new Polygon(new float[]{0f, 0f, 1 + 1*0.55f, 1 + 1*0.55f, 0f, 1});
        toPos.setPosition(to.x, to.z);
        this.from = from;
        this.to = to;
    }

    public void updateCoords(float x, float y){

        currentPos.setPosition(x, y);

    }

    @Override
    public void dispose(){//обнуляем ссылки на объекты, чтобы сборщик мусора убрался


        sprite = null;
        currentPos = null;
        to = null;
        toPos = null;
        from = null;

    }



    @Override
    public final boolean isActive(){

        return (!Intersector.overlapConvexPolygons(currentPos, toPos) && (currentPos.getX() > 0 && currentPos.getY() > 0));
    }

    public float getX(){return sprite.getX();}
    public float getY(){return sprite.getZ();}
    public float getZ() {return sprite.getY();}

    public Decal getSprite(){return sprite;}

    public float getMovingSpeed(){return movingSpeed;}

}
