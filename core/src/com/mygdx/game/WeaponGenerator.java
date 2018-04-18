package com.mygdx.game;

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
