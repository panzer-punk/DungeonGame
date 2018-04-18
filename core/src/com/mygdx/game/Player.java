package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Даниил on 09.09.2017.
 */
public class Player implements GameObject {

    private Texture texture;
    private String name;
    private int hp;
    private int x, y;
    private int itemNumber;
    private Weapon weapon;
    private Armor armor;
    private Item[] backpack;

    public Player(String name, int hp, int capacity, Texture texture){

        this.name = name;

        this.hp = hp;

        this.texture = texture;

        itemNumber = 0;

        backpack = new Item[capacity];

    }

    @Override
    public void draw(SpriteBatch batch) {batch.draw(texture, x * 50, y * 50);}

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
    public String getName() {
        return name;
    }
}
