package com.mygdx.game.interfaces;

import com.mygdx.game.enumerations.AttackType;
import com.mygdx.game.enumerations.WeaponType;

/**
 * Created by Даниил on 26.12.2018.
 */
public interface Property {

    int updateDamage(int dmg);
    String getName();
    AttackType getAttackType();
    WeaponType getWeaponType();

}
