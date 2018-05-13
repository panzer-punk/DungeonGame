package com.mygdx.game;

/**
 * Created by Даниил on 09.09.2017.
 */
public class Printer {//debug class

    public static void show(GameObject gameObject){

        if(gameObject.getClass() == Entity.class)
            System.out.println(gameObject.getName() + "\n X;Y: " + gameObject.getX() + ";" + gameObject.getY());
        else
        System.out.println(gameObject.getName() + ": " + gameObject.getHP() +
                "\n Armor: " + gameObject.getArmor().getQuality() + ", pen " + gameObject.getArmor().getPenetration() +
                "\n Weapon: " + gameObject.getWeapon().getDamage() + ", pen " + gameObject.getWeapon().getPenetration()+
                "\n MP: " + gameObject.getMP()+
                "\n X;Y: " + gameObject.getX() + ";" + gameObject.getY());

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
