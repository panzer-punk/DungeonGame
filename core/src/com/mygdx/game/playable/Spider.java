package com.mygdx.game.playable;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g3d.decals.Decal;
import com.mygdx.game.ai.controller.SimpleTestController;
import com.mygdx.game.armor.LeatherArmor;
import com.mygdx.game.build.NewTexturePack;
import com.mygdx.game.enumerations.Classification;
import com.mygdx.game.interfaces.Property;
import com.mygdx.game.weaponry.meleeweapon.SpiderBite;

import java.util.ArrayList;

public class Spider extends Doll {
    public Spider(String name, int hp, int capacity, Decal sprite, int movementsPoints, int level,
                  int experience, int strength, int dexterity, int constitution, int initiativebonus,
                  Classification classification, ArrayList<Property> properties) {
        super(name, hp, capacity, sprite, movementsPoints, level, experience, strength, dexterity,
                constitution, initiativebonus, classification, properties);
    }

    public Spider (){

        super("Spider", 10, 0, Decal.newDecal(1,1,
                NewTexturePack.spider, true), 10, 1,
                0, 16, 14,14,
                3, Classification.Nonplayable, new ArrayList<Property>());
        this.equipWeapon(new SpiderBite());
        equipArmor(new LeatherArmor());


    }

    {//TODO контроллер паука
        setController(new SimpleTestController(this));
    }

}
