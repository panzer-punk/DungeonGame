package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Даниил on 11.04.2018.
 */
public class Room {

   private int capacity = 9;
   private int l = 3, c = 3;

    private GameObject map[][];
    private Map tileMap;

    public Room(Map m){
        map = new GameObject[l][c];
        tileMap = m;
    }

    public Room(int l, int c, Map m){

        this.l = l;
        this.c = c;
        capacity = l * c;
        tileMap = m;
        map = new GameObject[l][c];
    }

    public void setObject(GameObject gameObject){

        if(capacity > 0) {

            for (int i = 0; i < l; i++) {
                for(int j = 0; j < c; j++){
                    if(map[i][j] == null && gameObject != null) {
                        map[i][j] = gameObject;
                        map[i][j].setXY(i, j);
                        gameObject = null;
                        break;
                    }
                    }


            }

            capacity--;
        }
    }

    private void setXY(int x, int y){map[x][y].setXY(x, y);}//?

    public boolean move(int from_line, int from_column, int to_line, int to_column){

        if(to_line < l && to_column < c) {
            if ((map[from_line][from_column] != null) && (map[to_line][to_column] == null)) {

                map[to_line][to_column] = map[from_line][from_column];
                map[from_line][from_column] = null;

                setXY(to_line, to_column);

                return true;

            } else {

                Printer.print("Не могу перейти\n");

                return false;
            }
        }

        return false;

    }

    public boolean move(LinkedList<WayPoint> wayPoints, GameObject gameObject){

        Iterator<WayPoint> iterator = wayPoints.iterator();

        while (iterator.hasNext()){

            WayPoint w = iterator.next();


        }

        return false;
    }

    public void delete(int line, int column){

        if(map[line][column] != null) {
            map[line][column] = null;
            capacity++;
        }

    }

    public void drawObjects(SpriteBatch batch){
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {

                if(map[i][j] != null) {
                    if(map[i][j].getHP() <= 0)
                       // if (map[i][j].getClass() != Entity.class) Entity should be checked by it's class, not by HP
                            delete(i, j);
                    else
                    map[i][j].draw(batch);
                }


            }
        }

    }

    public void drawMap(SpriteBatch batch){
        tileMap.draw(batch);
    }

    public void clearTiles(){

        for (int i = 0; i < l; i++)
            for (int j = 0; j < c; j++) {
                tileMap.getTiles()[i][j].getSprite().setColor(1, 1, 1, 1);
                tileMap.getTiles()[i][j].flag = false;
            }
    }

    public int getCapacity (){return capacity;}
    public void setTerrainMap(Map m){tileMap = m;}
    public int getL(){return l;}
    public int getC(){return c;}
    public GameObject getObject(int line, int column){return map[line][column];}
    public GameObject[][] getMap(){return map;}
    public Map getTileMap(){return tileMap;}

}
