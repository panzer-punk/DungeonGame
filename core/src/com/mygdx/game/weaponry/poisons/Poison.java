package com.mygdx.game.weaponry.poisons;

import com.mygdx.game.tools.Dice;
import com.mygdx.game.weaponry.WeaponryStuff;
import com.mygdx.game.weaponry.attacks.D4Attack;

public abstract class Poison extends WeaponryStuff {

    public Poison(String name){

        super(name,null,0, new D4Attack());

    }

}
