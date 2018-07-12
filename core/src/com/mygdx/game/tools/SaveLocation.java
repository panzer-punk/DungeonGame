package com.mygdx.game.tools;

import com.mygdx.game.build.Room;

import java.io.Serializable;

/**
 * Created by Даниил on 13.04.2018.
 */
public class SaveLocation implements Serializable {

    private Room room;

    public SaveLocation(Room r){room = r;}

    public Room getRoom(){return room;}

}
