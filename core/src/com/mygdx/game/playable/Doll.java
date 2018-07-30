package com.mygdx.game.playable;

import com.badlogic.gdx.graphics.Texture;
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
 * Created by Даниил on 15.07.2018.
 */
public abstract class Doll implements GameObject {

    private Sprite sprite;
    private int initiative;
    private String name;
    private Classification classification;
    private Status status;
    private Direction direction;
    private int hp;
    private int strength, dexterity, constitution;
    private int STR, DEX, CON;
    private int movementsPoints, toReset;
    private int level;
    private int experience;
    private int x, y;
    private int armorclass;
    private int itemNumber;
    private Weapon weapon;
    private Armor armor;
    private Item[] backpack;

    public Doll(String name, int hp, int capacity, Sprite sprite,
                int movementsPoints, int level, int experience,
                int strength, int dexterity, int constitution,
                int initiativebonus, Classification classification){

        this.name = name;
        this.hp = hp;
        this.sprite = sprite;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;

        STR = (strength - 10)/2;
        DEX = (dexterity - 10)/2;
        CON = (constitution - 10)/2;

        direction = null;
        status = Status.OK;
        setClassification(classification);

        itemNumber = 0;
        backpack = new Item[capacity];

        this.movementsPoints = movementsPoints;
        this.level = level;
        this.experience = experience;
        toReset = movementsPoints;
        //debug code
        initiative = initiativebonus + DEX;

    }


    @Override
    public void draw(SpriteBatch batch) {
        if(movementsPoints == 0)
            sprite.setColor(1,1,9,80);
        sprite.draw(batch);

    }

    @Override
    public void makeStep(int c) {movementsPoints -= c;}

    @Override
    public int getMP() {
        return movementsPoints;
    }

    @Override
    public void resetMP() {movementsPoints = toReset;}

    @Override
    public int getInitiative() {return initiative;}

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public Classification getClassification() {
        return classification;
    }

    @Override
    public Direction getDirection() {
        return direction;
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
    public final void setX(int x) {

        this.x = x;

    }

    @Override
    public final void setY(int y) {

        this.y = y;

    }

    @Override
    public final void setXY(int x, int y) {

        this.x = x;
        this. y = y;
        sprite.setPosition(x,y);

    }

    @Override
    public void show() {

        System.out.println(name + "\n______\n" + "Health: " + hp);

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

        if(itemNumber < backpack.length)
            backpack[itemNumber++] = item;

    }

    @Override
    public final void takeDamage(GameObject dealer) {
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
        return strength;
    }

    @Override
    public int getDexterity() {
        return dexterity;
    }

    @Override
    public int getConstitution() {
        return constitution;
    }

    @Override
    public int getArmorClass() {return (armor.getArmorClass() + DEX + 10); }

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
