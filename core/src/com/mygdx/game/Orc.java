package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Даниил on 09.09.2017.
 */
public class Orc implements GameObject {

    private Texture texture = new Texture("C:/Users/Даниил/Desktop/orc.png");
    private String name = "Orc";
    private int hp = 25;
    private int x, y;
    private Weapon weapon;
    private Armor armor;



    @Override
    public void draw(SpriteBatch batch) {
    batch.draw(texture, x * 50, y * 50);
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

        if(dealer.getWeapon().getPenetration() >= this.getArmor().getPenetration())
            hp -= dealer.getWeapon().getDamage();

        System.out.println("Orc took " + dealer.getWeapon().getDamage() + " damage");

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
