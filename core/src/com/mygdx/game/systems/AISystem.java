package com.mygdx.game.systems;

import com.mygdx.game.ai.controller.AbstractAIController;
import com.mygdx.game.build.Room;
import com.mygdx.game.interfaces.GameObject;

public class AISystem {

    private AISystem(){

    }
    private static volatile AISystem instance;

    public static AISystem getInstance() {
        AISystem localInstance = instance;
        if (localInstance == null) {
            synchronized (AISystem.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new AISystem();
                }
            }
        }
        return localInstance;
    }

    public void makeTurn(GameObject gameObject, Room room){

        AbstractAIController abstractAIController = (AbstractAIController) gameObject.getController();
        abstractAIController.makeTurn(room);

    }


}