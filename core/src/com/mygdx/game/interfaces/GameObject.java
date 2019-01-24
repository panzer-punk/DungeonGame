package com.mygdx.game.interfaces;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.decals.Decal;
import com.badlogic.gdx.graphics.g3d.decals.DecalBatch;
import com.mygdx.game.ai.controller.AIController;
import com.mygdx.game.enumerations.Classification;
import com.mygdx.game.enumerations.Direction;
import com.mygdx.game.enumerations.Status;
import com.mygdx.game.tools.BuffPool;
import com.mygdx.game.weaponry.buffs.Buff;

import java.util.ArrayList;

/**
 * Created by Даниил on 09.09.2017.
 */
public interface GameObject {

    // void draw(SpriteBatch batch);
     void setInitiative(int i);
     void makeStep(int c);
     int getMP();
     void resetMP();
     int getInitiativebonus();
     int getInitiative();
     Status getStatus();
     Classification getClassification();
     Direction getDirection();
     void setDirection(Direction direction);
     void setClassification(Classification classification);
     void setStatus(Status status);
     Decal getSprite();
     void setSprite(Decal sprite);
     int getX();
     int getY();
     void setX(int x);
     void setY(int y);
     void setXY(int x, int y);
     void show();
     void equipWeapon(Weapon weapon);
     void equipArmor(Armor armor);
     void putItem(Item item);
     void deleteItem(Item item);
     void takeDamage(GameObject dealer);//для создания дверей и ловушек использовать GameObject
     void takeDamage(Weapon weapon);
     void takeDamage(int dmg);
     ArrayList<Property> getProperties();
     Weapon getWeapon();
     Armor getArmor();
     int getHP();
     void setHp(int hp);
     BuffPool getBuffPool();
     void addBuff(Buff buff);
     Direction getWatchDirection();
     AIController getController();
     String getName();
     int getDamage();
     int getStrength();
     int getDexterity();
     int getConstitution();
     int getArmorClass();
     int getDEX();
     int getSTR();
     int getCON();
    // void draw(ModelBatch modelBatch, DecalBatch decalBatch);
     void addProperty(Property property);

}
