package com.mygdx.game.tools;

import com.mygdx.game.weaponry.Buff;

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

        for (Buff b : buffs){
            if(b != null)
            if(b.getDuration() > 0) {
                b.applyProperty();
                b.reduceDuration();
            } else
                remove(b);

        }

    }

}
