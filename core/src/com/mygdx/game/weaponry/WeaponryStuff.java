package com.mygdx.game.weaponry;

import com.mygdx.game.enumerations.WeaponType;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.interfaces.Weapon;
import com.mygdx.game.tools.Dice;
import com.mygdx.game.tools.Printer;

/**
 * Created by Даниил on 15.07.2018.
 */
public abstract class WeaponryStuff implements Weapon {

    private String label;
    private WeaponType type;
    private int distance;

    public WeaponryStuff(String label, WeaponType type, int distance) {
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
           Printer.print("Miss");

    }


    @Override
    public void show() {

    }

    @Override
    public WeaponType getType() {
        return type;
    }

    @Override
    public abstract int getDamage();

    @Override
    public int getDistance() {
        return distance;
    }
}
