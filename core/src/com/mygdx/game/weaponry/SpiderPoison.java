package com.mygdx.game.weaponry;

import com.mygdx.game.tools.Dice;

public class SpiderPoison extends Poison {

    public SpiderPoison (){

        super("Spider Poison");

    }

    @Override
    public int getDamage() {
        return Dice.d4();
    }
}
