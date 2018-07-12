package com.mygdx.game.weaponry;

import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.interfaces.Weapon;
import com.mygdx.game.tools.Dice;

/**
 * Created by Даниил on 09.09.2017.
 */
public class IronSword implements Weapon {

    private int type = 1;
    private int distance = 1;


    @Override
    public void makeDamage(GameObject dealer, GameObject gainer) {

        gainer.takeDamage(dealer);

    }

    @Override
    public void show() {

        System.out.println("Iron sword: " + type +", dis: " + distance);

    }

    @Override
    public int getType() {
        return type;
    }

    @Override
    public int getDamage() {
        return Dice.d8();
    }//returns damage fro dice roll

    @Override
    public int getDistance() {return distance; }
}
