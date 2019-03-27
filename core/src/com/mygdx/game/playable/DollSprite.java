package com.mygdx.game.playable;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.enumerations.Classification;
import com.mygdx.game.graphics.IsometricRender;
import com.mygdx.game.graphics.RenderType2D;
import com.mygdx.game.interfaces.Property;

import java.util.ArrayList;

/**
 * Created by Даниил on 20.02.2019.
 */
public class DollSprite extends Doll
        implements RenderType2D {

    protected Sprite sprite;

    public DollSprite(String name, int hp, int capacity, int movementsPoints, int level, int experience,
                      int strength, int dexterity, int constitution, int initiativebonus,
                      Classification classification, ArrayList<Property> properties, Sprite sprite) {
        super(name, hp, capacity, movementsPoints, level, experience,
                strength, dexterity, constitution,
                initiativebonus, classification, properties);
        this.sprite = sprite;
        sprite.setSize(1,1);
        sprite.flip(false, true);
    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        sprite.draw(spriteBatch);
    }

    @Override
    public Sprite getSprite() {
        return sprite;
    }

    @Override
    public float getRealX() {
        return x;
    }

    @Override
    public float getRealY() {
        return y;
    }

    @Override
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
        sprite.setX(x);
        sprite.setY(y);
    }

}
