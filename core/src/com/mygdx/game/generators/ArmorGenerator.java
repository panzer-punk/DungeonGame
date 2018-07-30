package com.mygdx.game.generators;

import com.mygdx.game.interfaces.Armor;
import com.mygdx.game.armor.LeatherArmor;
import com.mygdx.game.armor.ChainArmor;
import com.mygdx.game.armor.IronArmor;

/**
 * Created by Даниил on 11.09.2017.
 */
public class ArmorGenerator {

    public Armor createArmor(){

    	Armor armor = null;

        int rand = (int) ((Math.random()*3) + 1);

        switch (rand){

            case 1:
                armor = new LeatherArmor();
            break;

            case 2:
                armor = new ChainArmor();
                break;
            case 3:
                armor = new IronArmor();
                break;
        }



      return armor;
    
    }

}
