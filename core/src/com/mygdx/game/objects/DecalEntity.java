package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.decals.Decal;
import com.badlogic.gdx.graphics.g3d.decals.DecalBatch;
import com.mygdx.game.ai.controller.AIController;
import com.mygdx.game.enumerations.Classification;
import com.mygdx.game.enumerations.Direction;
import com.mygdx.game.enumerations.Status;
import com.mygdx.game.graphics.RenderType3D;
import com.mygdx.game.interfaces.*;
import com.mygdx.game.screens.GameScreen;
import com.mygdx.game.tools.BuffPool;
import com.mygdx.game.weaponry.buffs.Buff;

import java.util.ArrayList;

import static com.mygdx.game.enumerations.Classification.*;

/**
 * Created by Даниил on 09.12.2018.
 */
public class DecalEntity implements GameObject,
        RenderType3D {

    Decal decal;
    String name;
    private int hp;
    int x, y;


    public DecalEntity(Decal decal, String name) {
        this.decal = decal;
        this.name = name;
        hp = 1;
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
    public Classification getClassification() {
        return OBJECT;
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
    public Decal getSprite() {
        return null;
    }

    @Override
    public void setSprite(Decal sprite) {

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
    public void setXY(int x, int y) {

        this.x = x;
        this. y = y;
        decal.setPosition(x,0, y  + 0.5f);

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
    public int getHP() {
        return hp;
    }

    @Override
    public void setHp(int hp) {

        this.hp = hp;
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
        return null;
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
    public void draw(ModelBatch modelBatch, DecalBatch decalBatch, Environment environment) {
        decal.lookAt(GameScreen.perspectiveCamera.position, GameScreen.perspectiveCamera.up);
        decalBatch.add(decal);
    }
}
