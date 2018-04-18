package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

/**
 * Created by Даниил on 09.09.2017.
 */
public interface GameObject {

    Directions watchDirection = null;

    public void draw(SpriteBatch batch);
    public int getX();
    public int getY();
    public void setX(int x);
    public void setY(int y);
    public void setXY(int x, int y);
    public void show();
    public void equipWeapon(Weapon weapon);
    public void equipArmor(Armor armor);
    public void putItem(Item item);
    public void takeDamage(GameObject dealer);
    public Weapon getWeapon();
    public Armor getArmor();
    public int getHP();
    public String getName();

}
