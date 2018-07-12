package com.mygdx.game.armor;

import com.mygdx.game.interfaces.Armor;

/**
 * Created by Даниил on 09.09.2017.
 */
public class LeatherArmor implements Armor {

    private final int armor = 3;
    private final int armorclass = 1;

    @Override
    public int getArmor() {
        return armor;
    }

    @Override
    public void show() {

        System.out.println("Leather Armor: " + ", armor: " + armor);

    }

    @Override
    public int getArmorClass() {
        return armorclass;
    }
}
