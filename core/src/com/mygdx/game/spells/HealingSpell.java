package com.mygdx.game.spells;

import com.mygdx.game.interfaces.Item;

/**
 * Created by Даниил on 09.09.2017.
 */
public class HealingSpell implements Item {

    int points = 10;

    @Override
    public int use() {
        return points;
    }

    @Override
    public void show() {

        System.out.println("Healing spell: " + points);

    }
}
