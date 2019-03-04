package com.mygdx.game.interfaces;

import com.mygdx.game.build.Room;

/**
 * Created by Даниил on 09.09.2017.
 */
public interface Item {

    void use(GameObject gameObject);

     void drop(Room room, GameObject gameObject);

    void show();
}
