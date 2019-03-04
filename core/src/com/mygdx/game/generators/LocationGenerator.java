package com.mygdx.game.generators;

import com.mygdx.game.build.Location;
import com.mygdx.game.build.Room;
import com.mygdx.game.build.TexturePack;
import com.mygdx.game.screens.GameScreen;
import com.mygdx.game.tools.Dice;

import java.util.Stack;

public class LocationGenerator {
    TexturePack texturePack;
    private RoomGenerator roomGenerator;
    private GameScreen gameScreen;

    public LocationGenerator(TexturePack texturePack, GameScreen gameScreen) {
        this.texturePack = texturePack;
        roomGenerator = new RoomGenerator(texturePack);
        this.gameScreen = gameScreen;
    }

    public Location generate(int size){


        Location location;

        Stack<Room> roomStack = new Stack<Room>();

        for(int i = 0; i <= size; i++){




        }

        location = new Location(roomStack, texturePack, gameScreen);
        location.prepareLocation();

        return location;


    }

}
