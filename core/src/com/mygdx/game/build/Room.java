package com.mygdx.game.build;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.enumerations.Classification;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.tools.*;
import com.mygdx.game.weaponry.Buff;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Даниил on 11.04.2018.
 */
public class Room {

   private int capacity = 9;
   private int l = 3, c = 3;
   private int currentSizePO;
   private PriorityQueue priorityQueue;
   private int turn;

    private GameObject map[][];
    private GameObject[] playableObjects; // костыль!!!
    private LinkedList<GameObject> pObjects;
    private Map tileMap;

    public Room(Map m){
       init(m);
    }

    public Room(int l, int c, Map m){

        this.l = l;
        this.c = c;
        init(m);

    }

    private void init(Map m){
        turn = 1;
        capacity = l * c;
        tileMap = m;
        currentSizePO = 0;
        map = new GameObject[l][c];
        priorityQueue = new PriorityQueue(map.length);
        pObjects = new LinkedList<GameObject>();

    }

    public void setTurn(int t){
        turn = t;
    }

    public int getTurn(){
        return turn;
    }

    public PriorityQueue getInitiativeQueue(){

        return priorityQueue;
    }


    public void resetMp(){

        for(GameObject g : pObjects)
            if(g != null)
                g.resetMP();

    }

    public GameObject[] getPlayableObjects() {
        playableObjects = pObjects.toArray(new GameObject[0]);
        return playableObjects;
    }

    public void setObject(GameObject gameObject){

        if(capacity > 0) {

            for (int i = 0; i < l; i++) {
                for(int j = 0; j < c; j++){
                    if(map[i][j] == null && gameObject != null) {
                        map[i][j] = gameObject;
                        map[i][j].setXY(i, j);
                        if(gameObject.getClassification() != Classification.OBJECT) {
                            gameObject.setInitiative(Dice.d20());
                            priorityQueue.insert(gameObject);
                           pObjects.add(gameObject);
                        }
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
            pObjects.remove(map[line][column]);
            map[line][column] = null;
            capacity++;
        }

    }



    public GameObject remove(int line, int column){

        GameObject temp = map[line][column];
        pObjects.remove(map[line][column]);
        map[line][column] = null;
        capacity++;
        return temp;
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
