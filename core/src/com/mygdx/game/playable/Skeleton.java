package com.mygdx.game.playable;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.decals.Decal;
import com.mygdx.game.ai.controller.SimpleTestController;
import com.mygdx.game.armor.LeatherArmor;
import com.mygdx.game.build.NewTexturePack;
import com.mygdx.game.enumerations.Classification;
import com.mygdx.game.interfaces.Property;
import com.mygdx.game.property.BluntResistProperty;
import com.mygdx.game.weaponry.meleeweapon.IronSword;

import java.util.ArrayList;

public class Skeleton extends DollSprite {
    public Skeleton(String name, int hp, int capacity, int movementsPoints, int level, int experience, int strength,
                    int dexterity, int constitution, int initiativebonus,
                    Classification classification, ArrayList<Property> properties, Sprite sprite) {
        super(name, hp, capacity, movementsPoints, level, experience, strength, dexterity, constitution,
                initiativebonus, classification, properties, sprite);
    }

    public Skeleton(){

        super("Skeleton", 5,5,
                4, 1, 135,
                14,14,8,
                6, Classification.Nonplayable,
                new ArrayList<Property>(), new Sprite(NewTexturePack.skeleton));

        equipArmor(new LeatherArmor());
        equipWeapon(new IronSword());
        addProperty(new BluntResistProperty());

    }
    {//TODO контроллер скелета
        setController(new SimpleTestController(this));
    }

}
