package com.mygdx.game.ai.controller;

import com.mygdx.game.ai.controller.AIController;
import com.mygdx.game.build.Room;
import com.mygdx.game.interfaces.GameObject;

public abstract class AbstractAIController implements AIController {
    protected GameObject actor;
    private GameObject player;

    public AbstractAIController(GameObject actor) {
        this.actor = actor;
    }


    protected void setPlayer(GameObject gameObject){
        player = gameObject;
    }

    public GameObject getPlayer() {
        return player;
    }

    @Override
    public final GameObject getActor(){return actor;}


    @Override
    public void makeTurn(Room room){


        makeMove(room);
        makeDamage();
        endTurn();
        room.clearTiles();

    }

    abstract protected void makeMove(Room room);
    abstract protected void makeDamage();
    abstract protected void endTurn();

}