package com.mygdx.game.playable;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.decals.Decal;
import com.mygdx.game.ai.controller.SimpleTestController;
import com.mygdx.game.armor.LeatherArmor;
import com.mygdx.game.build.NewTexturePack;
import com.mygdx.game.enumerations.Classification;
import com.mygdx.game.interfaces.Property;
import com.mygdx.game.weaponry.meleeweapon.Club;

import java.util.ArrayList;

/**
 * Created by Даниил on 09.09.2017.
 */
public class Orc extends DollSprite {

    public Orc(String name, int hp, int capacity, int movementsPoints, int level, int experience,
               int strength, int dexterity, int constitution, int initiativebonus,
               Classification classification, ArrayList<Property> properties, Sprite sprite) {
        super(name, hp, capacity, movementsPoints, level, experience, strength, dexterity, constitution, initiativebonus, classification, properties, sprite);
    }

    public Orc(){
        super("Orc", 6,2,4,1,
                136,16,10,12,
                0, Classification.Nonplayable, new ArrayList<Property>(), new Sprite(NewTexturePack.orc));

        equipArmor(new LeatherArmor());
        equipWeapon(new Club());

    }

    {
        setController(new SimpleTestController(this));
    }

}
