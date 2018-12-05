package com.mygdx.game.particles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.enumerations.Direction;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.interfaces.Particle;
import com.mygdx.game.systems.GameScreenManager;

/**
 * Created by Даниил on 05.12.2018.
 */
public abstract class MovingParticle implements Particle {//TODO добавить Polygon к каждому GameObject и свой метод draw

    Direction direction;
    Sprite sprite;
    float movingSpeed;
    Vector2  from, to;
    Polygon currentPos, toPos;

    public MovingParticle(Sprite sprite, float movingSpeed, Vector2 from, Vector2 to) {
        this.sprite = sprite;
        sprite.setY(from.x);
        sprite.setX(from.y);
        sprite.setSize(0.75f, 0.75f);
        sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
        sprite.setFlip(false, true);
        this.movingSpeed = movingSpeed;
        currentPos = new Polygon(new float[]{0f, 0f, sprite.getWidth()*0.55f, sprite.getHeight()*0.55f, 0f, sprite.getHeight()});
        currentPos.setPosition(from.x, from.y);
        currentPos.setOrigin(from.x + sprite.getOriginX(), from.y + sprite.getOriginY() + 1.5f);
        toPos = new Polygon(new float[]{0f, 0f, 1 + 1*0.55f, 1 + 1*0.55f, 0f, 1});
        toPos.setPosition(to.x, to.y);
        this.from = from;
        this.to = to;
    }

    @Override
    public void draw(Batch batch){

       // System.out.println("DRAW PARTICLE");

        float angle = to.angle(from);
        System.out.println(angle);
        if(isActive()) {

            if(angle < 0 && angle >= -90){
                updateCoords(currentPos.getX() - movingSpeed * Gdx.graphics.getDeltaTime(), currentPos.getY() - movingSpeed * Gdx.graphics.getDeltaTime());
            }else if(angle == 0){
                updateCoords(currentPos.getX(), currentPos.getY() - movingSpeed * Gdx.graphics.getDeltaTime());
            }
            else if(angle < -90 && angle >= -135){
                updateCoords(currentPos.getX() + movingSpeed * Gdx.graphics.getDeltaTime(), currentPos.getY() - movingSpeed * Gdx.graphics.getDeltaTime());
            }else if(angle < -135 && angle >= -180){
                updateCoords(currentPos.getX() + movingSpeed * Gdx.graphics.getDeltaTime(), currentPos.getY());
            }
         /*   switch ((int) to.angle(from)){



                case 0:
                    updateCoords(currentPos.getX() - movingSpeed * Gdx.graphics.getDeltaTime(), currentPos.getY());
                   break;
                case -45:
                    updateCoords(currentPos.getX() - movingSpeed * Gdx.graphics.getDeltaTime(), currentPos.getY() - movingSpeed * Gdx.graphics.getDeltaTime());
                    break;
                case -90:
                    updateCoords(currentPos.getX(), currentPos.getY() - movingSpeed * Gdx.graphics.getDeltaTime());
                    break;
                case -135:
                    updateCoords(currentPos.getX() + movingSpeed * Gdx.graphics.getDeltaTime(), currentPos.getY() - movingSpeed * Gdx.graphics.getDeltaTime());
                    break;
                case -180:
                    updateCoords(currentPos.getX() + movingSpeed * Gdx.graphics.getDeltaTime(), currentPos.getY());
                    break;
            }*/
            sprite.setRotation(angle);
            sprite.setPosition(currentPos.getX(), currentPos.getY());
            sprite.draw(batch);
        }

    }

    protected void updateCoords(float x, float y){

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

}
