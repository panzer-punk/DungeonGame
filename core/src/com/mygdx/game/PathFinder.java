package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.LinkedList;

/*
 * Created by Даниил on 22.04.2018.
 */
public class PathFinder {

    static int reset;
    static int c, l;

    static void drawWays(SpriteBatch batch, Room room, int x, int z ){

        GameObject gameObject = room.getObject(x,z);
        int movementPoints = gameObject.getMP();
        reset = movementPoints;
        c = room.getC();
        l = room.getL();
        GameObject[][] map = room.getMap();
        Terrain[][] tileMap = room.getTileMap().getTiles();

        draw(movementPoints, x, z, map, tileMap,batch);


    }

    static LinkedList<WayPoint> moveTo(Room room, GameObject gameObject, int x, int y){

        LinkedList<WayPoint> wayPoints = new LinkedList<WayPoint>();

        while(gameObject.getX() != x){

            wayPoints.add(new WayPoint(room.getTileMap().getTiles()[x+=1][y]));

        }

        while (gameObject.getY() != y){

            wayPoints.add(new WayPoint(room.getTileMap().getTiles()[x+=1][y]));

        }

        return wayPoints;
    }


    private static void draw(int mp, int x, int z, GameObject[][] map, Terrain[][] tileMap, SpriteBatch batch){
        //up
        if(mp >= 0 && x <= c && z <= l ){

            int mMP = mp;

            //standingPosition

            //up
            if(z != 0) {
                if (map[x][z - 1] == null) {

                    int a = mMP;
                    a -= tileMap[x][z - 1].getMovementCost();
                    if(a >= 0 && !tileMap[x][z - 1].getKillFlag()) {
                        tileMap[x][z - 1].getSprite().setColor(100, 50, 0, 45);
                        tileMap[x][z - 1].flag = true;
                        draw(a, x, z - 1, map, tileMap, batch);
                    }
                }
            }
                //down
                if (z != c - 1)
                    if (map[x][z + 1] == null) {
                        int a = mMP;
                        a -= tileMap[x][z + 1].getMovementCost();
                        if(a >= 0 && !tileMap[x][z + 1].getKillFlag()) {
                            tileMap[x][z + 1].getSprite().setColor(100, 50, 0, 45);
                            tileMap[x][z + 1].flag = true;
                            draw(a, x, z + 1, map, tileMap, batch);
                        }
                    }

            //right
            if(x != l - 1) {
                if (map[x + 1][z] == null) {

                    int a = mMP;
                    a -= tileMap[x + 1][z].getMovementCost();
                    if(a >= 0 && !tileMap[x + 1][z].getKillFlag()) {
                        tileMap[x + 1][z].getSprite().setColor(100, 50, 0, 45);
                        tileMap[x + 1][z].flag = true;
                        draw(a, x + 1, z, map, tileMap, batch);
                    }
                }
            }

                //left
                if (x != 0)
                    if (map[x - 1][z] == null) {

                        int a = mMP;
                        a -= tileMap[x - 1][z].getMovementCost();
                        if(a >= 0 && !tileMap[x - 1][z].getKillFlag()) {
                                tileMap[x - 1][z].getSprite().setColor(100, 50, 0, 45);
                                tileMap[x - 1][z].flag = true;
                                draw(a, x - 1, z, map, tileMap, batch);
                        }
                    }



        }


    }
    //for making animation of movement
    static int[] getWaypointByDestination(int x_to, int z_to, int x_from, int z_from){

        return null;
    }

    //test method
    static void countMove(GameObject gameObject, Room room,int x, int y){






    }

}
