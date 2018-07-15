package com.mygdx.game.armor;

import com.mygdx.game.interfaces.Armor;

/**
 * Created by Даниил on 15.07.2018.
 */
public abstract class Clothing implements Armor {

    private final int armor;
    private final int armorclass;
    private final String label;

    protected Clothing(int armor, int armorclass, String label) {
        this.armor = armor;
        this.armorclass = armorclass;
        this.label = label;
    }

    @Override
    public final int getArmor() {
        return armor;
    }

    @Override
    public void show() {

        System.out.println(label + " " + ", armor: " + armor + "(" + armorclass + ")");
    }

    @Override
    public final int getArmorClass() {
        return armorclass;
    }
}
