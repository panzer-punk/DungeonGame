package com.mygdx.game.playable;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.enumerations.Classification;
import com.mygdx.game.interfaces.Property;

import java.util.ArrayList;

/**
 * Created by Даниил on 20.02.2019.
 */
public class Test2DDoll extends DollSprite {
    public Test2DDoll(String name, int hp, int capacity, int movementsPoints, int level,
                      int experience, int strength, int dexterity, int constitution, int initiativebonus,
                      Classification classification, ArrayList<Property> properties, Sprite sprite) {
        super(name, hp, capacity, movementsPoints, level,
                experience, strength, dexterity, constitution,
                initiativebonus, classification, properties, sprite);
    }
}
