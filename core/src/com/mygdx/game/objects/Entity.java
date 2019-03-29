package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.decals.Decal;
import com.badlogic.gdx.graphics.g3d.decals.DecalBatch;
import com.mygdx.game.ai.controller.AIController;
import com.mygdx.game.enumerations.Classification;
import com.mygdx.game.enumerations.Direction;
import com.mygdx.game.enumerations.Status;
import com.mygdx.game.interfaces.*;
import com.mygdx.game.screens.GameScreen;
import com.mygdx.game.tools.BuffPool;
import com.mygdx.game.weaponry.buffs.Buff;

import java.util.ArrayList;

import static com.mygdx.game.enumerations.Classification.OBJECT;

/**
 * Created by Даниил on 20.02.2019.
 */
public abstract class Entity  implements GameObject {
    protected  String name;
    protected int hp;
    protected int x, y;
    protected int maxHP;

    public Entity(String name, int hp, int x, int y) {
        this.name = name;
        this.hp = hp;
        maxHP = hp;
        this.x = x;
        this.y = y;
    }

    @Override
    public final Classification getClassification() {
        return OBJECT;
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public final void setX(int x) {this.x = x;}

    @Override
    public final void setY(int y) {this.y = y;}

    @Override
    public abstract void setXY(int x, int y);

    @Override
    public int getHP() {
        return hp;
    }

    @Override
    public void setHp(int hp) {this.hp = hp;}

    @Override
    public int getMaxHP(){return maxHP;}

    @Override
    public int getMaxMP(){return 0;}


}
