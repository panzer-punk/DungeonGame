package com.mygdx.game.particles.movingPatterns;


import com.badlogic.gdx.graphics.g3d.decals.Decal;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.enumerations.Direction;
import com.mygdx.game.particles.MovingParticle;

import static com.mygdx.game.enumerations.Direction.*;

/**
 * Created by Даниил on 22.12.2018.
 */
public class Straight {

    private float x, y;
    private Direction directionHorizontal, directionVertical;
    private float a,b,c;

    private MovingParticle particle;

    public Straight(MovingParticle particle, Vector3 to) {
        this.particle = particle;
        this.x = particle.getX();
        this.y = particle.getY();

        a = (y - to.z);
        b = (to.x - x);
        c = (x*to.z - to.x*y);

        if(to.x < x)
            directionHorizontal = LEFT;
        else
            directionHorizontal = RIGHT;

        if(to.z < y)
            directionVertical = UP;
        else
            directionVertical = DOWN;

    }


    public void move(){

        Decal tmp = particle.getSprite();

        if(b != 0) {
            if (directionHorizontal == LEFT)
                x -= particle.getMovingSpeed();
            else
                x += particle.getMovingSpeed();
        }


        float newY = -((a*x)/b + c);

        if(!Float.isInfinite(newY))
            y = newY;




        tmp.setX(x);
        tmp.setZ(y);
        particle.updateCoords(x,y);

        System.out.println(tmp.getX() + "_" + tmp.getY() + "_" + tmp.getZ());


    }

    public  Direction getDirectionHorizontal(){return directionHorizontal;}

}
