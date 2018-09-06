package com.mygdx.game.playable;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.armor.LeatherArmor;
import com.mygdx.game.enumerations.Classification;
import com.mygdx.game.weaponry.meleeweapon.Club;

/**
 * Created by Даниил on 09.09.2017.
 */
public class Orc extends Doll {


    public Orc(String name, int hp, int capacity, Sprite sprite, int movementsPoints,
               int level, int experience, int strength, int dexterity,
               int constitution, int initiativebonus, Classification classification) {
        super(name, hp, capacity, sprite, movementsPoints, level, experience, strength, dexterity, constitution, initiativebonus, classification);

    }

    public Orc(Sprite sprite){
        super("Orc", 8,2,sprite,3,1,
                0,15,10,12,
                0, Classification.Nonplayable);

        equipArmor(new LeatherArmor());
        equipWeapon(new Club());
    }

}
