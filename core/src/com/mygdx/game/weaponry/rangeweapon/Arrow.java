package com.mygdx.game.weaponry.rangeweapon;

import com.mygdx.game.build.Room;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.tools.Dice;

public class Arrow extends Shell {

    public Arrow(int amount, Bow holder) {
        super("Arrow", amount, 1, holder);
    }

    @Override
    public int getDamage() {

        if(amount > 0) {
            amount--;
            System.out.println(bow.getLabel() + " has " + amount + " rounds");
            return Dice.d4() + bow.getDamage();
        }
        else {
            System.out.println(bow.getLabel() + " has no rounds");
            return 0;
        }
    }

    @Override
    public void drop(Room room, GameObject gameObject) {

    }
}
