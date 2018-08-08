package com.mygdx.game.weaponry;

import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.interfaces.Weapon;

public abstract class Buff {

    private GameObject gameObject;
    private int duration;

    public Buff(GameObject gameObject, int duration){

        this.duration = duration;
        this.gameObject = gameObject;

    }

    public abstract void applyProperty();

    public final int getDuration(){return duration;}

    public void reduceDuration(){duration--;}



}
