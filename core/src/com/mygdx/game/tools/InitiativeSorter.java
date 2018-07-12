package com.mygdx.game.tools;

import com.mygdx.game.interfaces.GameObject;

/**
 * Created by Даниил on 22.04.2018.
 */
public class InitiativeSorter {

    public GameObject gameObject [];
    private int pointer;

    public InitiativeSorter(int capacity) {
        gameObject = new GameObject[capacity];
        pointer = 0;
    }

    public void add(GameObject object){
        if(pointer < gameObject.length) {
            gameObject[pointer] = object;
            pointer++;
        }
    }

    public GameObject[] sort(){

        for(int i = 0; i < gameObject.length - 1; i++){

            if(gameObject[i].getInitiative() < gameObject[i + 1].getInitiative()){

                GameObject temp = gameObject[i + 1];
                gameObject[i + 1] = gameObject[i];
                gameObject[i] = temp;
                temp = null;

            }

        }

        return gameObject;
    }

}
