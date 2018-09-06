package com.mygdx.game.weaponry;

import com.mygdx.game.enumerations.Classification;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.tools.BuffPool;
import com.mygdx.game.tools.Dice;
import com.mygdx.game.tools.Printer;

public class SpiderBite extends WeaponryStuff {
    private Poison poison;

    public SpiderBite(String label, int type, int distance) {
        super(label, type, distance);
        poison = new SpiderPoison();
    }

    public SpiderBite(){
        super("SpiderBite",1,1);
        poison = new SpiderPoison();
    }


    @Override
    public int getDamage() {
        return Dice.d4();
    }

    @Override
    public  void makeDamage(final GameObject dealer, final GameObject gainer){

        BuffPool buffPool = gainer.getBuffPool();
        int duration;

        if((dealer.getSTR() + Dice.d20()) >= gainer.getArmorClass()) {
            gainer.takeDamage(dealer);
            if(dealer.getSTR() + Dice.d20() >= gainer.getDEX() + Dice.d20() && gainer.getClassification() != Classification.OBJECT) {
                duration = Dice.d4();
                Printer.print("Spider poisoned (" + duration + ") " + gainer.getName());
                buffPool.add(new Buff(gainer, duration) {
                    @Override
                    public void applyProperty() {

                        gainer.takeDamage(poison);
                        this.reduceDuration();

                    }
                });
            }
        }else
            Printer.print("Miss");

    }
}
