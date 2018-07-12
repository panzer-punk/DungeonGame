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

/**
 * Created by Даниил on 09.09.2017.
 */
public class Hero implements GameObject {

    private Sprite sprite;
    private int initiative;
    private String name;
    private Classification classification;
    private Status status;
    private Direction direction;
    private int hp;
    private int movementsPoints, toReset;
    private int level;
    private int experience;
    private int x, y;
    private int itemNumber;
    private Weapon weapon;
    private Armor armor;
    private Item[] backpack;

    public Hero(String name, int hp, int capacity, Sprite sprite, int movementsPoints, int level, int experience){

        this.name = name;
        this.hp = hp;
        this.sprite = sprite;

        direction = null;
        status = Status.OK;
        classification = Classification.Playable;

        itemNumber = 0;
        backpack = new Item[capacity];

        this.movementsPoints = movementsPoints;
        this.level = level;
        this.experience = experience;
        toReset = movementsPoints;
        //debug code
        initiative = 2;

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
    public void takeDamage(GameObject dealer) {

        if(dealer.getWeapon().getPenetration() >= this.getArmor().getPenetration())
            hp -= dealer.getWeapon().getDamage();

        System.out.println("You took " + dealer.getWeapon().getDamage() + " damage");

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
}
