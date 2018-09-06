package com.mygdx.game.playable;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.armor.LeatherArmor;
import com.mygdx.game.enumerations.Classification;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.interfaces.Weapon;
import com.mygdx.game.tools.Printer;
import com.mygdx.game.weaponry.meleeweapon.IronSword;

public class Skeleton extends Doll {
    public Skeleton(String name, int hp, int capacity, Sprite sprite, int movementsPoints, int level, int experience, int strength, int dexterity, int constitution, int initiativebonus, Classification classification) {
        super(name, hp, capacity, sprite, movementsPoints, level, experience, strength, dexterity, constitution, initiativebonus, classification);
    }
    public Skeleton(Sprite sprite){

        super("Skeleton", 4,0, sprite,
                7, 1, 0,
                12,8,10,
                2, Classification.Nonplayable);

        equipArmor(new LeatherArmor());
        equipWeapon(new IronSword());

    }

    @Override
    public void takeDamage(GameObject gameObject){

        int d;
        Weapon weapon = gameObject.getWeapon();

        if(weapon.getType() == 0)
            d = weapon.getDamage();
        else
            d = weapon.getDamage() - 4;

        if(d > 0)
            hp -= d;

        Printer.print(this.getName() + " took " + d + " damage");

    }
}
