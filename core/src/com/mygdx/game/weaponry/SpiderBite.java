package com.mygdx.game.weaponry;

import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.tools.BuffPool;
import com.mygdx.game.tools.Dice;
import com.mygdx.game.tools.Printer;

public class SpiderBite extends WeaponryStuff {
    private BuffPool buffPool;

    public SpiderBite(String label, int type, int distance, BuffPool buffPool) {
        super(label, type, distance);
        this.buffPool = buffPool;
    }

    public SpiderBite(BuffPool buffPool){
        super("SpiderBite",1,1);
        this.buffPool = buffPool;
    }


    @Override
    public int getDamage() {
        return Dice.d4();
    }

    @Override
    public  void makeDamage(final GameObject dealer, final GameObject gainer){

        int duration;

        if((dealer.getSTR() + Dice.d20()) >= gainer.getArmorClass()) {
            gainer.takeDamage(dealer);
            if(dealer.getSTR() + Dice.d20() >= gainer.getDEX() + Dice.d20()) {
                duration = Dice.d4();
                Printer.print("Spider poisoned (" + duration + ") " + gainer.getName());
                buffPool.add(new Buff(gainer, duration, this) {
                    @Override
                    public void applyProperty() {

                        gainer.takeDamage(dealer);

                    }
                });
            }
        }else
            System.out.println("Miss");

    }
}
