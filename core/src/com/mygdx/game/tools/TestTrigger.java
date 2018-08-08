package com.mygdx.game.tools;

import com.mygdx.game.build.Room;
import com.mygdx.game.interfaces.GameObject;

public class TestTrigger extends Trigger {

    public TestTrigger(Room room, int repeats) {
        super(room, repeats);
    }

    @Override
    public void Do(GameObject gameObject) {

        repeats--;
        gameObject.getSprite().flip(true,false);
        System.out.println("Trigger works");

    }
}
