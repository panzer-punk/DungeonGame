package com.mygdx.game.playable;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.decals.Decal;
import com.mygdx.game.enumerations.Classification;
import com.mygdx.game.enumerations.Direction;
import com.mygdx.game.enumerations.Status;
import com.mygdx.game.interfaces.*;
import com.mygdx.game.tools.Dice;

import java.util.ArrayList;

/**
 * Created by Даниил on 09.09.2017.
 */
public class Hero extends Doll {


    public Hero(String name, int hp, int capacity, Decal sprite, int movementsPoints,
                int level, int experience, int strength, int dexterity, int constitution,
                int initiativebonus, Classification classification, ArrayList<Property> properties) {

        super(name, hp, capacity, sprite, movementsPoints, level, experience, strength, dexterity, constitution,
                initiativebonus, classification, properties);
        setController(null);//TODO контроллер игрока

    }


}
