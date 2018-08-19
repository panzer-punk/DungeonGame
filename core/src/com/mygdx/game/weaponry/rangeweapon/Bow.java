package com.mygdx.game.weaponry.rangeweapon;

import com.mygdx.game.enumerations.Classification;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.objects.Entity;
import com.mygdx.game.tools.Dice;
import com.mygdx.game.weaponry.WeaponryStuff;

public class Bow extends WeaponryStuff {

    private Shell shell;

    public Bow() {
        super("Bow", 1, 5);
        }

        @Override
        public  void makeDamage(GameObject dealer, GameObject gainer){
            //реализация по умолчанию
            if((dealer.getDEX() + Dice.d20()) >= gainer.getArmorClass()) {
                if(gainer.getClassification() == Classification.OBJECT) {
                    gainer.takeDamage(dealer);
                }
                else
                gainer.takeDamage(shell);
            }else
                System.out.println("Miss");

        }


    public void setShell(Shell shell) {
        this.shell = shell;
    }

    @Override
    public int getDamage() {
        return 2;
    }
}
