package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

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

    public void move(int from_line, int from_column, int to_line, int to_column){

        if(to_line < l && to_column < c) {
            if ((map[from_line][from_column] != null) && (map[to_line][to_column] == null)) {

                map[to_line][to_column] = map[from_line][from_column];
                map[from_line][from_column] = null;

                setXY(to_line, to_column);

            } else {

                Printer.print("Не могу перейти");

            }
        }

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

                if(map[i][j] != null)
                    map[i][j].draw(batch);

            }
        }

    }

    public void drawMap(SpriteBatch batch){
        tileMap.draw(batch);
    }

    public int getCapacity (){return capacity;}
    public void setTerrainMap(Map m){tileMap = m;}
    public int getL(){return l;}
    public int getC(){return c;}
    public GameObject getObject(int line, int column){return map[line][column];}
    public GameObject[][] getMap(){return map;}
    public Map getTileMap(){return tileMap;}

}
