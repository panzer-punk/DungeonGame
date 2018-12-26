package com.mygdx.game.systems;

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
        if (isSuccess(dealer.getDamage() + Dice.d20(), gainer.getArmor().getArmor())) {//TODO gainer.getArmor() типа int
            int dmg = dealer.getDamage();

            if(!gainer.getProperties().isEmpty())
            for (Property p : gainer.getProperties())
                dmg = p.updateDamage(dmg, dealer.getWeapon());



            if(dmg < 0)
                dmg = 0;

            gainer.takeDamage(dmg);//во всех остальных объектах
            Printer.print(gainer.getName() + " took " + dmg + " damage");

        }else
            Printer.print("Miss");
    }

    public static boolean isSuccess(int got, int need){return got >= need;}



}
