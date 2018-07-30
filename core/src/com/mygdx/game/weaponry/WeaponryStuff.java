package com.mygdx.game.weaponry;

import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.interfaces.Weapon;
import com.mygdx.game.tools.Dice;

/**
 * Created by Даниил on 15.07.2018.
 */
public abstract class WeaponryStuff implements Weapon {

    private String label;
    private int type;
    private int distance;

    public WeaponryStuff(String label, int type, int distance) {
        this.label = label;
        this.type = type;
        this.distance = distance;
    }

    public WeaponryStuff(){

    }

    @Override
    public final String getLabel(){
        return label;
    }

    @Override
    public  void makeDamage(GameObject dealer, GameObject gainer){
        //реализация по умолчанию
        if((dealer.getSTR() + Dice.d20()) >= gainer.getArmorClass()) {
            gainer.takeDamage(dealer);
        }else
            System.out.println("Miss");

    }


    @Override
    public void show() {

    }

    @Override
    public int getType() {
        return type;
    }

    @Override
    public abstract int getDamage();

    @Override
    public int getDistance() {
        return distance;
    }
}
