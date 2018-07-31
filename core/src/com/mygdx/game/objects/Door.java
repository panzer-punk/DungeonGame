package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.build.Room;
import com.mygdx.game.interfaces.GameObject;

public class Door extends Entity {

    private Room r1, r2;


    public Door(String n, Sprite s, Room r1, Room r2) {
        super(n, s);
        this.r1 = r1;
        this.r2 = r2;
    }

    @Override
    public void takeDamage(GameObject gameObject){


       GameObject temp = r1.remove(gameObject.getX(), gameObject.getY());
       r2.setObject(temp);


    }

    public Room getNextRoom(Room from){

        if(from == r1)
            return r2;
        else
            return r1;

    }

    public void changeRoom(){

        Room r = r1;
        r1 = r2;
        r2 = r;
    }

}
