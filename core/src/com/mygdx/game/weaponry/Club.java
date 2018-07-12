package com.mygdx.game.weaponry;

import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.interfaces.Weapon;

/**
 * Created by Даниил on 19.09.2017.
 */
public class Club implements Weapon {

    private String name = "Club";
    private int damage = 7;

    @Override
    public void makeDamage(GameObject dealer, GameObject gainer) {

        gainer.takeDamage(dealer);

    }

    @Override
    public void show() {


    }

    @Override
    public int getPenetration() {
        return 0;
    }

    @Override
    public int getDamage() {
        return damage;
    }
}
