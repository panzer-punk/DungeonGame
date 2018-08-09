package com.mygdx.game.playable;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.armor.LeatherArmor;
import com.mygdx.game.enumerations.Classification;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.tools.BuffPool;
import com.mygdx.game.weaponry.SpiderBite;

public class Spider extends Doll {
    public Spider(String name, int hp, int capacity, Sprite sprite, int movementsPoints, int level, int experience, int strength, int dexterity, int constitution, int initiativebonus, Classification classification) {
        super(name, hp, capacity, sprite, movementsPoints, level, experience, strength, dexterity, constitution, initiativebonus, classification);
    }

    public Spider (Sprite sprite){

        super("Spider", 10, 0, sprite, 10, 1,
                0, 16, 14,14,
                3, Classification.Nonplayable);
        this.equipWeapon(new SpiderBite());
        equipArmor(new LeatherArmor());

    }


}
