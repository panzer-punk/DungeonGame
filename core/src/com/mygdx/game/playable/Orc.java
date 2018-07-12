package com.mygdx.game.playable;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.enumerations.Classification;
import com.mygdx.game.enumerations.Direction;
import com.mygdx.game.enumerations.Status;
import com.mygdx.game.interfaces.Armor;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.interfaces.Item;
import com.mygdx.game.interfaces.Weapon;
import com.mygdx.game.tools.Dice;

/**
 * Created by Даниил on 09.09.2017.
 */
public class Orc implements GameObject {

    private Sprite sprite;//sprite is better
    private String name = "Orc";
    private Classification classification = Classification.Nonplayable;
    private Status status = Status.OK;
    private Direction direction = null;
    private int hp = 8;
    private int DEX = 1, STR = 2, CON = 3, AC = 13;
    private int x, y;
    private int movementPoints = 5, toReset = 5;
    private Weapon weapon;
    private Armor armor;
    private int initative = 3;



    @Override
    public void draw(SpriteBatch batch) {
    sprite.draw(batch);
    }

    @Override
    public void makeStep(int c) {movementPoints -= c;}

    @Override
    public int getMP() {
        return movementPoints;
    }

    @Override
    public void resetMP() {movementPoints = toReset;}

    @Override
    public int getInitiative() {
      return initative;
    }

    @Override
    public Status getStatus() {
        return null;
    }

    @Override
    public Classification getClassification() {
        return null;
    }

    @Override
    public Direction getDirection() {
        return null;
    }

    @Override
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    @Override
    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public Sprite getSprite() {
        return sprite;
    }

    @Override
    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setX(int x) {

        this.x = x;

    }

    @Override
    public void setY(int y) {

        this.y = y;

    }

    @Override
    public void setXY(int x, int y) {

        this.x = x;
        this.y = y;
        sprite.setPosition(x,y);

    }

    @Override
    public void show() {

        System.out.println("Orc: " + hp);

    }

    @Override
    public void equipWeapon(Weapon weapon) {

        this.weapon = weapon;

    }

    @Override
    public void equipArmor(Armor armor) {

        this.armor = armor;

    }

    @Override
    public void putItem(Item item) {



    }

    @Override
    public void takeDamage(GameObject dealer) {
        int d = 0;

        if((dealer.getSTR() + Dice.d20()) >= this.getArmorClass()) {
            d = dealer.getWeapon().getDamage();
            hp -= d;
        }
        System.out.println("You took " + d + " damage");
    }

    @Override
    public Weapon getWeapon() {
        return weapon;
    }

    @Override
    public Armor getArmor() {
        return armor;
    }

    @Override
    public int getHP() {
        return hp;
    }

    @Override
    public Direction getWatchDirection() {
        return null;
    }

    @Override
    public String getName() {
        return name;
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
        return AC;
    }


    @Override
    public int getDEX() {
        return DEX;
    }

    @Override
    public int getSTR() {
        return STR;
    }

    @Override
    public int getCON() {
        return CON;
    }
}
