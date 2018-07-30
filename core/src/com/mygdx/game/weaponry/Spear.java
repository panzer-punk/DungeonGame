package com.mygdx.game.weaponry;

import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.interfaces.Weapon;
import com.mygdx.game.tools.Dice;

/**
 * Created by Даниил on 20.07.2018.
 */

public class Spear extends WeaponryStuff {
	
	public Spear(String label, int type, int distance) {
        super(label, type, distance);
    }

    public Spear(){ //Default

	   super("Spear",1,2);

    }

    @Override
    public int getDamage() {
        return Dice.d6();
    }

}
