package com.mygdx.game.property;

import com.mygdx.game.interfaces.Property;
import com.mygdx.game.interfaces.Weapon;

/**
 * Created by Даниил on 26.12.2018.
 */
public class AbstractProperty implements Property {

    @Override
    public int updateDamage(int dmg, Weapon weapon) {
        return dmg;
    }

    @Override
    public String getName() {
        return " ";
    }
}
