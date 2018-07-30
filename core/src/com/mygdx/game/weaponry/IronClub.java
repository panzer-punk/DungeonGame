package com.mygdx.game.weaponry;

import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.interfaces.Weapon;
import com.mygdx.game.tools.Dice;

/**
 * Created by Даниил on 20.07.2018.
 */

public class IronClub extends WeaponryStuff {


	public IronClub(String label, int type, int distance) {
	        super(label, type, distance);
	    }

	    public IronClub(){
	    super("IronClub",0,1);
        }

	    @Override
	    public void makeDamage(GameObject dealer, GameObject gainer) {

	    }

	    @Override
	    public int getDamage() {
	        return Dice.d8();
	    }
}
