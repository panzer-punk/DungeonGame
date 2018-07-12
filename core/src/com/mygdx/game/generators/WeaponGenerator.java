package com.mygdx.game.generators;

import com.mygdx.game.weaponry.Club;
import com.mygdx.game.weaponry.IronSword;
import com.mygdx.game.interfaces.Weapon;
import com.mygdx.game.weaponry.WoodenSword;

/**
 * Created by Даниил on 11.09.2017.
 */
public class WeaponGenerator {

    public Weapon createWeapon(){

        Weapon weapon = null;

        int rand = (int) ((Math.random()*3) + 1);

        switch (rand){

            case 1:
                weapon = new IronSword();
            break;

            case 2:
                weapon = new WoodenSword();
                break;
            case 3:
                weapon = new Club();
                break;
        }



      return weapon;
    }

}
