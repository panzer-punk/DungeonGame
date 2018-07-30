package com.mygdx.game.armor;

import com.mygdx.game.interfaces.Armor;
import com.mygdx.game.interfaces.GameObject;

/**
 * Created by Даниил on 23.07.2018.
 */
public class IronArmor extends Clothing {

	public IronArmor(int armor, int armorclass, String label) {
		super(armor, armorclass, label);
	}

	public IronArmor(){
		super(3,2,"Iron Armor");
	}

}
