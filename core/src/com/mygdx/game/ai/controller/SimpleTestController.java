package com.mygdx.game.ai.controller;

import com.mygdx.game.build.Map;
import com.mygdx.game.build.Room;
import com.mygdx.game.enumerations.Classification;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.terrain.Terrain;

public class SimpleTestController extends AbstractAIController{

    public SimpleTestController(GameObject gameObject) {
        super(gameObject);
    }

    @Override
    protected void makeMove(Room room) {



            final int mr = actor.getMP();
            GameObject gameObjects[][] = room.getMap();
            int x = actor.getX();
            int y = actor.getY();

            GameObject closestPlayer = getPlayer();


            int lastDist = 1000000;
            for (int i = 0; i < room.getL(); i++) {
                for (int j = 0; j < room.getC(); j++) {

                    if (gameObjects[i][j] != null && gameObjects[i][j].getClassification() == Classification.Playable) {

                        int newDist = countDistance(x, y, i, j);

                        if (newDist < lastDist) {
                            lastDist = newDist;

                            closestPlayer = gameObjects[i][j];

                        }


                    }


                }

            }


//debug
            if (closestPlayer.getX() < x)
                System.out.println("Слева");
            else if (closestPlayer.getX() > x)
                System.out.println("Справа");
            if (closestPlayer.getY() < y)
                System.out.println("Сверху");
            else if (closestPlayer.getY() > y)
                System.out.println("Снизу");

            if(closestPlayer != getPlayer() || !inRange(closestPlayer, getActor())) {
                moveCloseAsPossibleTo(closestPlayer, room.getTileMap().getTiles(), getActor().getWeapon().getDistance(), room);
                setPlayer(closestPlayer);
            }

        /*
          if (room.getTileMap().getTiles()[x][z].flag == true && room.move(lastSelectedObject.getX(), lastSelectedObject.getY(), x, z))
         lastSelectedObject.makeStep(room.getTileMap().getTiles()[x][z].getMovementPrice());
         */


    }



    private void moveCloseAsPossibleTo(GameObject player, Terrain[][] tiles, int range, Room room){

        int r = range;
        int xSize = room.getL(), ySize = room.getC();
       Terrain map[][] = tiles;

        for(int i = player.getX(); i < xSize; i++){
            for (int j = player.getY(); j < ySize; j++){

                if (map[i][j].flag == true){
                    room.move(getActor().getX(), getActor().getY(), i, j);
                    return;
                }

            }

        }


    }


    public static int countDistance(int x, int y, int x1, int y1){return (int) Math.sqrt(Math.pow(x1 - x,2) + Math.pow(y1 - y,2));}

    public static boolean inRange(GameObject player, GameObject ai){

        return countDistance(player.getX(), player.getY(), ai.getX(), ai.getY()) <= ai.getWeapon().getDistance();

    }

    @Override
    protected void makeDamage() {

        if(inRange(getPlayer(), getActor()))
            getPlayer().takeDamage(getActor());

    }

    @Override
    protected void endTurn() {

        actor.makeStep(100);

    }
}