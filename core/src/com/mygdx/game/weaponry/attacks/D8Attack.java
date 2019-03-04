package com.mygdx.game.weaponry.attacks;

import com.mygdx.game.tools.Dice;

/**
 * Created by Даниил on 26.12.2018.
 */
public class D8Attack  extends SimpleAttack{
    @Override
    public int getDamage() {
        return Dice.d8();
    }
}
