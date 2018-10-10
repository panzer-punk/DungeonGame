package com.mygdx.game.systems;

import com.mygdx.game.build.Room;
import com.mygdx.game.objects.Door;
import com.mygdx.game.screens.GameScreen;

/**
 * Created by Даниил on 10.10.2018.
 *
 * Класс позволяет переключать для игрока комнату, в которой тот находится
 */
public class RoomManager {

    static GameScreen gameScreen;

    public static void init(GameScreen gameS){

        gameScreen = gameS;

    }

    public static void moveToRoom(Room room){

        gameScreen.moveToRoom(room);

    }

}
