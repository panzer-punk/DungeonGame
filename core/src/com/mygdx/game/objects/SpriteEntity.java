package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.ai.controller.AIController;
import com.mygdx.game.enumerations.Classification;
import com.mygdx.game.enumerations.Direction;
import com.mygdx.game.enumerations.Status;
import com.mygdx.game.graphics.RenderType2D;
import com.mygdx.game.interfaces.*;
import com.mygdx.game.tools.BuffPool;
import com.mygdx.game.weaponry.buffs.Buff;

import java.util.ArrayList;

/**
 * Created by Даниил on 27.03.2019.
 */
public class SpriteEntity extends Entity
    implements RenderType2D{

    Sprite sprite;

    public SpriteEntity(String name, int hp, int x, int y, Sprite sprite) {
        super(name, hp, x, y);
        this.sprite = sprite;
        sprite.setSize(1,1);
        sprite.flip(false,true);
    }

    @Override
    public void setInitiative(int i) {

    }

    @Override
    public void makeStep(int c) {

    }

    @Override
    public int getMP() {
        return 0;
    }

    @Override
    public void resetMP() {

    }

    @Override
    public int getInitiativebonus() {
        return 0;
    }

    @Override
    public int getInitiative() {
        return 0;
    }

    @Override
    public Status getStatus() {
        return null;
    }

    @Override
    public Direction getDirection() {
        return null;
    }

    @Override
    public void setDirection(Direction direction) {

    }

    @Override
    public void setClassification(Classification classification) {

    }

    @Override
    public void setStatus(Status status) {

    }

    @Override
    public void show() {

    }

    @Override
    public void equipWeapon(Weapon weapon) {

    }

    @Override
    public void equipArmor(Armor armor) {

    }

    @Override
    public void putItem(Item item) {

    }

    @Override
    public void deleteItem(Item item) {

    }

    @Override
    public void takeDamage(GameObject dealer) {

    }

    @Override
    public void takeDamage(Weapon weapon) {

    }

    @Override
    public void takeDamage(int dmg) {

    }

    @Override
    public ArrayList<Property> getProperties() {
        return null;
    }

    @Override
    public Weapon getWeapon() {
        return null;
    }

    @Override
    public Armor getArmor() {
        return null;
    }

    @Override
    public BuffPool getBuffPool() {
        return null;
    }

    @Override
    public void addBuff(Buff buff) {

    }

    @Override
    public Direction getWatchDirection() {
        return null;
    }

    @Override
    public AIController getController() {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDamage() {
        return 0;
    }

    @Override
    public int getStrength() {
        return 0;
    }

    @Override
    public int getDexterity() {
        return 0;
    }

    @Override
    public int getConstitution() {
        return 0;
    }

    @Override
    public int getArmorClass() {
        return 0;
    }

    @Override
    public int getDEX() {
        return 0;
    }

    @Override
    public int getSTR() {
        return 0;
    }

    @Override
    public int getCON() {
        return 0;
    }

    @Override
    public void addProperty(Property property) {

    }

    @Override
    public void setXY(int x, int y) {

        this.x = x;
        this.y = y;
        sprite.setX(x);
        sprite.setY(y);
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
}
