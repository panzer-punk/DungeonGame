package com.mygdx.game.tools;

import com.mygdx.game.weaponry.Buff;

import java.util.Iterator;
import java.util.LinkedList;

public class BuffPool {

    private LinkedList<Buff> buffs;

    public BuffPool() {

        buffs = new LinkedList<Buff>();

    }

    public void add(Buff buff){

        buffs.add(buff);

    }

    public void remove(Buff buff){

        buffs.remove(buff);

    }

    public void use(){

        Iterator<Buff> buffIterator = buffs.iterator();

        while (buffIterator.hasNext()){

            Buff b = buffIterator.next();

            if(b.getDuration() > 0)
                b.applyProperty();
            else {
                buffIterator.remove();
                buffs.remove(b);
            }


        }

    }



}
