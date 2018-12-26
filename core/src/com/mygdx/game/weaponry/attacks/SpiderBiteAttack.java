package com.mygdx.game.weaponry.attacks;

import com.mygdx.game.enumerations.AttackType;
import com.mygdx.game.interfaces.Attack;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.systems.Damager;
import com.mygdx.game.tools.BuffPool;
import com.mygdx.game.tools.Dice;
import com.mygdx.game.tools.Printer;
import com.mygdx.game.weaponry.buffs.Buff;

import static com.mygdx.game.enumerations.AttackType.*;

/**
 * Created by Даниил on 26.12.2018.
 */
public class SpiderBiteAttack implements Attack {


    @Override
    public AttackType getType() {
        return POISON;
    }

    @Override
    public int getDamage() {
        return Dice.d4();
    }

    private void additionalDamage(final GameObject gameObject){

            BuffPool buffPool = gameObject.getBuffPool();
           int duration = Dice.d4();
            Printer.print("Spider poisoned (" + duration + ") " + gameObject.getName());
            buffPool.add(new Buff(gameObject, duration) {
                @Override
                public void applyProperty() {

                    Damager.makeDamage(gameObject, new D4Attack());
                    this.reduceDuration();

                }
            });
        }



    @Override
    public void makeSpecialDamage(GameObject target) {

        if(target.getDEX() + Dice.d20() > 14)
            additionalDamage(target);

    }
}
