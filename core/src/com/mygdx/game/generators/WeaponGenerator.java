package com.mygdx.game.generators;

import com.mygdx.game.weaponry.Club;
import com.mygdx.game.weaponry.IronClub;
import com.mygdx.game.weaponry.IronSword;
import com.mygdx.game.weaponry.Spear;
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
                weapon = new IronSword("Iron Sword",1,1);
            break;

            case 2:
                weapon = new WoodenSword("Wooden Sword", 1, 1);
                break;
            case 3:
                weapon = new Club("Club", 0,1);
                break;
            case 4:
                weapon = new IronClub("IronClub", 0,1);
                break;
            case 5:
                weapon = new Spear("Spear", 1,0);
                break;
        }



      return weapon;
    }

}
