package com.mygdx.game.weaponry;

import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.interfaces.Weapon;
import com.mygdx.game.tools.Dice;

/**
 * Created by Даниил on 19.09.2017.
 */
public class WoodenSword extends WeaponryStuff {

    public WoodenSword(String label, int type, int distance) {
        super(label, type, distance);
    }

    @Override
    public void makeDamage(GameObject dealer, GameObject gainer) {

    }

    @Override
    public int getDamage() {
        return Dice.d6();
    }
}
