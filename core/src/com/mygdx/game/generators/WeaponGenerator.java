package com.mygdx.game.generators;


import com.mygdx.game.weaponry.meleeweapon.Club;
import com.mygdx.game.weaponry.meleeweapon.IronClub;
import com.mygdx.game.weaponry.meleeweapon.IronSword;


import com.mygdx.game.weaponry.meleeweapon.Spear;
import com.mygdx.game.interfaces.Weapon;

import com.mygdx.game.weaponry.meleeweapon.WoodenSword;

/**
 * Created by Даниил on 11.09.2017.
 */
public class WeaponGenerator {

    public Weapon createWeapon(){

        Weapon weapon = null;

        int rand = (int) ((Math.random()*5) + 1);

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
            case 4:
                weapon = new IronClub();
                break;
            case 5:
                weapon = new Spear();
                break;
        }



      return weapon;
    }

}
