package com.mygdx.game.playable;

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

public class Skeleton extends DollDecal {
    public Skeleton(String name, int hp, int capacity, Decal sprite, int movementsPoints, int level,
                    int experience, int strength, int dexterity, int constitution, int initiativebonus,
                    Classification classification, ArrayList<Property> properties) {
        super(name, hp, capacity, sprite, movementsPoints, level, experience, strength, dexterity, constitution,
                initiativebonus, classification, properties);
    }
    public Skeleton(){

        super("Skeleton", 4,0, Decal.newDecal(1,1,
                new TextureRegion(NewTexturePack.skeleton), true),
                7, 1, 135,
                14,14,0,
                6, Classification.Nonplayable, new ArrayList<Property>());

        equipArmor(new LeatherArmor());
        equipWeapon(new IronSword());
        addProperty(new BluntResistProperty());

    }
    {//TODO контроллер скелета
        setController(new SimpleTestController(this));
    }

}
