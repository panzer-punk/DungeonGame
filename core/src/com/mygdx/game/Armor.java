package com.mygdx.game;

/**
 * Created by Даниил on 09.09.2017.
 */
public interface Armor {

    public int getPenetration();

    public void takeDamage(int dmg);

    public int getQuality();

    public void show();
}
