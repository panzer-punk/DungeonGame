package com.mygdx.game.weaponry.meleeweapon;

import com.mygdx.game.enumerations.WeaponType;
import com.mygdx.game.tools.Dice;
import com.mygdx.game.weaponry.WeaponryStuff;

import static com.mygdx.game.enumerations.WeaponType.*;

/**
 * Created by Даниил on 19.09.2017.
 */
public class Club extends WeaponryStuff {


    public Club(String label, WeaponType type, int distance) {
        super(label, type, distance);
    }

    public Club(){
        super("Club", BLUNT,1);
    }


    @Override
    public int getDamage() {
        return Dice.d4();
    }
}
