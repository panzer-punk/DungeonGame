package com.mygdx.game.weaponry.meleeweapon;

import com.mygdx.game.enumerations.WeaponType;
import com.mygdx.game.interfaces.Attack;
import com.mygdx.game.tools.Dice;
import com.mygdx.game.weaponry.WeaponryStuff;
import com.mygdx.game.weaponry.attacks.D4Attack;

import static com.mygdx.game.enumerations.WeaponType.*;

/**
 * Created by Даниил on 19.09.2017.
 */
public class Club extends WeaponryStuff {


    public Club(String label, WeaponType type, int distance, Attack attack) {
        super(label, type, distance, attack);
    }

    public Club(){
        super("Club", BLUNT,1, new D4Attack());
    }



}
