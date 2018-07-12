package com.mygdx.game.armor;

import com.mygdx.game.interfaces.Armor;

/**
 * Created by Даниил on 09.09.2017.
 */
public class LeatherArmor implements Armor {

    int penetration = 3;
    int quality = 10;

    @Override
    public int getPenetration() {

        return penetration;
    }

    @Override
    public void takeDamage(int dmg) {

        if(quality > 0)
            quality -= dmg;
        else if(penetration > 0)
            penetration--;

    }

    @Override
    public int getQuality() {
        return quality;
    }

    @Override
    public void show() {

        System.out.println("Leather Armor: " + penetration + ", quality: " + quality);

    }
}
