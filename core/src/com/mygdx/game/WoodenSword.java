package com.mygdx.game;

/**
 * Created by Даниил on 19.09.2017.
 */
public class WoodenSword implements Weapon {

    private String name = "Wooden sword";
    private int damage = 5;
    private int penetration = 1;

    @Override
    public void makeDamage(GameObject dealer, GameObject gainer) {

        gainer.takeDamage(dealer);

    }

    @Override
    public void show() {
        //can be empty

    }

    @Override
    public int getPenetration() {
        return penetration;
    }

    @Override
    public int getDamage() {
        return damage;
    }
}
