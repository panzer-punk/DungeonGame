package com.mygdx.game.interfaces;

import com.mygdx.game.enumerations.AttackType;

/**
 * Created by Даниил on 26.12.2018.
 */
public interface Attack {

    AttackType getType();
    int getDamage();
    void makeSpecialDamage(GameObject target);

}
