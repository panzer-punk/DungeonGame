package com.mygdx.game.weaponry;

import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.interfaces.Weapon;

/**
 * Created by Даниил on 19.09.2017.
 */
public class WoodenSword implements Weapon {

    private String name = "Wooden sword";
    private int type = 1;
    private int distance = 1;

    @Override
    public void makeDamage(GameObject dealer, GameObject gainer) {

        gainer.takeDamage(dealer);

    }

    @Override
    public void show() {
        //can be empty

    }

    @Override
    public int getType() {return type; }


    @Override
    public int getDamage() {
        return 0;
    }//returns damage from dice roll

    @Override
    public int getDistance() {return distance;}
}
