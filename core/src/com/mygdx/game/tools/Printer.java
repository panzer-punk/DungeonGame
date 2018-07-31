package com.mygdx.game.tools;

import com.mygdx.game.enumerations.Classification;
import com.mygdx.game.objects.Entity;
import com.mygdx.game.build.Room;
import com.mygdx.game.interfaces.Armor;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.interfaces.Item;
import com.mygdx.game.interfaces.Weapon;

/**
 * Created by Даниил on 09.09.2017.
 */
public class Printer {//debug class

    public static void show(GameObject gameObject){

        if(gameObject.getClass() == Entity.class || gameObject.getClassification() == Classification.OBJECT)
            System.out.println(gameObject.getName() + "\n X;Y: " + gameObject.getX() + ";" + gameObject.getY());
        else
        System.out.println(gameObject.getName() + ": " + gameObject.getHP() +
                "\n Armor: " + gameObject.getArmor().getArmor() + " AC" + gameObject.getArmorClass() +
                "\n Weapon: " + gameObject.getWeapon().getLabel()+
                "\n MP: " + gameObject.getMP()+
                "\n STR: " + gameObject.getSTR() + " DEX: " + gameObject.getDEX() + " CON: " + gameObject.getCON() +
                "\n X;Y: " + gameObject.getX() + ";" + gameObject.getY() +
                "\n In: "+ gameObject.getInitiative());

    }

    public static void show(Item item){

        item.show();

    }

    public static void show(Armor armor){

        armor.show();

    }

    public static void show(Weapon weapon){

        weapon.show();

    }

    public static void show(Item item[]){

        for(Item singleItem : item )
            singleItem.show();

    }

    public static void show(Room room){

       // System.out.println( "Capacity: " + room.getCapacity());

        GameObject gameObject[][] = room.getMap();

        for (int l = 0; l < room.getL(); l++){
            print("\n");
            for(int c = 0; c < room.getC(); c++){

                if(gameObject[l][c] != null)
                    print(/*l+";"+ c + ": " + */" " + gameObject[l][c].getName().charAt(0));
                else
                    print(/*l+";"+ c + */" x");
            }

          /*  if(gameObject[i] != null)
            print(i + ": " + gameObject[i].getName());
            else
                print(i + ": Empty");*/

        }


    }

    public static void print(String message){

        System.out.print(message);

    }

}
