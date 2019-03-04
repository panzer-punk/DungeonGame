package com.mygdx.game.property;

import com.mygdx.game.enumerations.AttackType;
import com.mygdx.game.enumerations.WeaponType;
import com.mygdx.game.interfaces.Property;
import com.mygdx.game.interfaces.Weapon;

/**
 * Created by Даниил on 26.12.2018.
 */
public abstract class AbstractProperty implements Property {

    @Override
    public int updateDamage(int dmg) {
        return dmg;
    }

    @Override
    public String getName() {
        return " ";
    }

    @Override
    public abstract AttackType getAttackType();

    @Override
    public abstract WeaponType getWeaponType();
}
