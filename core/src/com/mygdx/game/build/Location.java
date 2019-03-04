package com.mygdx.game.build;

import com.mygdx.game.objects.Door;
import com.mygdx.game.screens.GameScreen;
import com.mygdx.game.tools.Dice;

import java.io.Serializable;
import java.util.Stack;

public class Location implements Serializable {

    private Room mainRoom;
    private Room currentRoom;
    private Stack<Room> roomStack;
    private GameScreen gameScreen;
    private TexturePack texturePack;

    public Location(Stack<Room> stack, TexturePack texturePack, GameScreen gameScreen){

        roomStack = stack;
        mainRoom = roomStack.pop();
        currentRoom = mainRoom;
        this.gameScreen = gameScreen;
        this.texturePack = texturePack;


    }

    public void prepareLocation(){

        add(roomStack.pop());

    }



    private void add(Room room){


    }

    private void add(Room currentRoom, Room room){



    }

    private void checkNextRoom(Room room){

        if(!roomStack.empty()){
            switch (Dice.d20()){

                case 3:
                case 4:
                    add(room, roomStack.pop());
                    break;
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                    currentRoom = room;
                    add(roomStack.pop());
                    break;
                default:
                    add(roomStack.pop());

            }

        }

    }

    public Room getMainRoom(){
        return mainRoom;
    }




}
