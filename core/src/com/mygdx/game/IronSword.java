package com.mygdx.game;

/**
 * Created by Даниил on 09.09.2017.
 */
public class IronSword implements Weapon {

    int damage = 10;
    int penetrationLevel = 4;

    @Override
    public void makeDamage(GameObject dealer, GameObject gainer) {

        gainer.takeDamage(dealer);

    }

    @Override
    public void show() {

        System.out.println("Iron sword: " + damage +", pen: " + penetrationLevel);

    }

    @Override
    public int getPenetration() {
        return penetrationLevel;
    }

    @Override
    public int getDamage() {
        return damage;
    }
}
