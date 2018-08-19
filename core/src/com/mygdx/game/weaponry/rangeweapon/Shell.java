package com.mygdx.game.weaponry.rangeweapon;

import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.interfaces.Item;
import com.mygdx.game.interfaces.Weapon;
import com.mygdx.game.tools.Printer;

public abstract class Shell implements Item, Weapon {

    protected int amount;
    private int type;
    private String label;
    protected Bow bow;

    public Shell(String label,int amount, int type, Bow holder) {
        this.amount = amount;
        this.label = label;
        this.type = type;
        bow = holder;
    }

    public final int getAmount(){return amount;}

    @Override
    public int use() {

        bow.setShell(this);//использовать через getWeapon

        return 0;
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
    public int getType() {
        return type;
    }

    @Override
    public abstract int getDamage();

    @Override
    public int getDistance() {
        return 0;
    }
}
