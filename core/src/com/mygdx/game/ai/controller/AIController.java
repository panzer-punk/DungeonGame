package com.mygdx.game.ai.controller;

import com.mygdx.game.build.Room;
import com.mygdx.game.interfaces.GameObject;

public interface AIController {

    void makeTurn(Room room);
    GameObject getActor();

}