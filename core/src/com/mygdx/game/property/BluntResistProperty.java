package com.mygdx.game.property;



import com.mygdx.game.interfaces.Weapon;

import static com.mygdx.game.enumerations.WeaponType.*;

/**
 * Created by Даниил on 26.12.2018.
 */
public class BluntResistProperty extends AbstractProperty {

    @Override
    public int updateDamage(int dmg, Weapon weapon) {

        if(weapon.getType() == STABBING)
            dmg -= 4;

        return dmg;

    }

    @Override
    public String getName() {
        return "Blunt resist";
    }
}
