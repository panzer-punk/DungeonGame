package com.mygdx.game.weaponry;

import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.interfaces.Weapon;
import com.mygdx.game.tools.BuffPool;
import com.mygdx.game.tools.Dice;

/**
 * Created by Даниил on 09.09.2017.
 */
public class IronSword extends WeaponryStuff {

    public IronSword(String label, int type, int distance) {
        super(label, type, distance);
    }

    public IronSword(){
        super("IronSword",1,1);

    }


    @Override
    public int getDamage() {
        return Dice.d8();
    }
}
