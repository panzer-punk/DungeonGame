package com.mygdx.game.items.spells;

import com.mygdx.game.build.Room;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.interfaces.Item;

/**
 * Created by Даниил on 09.09.2017.
 */
public class HealingSpell implements Item {//TODO добавить спрайт и наследование от Doll или ModelEntity

    int points = 10;

    @Override
    public void use(GameObject gameObject) {

    }

    @Override
    public void drop(Room room, GameObject gameObject) {

    }

    @Override
    public void show() {

        System.out.println("Healing spell: " + points);

    }
}
