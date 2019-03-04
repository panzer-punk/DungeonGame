package com.mygdx.game.levels;

import com.mygdx.game.build.*;
import com.mygdx.game.terrain.*;

/**
 * Created by Даниил on 20.02.2019.
 */
public class Test2DLevel extends Room {
    public Test2DLevel() {
        super(2, 2, new Map(2, 2, null));

        Map map = new Map(4,4, null);
        map.addTile(new Water(), 0, 0);
        map.addTile(new Water(), 1, 0);
        map.addTile(new Water(), 2, 0);
        map.addTile(new Water(), 3, 0);
        map.addTile(new Water(), 0, 1);
        map.addTile(new Water(), 1, 1);
        map.addTile(new Water(), 2, 1);
        map.addTile(new Water(), 3, 1);
        setTerrainMap(map);
    }
}