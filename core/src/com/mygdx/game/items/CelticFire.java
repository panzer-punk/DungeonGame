package com.mygdx.game.items;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.ai.controller.AIController;
import com.mygdx.game.build.Room;
import com.mygdx.game.enumerations.Classification;
import com.mygdx.game.enumerations.Direction;
import com.mygdx.game.enumerations.Status;
import com.mygdx.game.interfaces.Armor;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.interfaces.Item;
import com.mygdx.game.interfaces.Weapon;
import com.mygdx.game.objects.Entity;
import com.mygdx.game.playable.Doll;
import com.mygdx.game.tools.BuffPool;
import com.mygdx.game.weaponry.buffs.Buff;

/**
 * Created by Даниил on 04.12.2018.
 */
public class CelticFire extends Entity implements  Item {


    public CelticFire(Sprite sprite) {
        super("Celtic Fire Amulet", sprite);
    }

    @Override
    public void use(GameObject gameObject) {//TODO добавить слоты активных вещей в GameObject

    }

    @Override
    public void drop(Room room, GameObject gameObject) {

        gameObject.deleteItem(this);
        room.setObject(this);

    }

    @Override
    public void takeDamage(GameObject gameObject){

        setHp(0);
        gameObject.putItem(this);

    }

}
