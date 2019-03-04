package com.mygdx.game.playable;

import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.decals.Decal;
import com.badlogic.gdx.graphics.g3d.decals.DecalBatch;
import com.mygdx.game.ai.controller.AIController;
import com.mygdx.game.enumerations.Classification;
import com.mygdx.game.enumerations.Direction;
import com.mygdx.game.enumerations.Status;
import com.mygdx.game.graphics.RenderType3D;
import com.mygdx.game.interfaces.*;
import com.mygdx.game.tools.BuffPool;
import com.mygdx.game.weaponry.buffs.Buff;

import java.util.ArrayList;


/**
 * Created by Даниил on 15.07.2018.
 */
public  class DollDecal extends Doll
        implements RenderType3D {

    private Decal decal;


    public DollDecal(String name, int hp, int capacity, Decal sprite,
                     int movementsPoints, int level, int experience,
                     int strength, int dexterity, int constitution,
                     int initiativebonus, Classification classification, ArrayList <Property> properties){

      super(name,hp, capacity,
         movementsPoints,  level,  experience,
         strength,  dexterity,  constitution,
         initiativebonus, classification, properties);

    }



    @Override
    public void draw(ModelBatch modelBatch, DecalBatch decalBatch, Environment environment) {decalBatch.add(decal);}

    @Override
    public boolean isDecal() {
        return true;
    }

    @Override
    public Decal getDecal() {
        return decal;
    }

    @Override
    public ModelInstance getModelInstance() {
        return null;
    }

    @Override
    public void setXY(int x, int y) {

        this.x = x;
        this.y = y;
        decal.setX(x);
        decal.setY(y);

    }
}
