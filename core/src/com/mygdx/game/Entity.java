package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Даниил on 27.04.2018.
 */
public class Entity implements GameObject {

    private Sprite sprite;
    private String name;
    private int x, y;
    final Classification classification = Classification.OBJECT;

    public Entity(String n, Sprite s){name = n;sprite = s;}

    @Override
    public void draw(SpriteBatch batch) {sprite.draw(batch);}

    @Override
    public void makeStep(int c) {}

    @Override
    public int getMP() {return 0;}

    @Override
    public void resetMP() {}

    @Override
    public int getInitiative() {return 0;}

    @Override
    public Status getStatus() {return null;}

    @Override
    public Classification getClassification() {return classification;}

    @Override
    public Direction getDirection() {return null;}

    @Override
    public void setDirection(Direction direction) {}

    @Override
    public void setClassification(Classification classification) {}

    @Override
    public void setStatus(Status status) {}

    @Override
    public Sprite getSprite() {return sprite;}

    @Override
    public void setSprite(Sprite sprite) {this.sprite = sprite;}

    @Override
    public int getX() {return x;}

    @Override
    public int getY() {return y;}

    @Override
    public void setX(int x) {sprite.setX(x); this.x = x;}

    @Override
    public void setY(int y) {sprite.setY(y); this.y = y;}

    @Override
    public void setXY(int x, int y) {

        this.x = x;
        this. y = y;
        sprite.setPosition(x,y);

    }

    @Override
    public void show() {}

    @Override
    public void equipWeapon(Weapon weapon) {}
    @Override
    public void equipArmor(Armor armor) {}

    @Override
    public void putItem(Item item) {}

    @Override
    public void takeDamage(GameObject dealer) {}

    @Override
    public Weapon getWeapon() {return null;}

    @Override
    public Armor getArmor() {return null;}

    @Override
    public int getHP() {return 1;}

    @Override
    public Direction getWatchDirection() {return null;}

    @Override
    public String getName() {return name;}
}
