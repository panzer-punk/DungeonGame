package com.mygdx.game.weaponry.meleeweapon;

import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.interfaces.Weapon;
import com.mygdx.game.tools.Dice;
import com.mygdx.game.weaponry.WeaponryStuff;

/**
 * Created by Даниил on 19.09.2017.
 */
public class Club extends WeaponryStuff {


    public Club(String label, int type, int distance) {
        super(label, type, distance);
    }

    public Club(){
        super("Club",0,1);
    }


    @Override
    public int getDamage() {
        return Dice.d4();
    }
}
