package com.mygdx.game.weaponry.attacks;

import com.mygdx.game.enumerations.AttackType;
import com.mygdx.game.interfaces.Attack;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.tools.Dice;

import static com.mygdx.game.enumerations.AttackType.*;

/**
 * Created by Даниил on 26.12.2018.
 */
public abstract class SimpleAttack implements Attack {
    @Override
    public AttackType getType() {
        return NO_EFFECTS;
    }

    @Override
    public abstract int getDamage();

    @Override
    public void makeSpecialDamage(GameObject target) {}
}
