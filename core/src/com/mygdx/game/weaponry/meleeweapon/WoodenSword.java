package com.mygdx.game.weaponry.meleeweapon;

import com.mygdx.game.enumerations.WeaponType;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.interfaces.Weapon;
import com.mygdx.game.tools.Dice;
import com.mygdx.game.weaponry.WeaponryStuff;

import static com.mygdx.game.enumerations.WeaponType.*;

/**
 * Created by Даниил on 19.09.2017.
 */
public class WoodenSword extends WeaponryStuff {

    public WoodenSword(String label, WeaponType type, int distance) {
        super(label, type, distance);
    }

    public WoodenSword(){

        super("Wooden Sword", STABBING, 1);

    }

    @Override
    public int getDamage() {
        return Dice.d6();
    }
}
