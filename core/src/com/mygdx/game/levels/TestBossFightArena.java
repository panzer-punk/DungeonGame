package com.mygdx.game.levels;

import com.mygdx.game.build.Map;
import com.mygdx.game.build.Room;
import com.mygdx.game.terrain.Floor_min;

/**
 * Created by Даниил on 01.02.2019.
 */
public class TestBossFightArena extends Room {
    Map map;

    public TestBossFightArena( ) {
        super(14, 8, new Map(14,8, new Floor_min()));
    }

    {

    }

}
