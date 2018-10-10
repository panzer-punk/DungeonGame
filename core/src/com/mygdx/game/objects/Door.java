package com.mygdx.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.build.Room;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.screens.GameScreen;
import com.mygdx.game.systems.DialogManager;
import com.mygdx.game.systems.RoomManager;

public class Door extends Entity {

    private Room link, holder;


    public Door(Texture texture, Room link, Room holder) {
        super("Door", new Sprite(texture));
        this.link = link;
        this.holder = holder;

    }


    @Override
    public void takeDamage(GameObject gameObject){


       GameObject temp = holder.remove(gameObject.getX(), gameObject.getY());
       link.setObject(temp);
        RoomManager.moveToRoom(link);


    }



}
