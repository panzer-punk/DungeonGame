package com.mygdx.game.systems;

import com.mygdx.game.interfaces.Attack;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.interfaces.Property;
import com.mygdx.game.tools.Dice;
import com.mygdx.game.tools.Printer;

import static com.mygdx.game.enumerations.Classification.*;

/**
 * Created by Даниил on 26.12.2018.
 */
public class Damager {


    public  static void makeDamage(GameObject dealer, GameObject gainer) {

        if(gainer.getClassification() == OBJECT)
            gainer.takeDamage(dealer);//обрабатывается в ловушках и дверях
        else
        if (isSuccess(dealer.getSTR() + Dice.d20(), gainer.getArmorClass())) {

            Attack attack = dealer.getWeapon().getAttack();
            int dmg;
            boolean special = true;
            dmg = attack.getDamage();

            if(!gainer.getProperties().isEmpty())
                for (Property p : gainer.getProperties()) {
                    if(p.getWeaponType() == dealer.getWeapon().getType())
                    dmg = p.updateDamage(dmg);
                    if(p.getAttackType() == attack.getType())
                        special = false;

            }
            if(dmg < 0)
                dmg = 0;

            print(gainer, dmg);
            gainer.takeDamage(dmg);//во всех остальных объектах

           if(special)
               attack.makeSpecialDamage(gainer);


           /* int dmg = dealer.getDamage();

            if(!gainer.getProperties().isEmpty())
            for (Property p : gainer.getProperties())
                dmg = p.updateDamage(dmg, dealer.getWeapon());



            if(dmg < 0)
                dmg = 0;

            gainer.takeDamage(dmg);//во всех остальных объектах
            Printer.print(gainer.getName() + " took " + dmg + " damage");*/

        }else
            Printer.print(dealer.getName() + " miss");
    }

    private static void print(GameObject gameObject, int dmg){
        Printer.print(gameObject.getName() + " took " + dmg + " damage");
    }

    public static void makeDamage(GameObject gameObject, Attack attack){

        print(gameObject, attack.getDamage());
        gameObject.takeDamage(attack.getDamage());

    }

    public static boolean isSuccess(int got, int need){return got >= need;}



}
