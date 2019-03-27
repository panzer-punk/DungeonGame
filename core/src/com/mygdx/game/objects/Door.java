package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g3d.Model;
import com.mygdx.game.build.NewTexturePack;
import com.mygdx.game.build.Room;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.systems.RoomManager;

public class Door extends SpriteEntity {



    private Room link, holder;


    public Door(Model model, Room link, Room holder) {
        super("Door", 5,0,0, new Sprite(NewTexturePack.door));
        this.link = link;
        this.holder = holder;

    }


    @Override
    public void takeDamage(GameObject gameObject){


       GameObject temp = holder.remove((int)gameObject.getX(), (int)gameObject.getY());
       link.setObject(temp);
        RoomManager.moveToRoom(link);


    }



}
