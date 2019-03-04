package com.mygdx.game.weaponry.rangeweapon;

import com.mygdx.game.enumerations.WeaponType;
import com.mygdx.game.interfaces.Attack;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.interfaces.Item;
import com.mygdx.game.interfaces.Weapon;
import com.mygdx.game.tools.Printer;

public abstract class Shell implements Item, Weapon {

    protected int amount;
    private WeaponType type;
    private String label;
    protected Bow bow;
    private Attack attack;

    public Shell(String label,int amount, WeaponType type, Bow holder, Attack attack) {
        this.amount = amount;
        this.label = label;
        this.type = type;
        bow = holder;
        this.attack = attack;
    }

    public final int getAmount(){return amount;}

    @Override
    public void use(GameObject gameObject) {

        bow.setShell(this);//использовать через getWeapon


    }

    @Override
    public void makeDamage(GameObject dealer, GameObject gainer) {

    }

    @Override
    public void show() {

    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public WeaponType getType() {
        return type;
    }

    @Override
    public Attack getAttack(){return attack;}

    @Override
    public int getDistance() {
        return 0;
    }
}
