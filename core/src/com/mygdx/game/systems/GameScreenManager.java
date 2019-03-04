package com.mygdx.game.systems;

import com.mygdx.game.interfaces.Particle;
import com.mygdx.game.screens.GameScreen;

/**
 * Created by Даниил on 05.12.2018.
 */

public class GameScreenManager{

    static GameScreen gs;

    public static void init(GameScreen gameScreen) {

        gs = gameScreen;

    }

    public static void addParticle(Particle particle){

       //p gs.addParticle(particle);

    }


}
