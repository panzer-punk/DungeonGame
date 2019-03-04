package com.mygdx.game.playable;

import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.decals.Decal;
import com.badlogic.gdx.graphics.g3d.decals.DecalBatch;
import com.mygdx.game.ai.controller.AIController;
import com.mygdx.game.enumerations.Classification;
import com.mygdx.game.enumerations.Direction;
import com.mygdx.game.enumerations.Status;
import com.mygdx.game.interfaces.*;
import com.mygdx.game.tools.BuffPool;
import com.mygdx.game.weaponry.buffs.Buff;

import java.util.ArrayList;

/**
 * Created by Даниил on 20.02.2019.
 */
public abstract class Doll  implements GameObject {
    protected BuffPool buffPool;
    protected int initiativebonus;
    protected String name;
    protected Classification classification;
    protected Status status;
    protected Direction direction;
    protected int hp;
    protected int initiative;
    protected int strength, dexterity, constitution;
    protected int STR, DEX, CON;
    protected int movementsPoints, toReset;
    protected int level;
    protected int experience;
    protected int x, y;
    protected int armorclass;
    protected int capacity;
    protected Weapon weapon;
    protected Armor armor;
    protected ArrayList<Item> backpack;
    protected AIController controller;
    protected ArrayList<Property> properties;

    public Doll(String name, int hp, int capacity,
                     int movementsPoints, int level, int experience,
                     int strength, int dexterity, int constitution,
                     int initiativebonus, Classification classification, ArrayList <Property> properties){

        this.name = name;
        this.hp = hp;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;

        STR = (strength - 10)/2;
        DEX = (dexterity - 10)/2;
        CON = (constitution - 10)/2;

        direction = null;
        status = Status.OK;
        setClassification(classification);

        backpack = new ArrayList<Item>();

        buffPool = new BuffPool();
        this.capacity = capacity;

        this.movementsPoints = movementsPoints;
        this.level = level;
        this.experience = experience;
        toReset = movementsPoints;
        //debug code
        this.initiativebonus = initiativebonus + DEX;
        this.properties = properties;

    }


    void setController(AIController controller){this.controller = controller;}

    @Override
    public void deleteItem(Item item){

        backpack.remove(item);

    }


    @Override
    public void setHp(int hp){this.hp = hp;}

    @Override
    public final AIController getController(){return controller;}

   /* @Override
    public void draw(SpriteBatch batch) {
        if(movementsPoints == 0)
            sprite.setColor(1,1,9,80);
        sprite.draw(batch);

    }*/

    @Override
    public void setInitiative(int i){

        initiative = initiativebonus + i;

    }

    @Override
    public int getInitiative(){
        return initiative;
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
    public int getInitiativebonus() {return initiativebonus;}

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
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public final void setX(int x) {this.x = x;}

    @Override
    public final void setY(int y) {this.y = y;}

    @Override
    public abstract void setXY(int x, int y);

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
        System.out.println("You've picked:");
        item.show();
        if(backpack.size() < capacity) {
            backpack.add(item);

        }

    }

    @Override
    public  void takeDamage(GameObject dealer) {

        //используется для дверей и ловушек



    }

    @Deprecated
    @Override
    public void takeDamage(Weapon weapon) {



    }

    @Override
    public final void takeDamage(int dmg) {

        hp -= dmg;
    }

    @Override
    public ArrayList<Property> getProperties() {
        return properties;
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
    public BuffPool getBuffPool() {
        return buffPool;
    }

    @Override
    public void addBuff(Buff buff) {

        buffPool.add(buff);

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
    public int getDamage() {
        return-1;
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


    @Override
    public void addProperty(Property property)
    {properties.add(property);}
}
