package com.mygdx.game.interfaces;

import com.mygdx.game.interfaces.GameObject;

/**
 * Created by Даниил on 09.09.2017.
 */
public interface Weapon {

    public void makeDamage(GameObject dealer, GameObject gainer);

    public void show();

    public int getPenetration();

    public int getDamage();

}
