package com.mygdx.game.playable;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.decals.Decal;
import com.badlogic.gdx.graphics.g3d.decals.DecalBatch;
import com.mygdx.game.ai.controller.AIController;
import com.mygdx.game.enumerations.Classification;
import com.mygdx.game.enumerations.Direction;
import com.mygdx.game.enumerations.Status;
import com.mygdx.game.interfaces.*;
import com.mygdx.game.tools.BuffPool;
import com.mygdx.game.tools.Printer;
import com.mygdx.game.weaponry.buffs.Buff;

import java.util.ArrayList;


/**
 * Created by Даниил on 15.07.2018.
 */
public abstract class Doll implements GameObject {

    private Decal sprite;
    private BuffPool buffPool;
    private int initiativebonus;
    private String name;
    private Classification classification;
    private Status status;
    private Direction direction;
    protected int hp;
    private int initiative;
    private int strength, dexterity, constitution;
    private int STR, DEX, CON;
    private int movementsPoints, toReset;
    private int level;
    private int experience;
    private int x, y;
    private int armorclass;
    private int capacity;
    private Weapon weapon;
    private Armor armor;
    private ArrayList<Item> backpack;
    private AIController controller;
    private ArrayList<Property> properties;

    public Doll(String name, int hp, int capacity, Decal sprite,
                int movementsPoints, int level, int experience,
                int strength, int dexterity, int constitution,
                int initiativebonus, Classification classification, ArrayList <Property> properties){

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
    public void draw(SpriteBatch batch) {

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
    public Decal getSprite() {
        return sprite;
    }

    @Override
    public void setSprite(Decal sprite) {
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
        sprite.setPosition(x,0, y + 0.5f);

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
    public void draw(ModelBatch modelBatch, DecalBatch decalBatch){

   // sprite.setPosition(x,0, y + 0.5f);
    decalBatch.add(sprite);

    }

    @Override
    public void addProperty(Property property)
    {properties.add(property);}
}
