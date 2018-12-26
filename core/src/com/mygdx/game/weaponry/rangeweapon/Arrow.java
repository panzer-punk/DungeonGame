package com.mygdx.game.weaponry.rangeweapon;

import com.mygdx.game.build.Room;
import com.mygdx.game.build.TexturePack;
import com.mygdx.game.enumerations.WeaponType;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.particles.ArrowParticle;
import com.mygdx.game.screens.GameScreen;
import com.mygdx.game.systems.GameScreenManager;
import com.mygdx.game.tools.Dice;

import static com.mygdx.game.enumerations.WeaponType.*;

public class Arrow extends Shell {

    public Arrow(int amount, Bow holder) {
        super("Arrow", amount, STABBING, holder);
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
