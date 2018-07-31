package com.mygdx.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.build.Room;
import com.mygdx.game.interfaces.GameObject;

public class Door extends Entity {

    private Room r1, r2;
    private int x2, y2;
    private boolean isClone, flag;
    private Door door;


    public Door(Texture texture,Room r1, Room r2) {
        super("Door", new Sprite(texture));
        this.r1 = r1;
        this.r2 = r2;
        isClone = false;
        flag = false;
        door = new Door(new Sprite(texture),r2,r1,true);

    }

    public Door(Sprite s, Room r1, Room r2, boolean isClone){
        super("Door", s);
        this.r1 = r1;
        this.r2 = r2;
        this.isClone = isClone;
        door = null;
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



        if(!isClone && !flag)
        r2.setObject(door);

        flag = true;
    }


}
