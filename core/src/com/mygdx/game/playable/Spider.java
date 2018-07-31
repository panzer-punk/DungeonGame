package com.mygdx.game.playable;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.enumerations.Classification;

public class Spider extends Doll {
    public Spider(String name, int hp, int capacity, Sprite sprite, int movementsPoints, int level, int experience, int strength, int dexterity, int constitution, int initiativebonus, Classification classification) {
        super(name, hp, capacity, sprite, movementsPoints, level, experience, strength, dexterity, constitution, initiativebonus, classification);
    }

    public Spider (Sprite sprite){

        super("Spider", 10, 0, sprite, 10, 1,
                0, 16, 14,14,
                3, Classification.Nonplayable);

    }

}
