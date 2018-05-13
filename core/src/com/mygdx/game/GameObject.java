package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Даниил on 09.09.2017.
 */
public interface GameObject {

     void draw(SpriteBatch batch);
     void makeStep(int c);
     int getMP();
     void resetMP();
     int getInitiative();
     Status getStatus();
     Classification getClassification();
     Direction getDirection();
     void setDirection(Direction direction);
     void setClassification(Classification classification);
     void setStatus(Status status);
     Sprite getSprite();
     void setSprite(Sprite sprite);
     int getX();
     int getY();
     void setX(int x);
     void setY(int y);
     void setXY(int x, int y);
     void show();
     void equipWeapon(Weapon weapon);
     void equipArmor(Armor armor);
     void putItem(Item item);
     void takeDamage(GameObject dealer);
     Weapon getWeapon();
     Armor getArmor();
     int getHP();
     Direction getWatchDirection();
     String getName();

}
