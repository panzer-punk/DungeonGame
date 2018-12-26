package com.mygdx.game.weaponry.meleeweapon;

import com.mygdx.game.enumerations.WeaponType;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.interfaces.Weapon;
import com.mygdx.game.tools.BuffPool;
import com.mygdx.game.tools.Dice;
import com.mygdx.game.weaponry.WeaponryStuff;

import static com.mygdx.game.enumerations.WeaponType.*;

/**
 * Created by Даниил on 09.09.2017.
 */
public class IronSword extends WeaponryStuff {

    public IronSword(String label, WeaponType type, int distance) {
        super(label, type, distance);
    }

    public IronSword(){
        super("IronSword", STABBING,1);

    }


    @Override
    public int getDamage() {
        return Dice.d8();
    }
}
