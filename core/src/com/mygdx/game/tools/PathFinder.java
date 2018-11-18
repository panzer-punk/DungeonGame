package com.mygdx.game.tools;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.build.Room;
import com.mygdx.game.terrain.Terrain;
import com.mygdx.game.interfaces.GameObject;

import java.util.LinkedList;

/*
 * Created by Даниил on 22.04.2018.
 */
public class PathFinder {

    static int reset;
    static int c, l;

    public static void drawWays(SpriteBatch batch, Room room, int x, int z , int lin, int col){

        GameObject gameObject = room.getObject(x,z);
        if(gameObject == null)
            return;
        int movementPoints = gameObject.getMP();
        reset = movementPoints;
        c = col;
        l = lin;
      //  Printer.print("PTF " + l + " "+ c);
        GameObject[][] map = room.getMap();
        Terrain[][] tileMap = room.getTileMap().getTiles();

        draw(movementPoints, x, z, map, tileMap,batch, 0);


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


    private static void draw(int mp, int x, int z, GameObject[][] map, Terrain[][] tileMap, SpriteBatch batch, int testP){
        //up
        if(mp >= 0 && (x <= l && z <= c) ){

            int mMP = mp;
            Terrain t;

            //standingPosition

            //up
            if(z != 0) {
                if (map[x][z - 1] == null) {

                    int a = mMP;
                    int path = testP;
                    a -= tileMap[x][z - 1].getMovementCost();
                    if(a >= 0 && !tileMap[x][z - 1].getKillFlag()) {
                       t = tileMap[x][z - 1];
                       t.getSprite().setColor(100, 50, 0, 45);
                       t.flag = true;
                       path += t.getMovementCost();
                       t.setMovementPrice(path);
                        draw(a, x, z - 1, map, tileMap, batch, path);
                    }
                }
            }
                //down
                if (z != c - 1)
                    if (map[x][z + 1] == null) {
                        int a = mMP;
                        int path = testP;
                        a -= tileMap[x][z + 1].getMovementCost();
                        if(a >= 0 && !tileMap[x][z + 1].getKillFlag()) {
                            t = tileMap[x][z + 1];
                            t.getSprite().setColor(100, 50, 0, 45);
                            t.flag = true;
                            path += t.getMovementCost();
                            t.setMovementPrice(path);
                            draw(a, x, z + 1, map, tileMap, batch, path);
                        }
                    }

            //right
            if(x != l - 1) {
                if (map[x + 1][z] == null) {

                    int a = mMP;
                    int path = testP;
                    a -= tileMap[x + 1][z].getMovementCost();
                    if(a >= 0 && !tileMap[x + 1][z].getKillFlag()) {
                        t = tileMap[x + 1][z];
                        t.getSprite().setColor(100, 50, 0, 45);
                        t.flag = true;
                        path += t.getMovementCost();
                        t.setMovementPrice(path);
                        draw(a, x + 1, z, map, tileMap, batch, path);
                    }
                }
            }

                //left
                if (x != 0)
                    if (map[x - 1][z] == null) {

                        int a = mMP;
                        int path = testP;
                        a -= tileMap[x - 1][z].getMovementCost();
                        if(a >= 0 && !tileMap[x - 1][z].getKillFlag()) {
                            t = tileMap[x - 1][z];
                                t.getSprite().setColor(100, 50, 0, 45);
                                t.flag = true;
                                path += t.getMovementCost();
                                t.setMovementPrice(path);
                                draw(a, x - 1, z, map, tileMap, batch, path);
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

    public static void updateRoom(Room r){

        c = r.getC();
        l = r.getL();

    }

}
