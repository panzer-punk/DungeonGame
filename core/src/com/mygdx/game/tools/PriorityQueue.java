package com.mygdx.game.tools;

import com.mygdx.game.interfaces.GameObject;

public class PriorityQueue {

private GameObject [] gameObjects;
private int maxSize;
private int currentSize;

    public PriorityQueue(int maxSize) {
        this.maxSize = maxSize;
        currentSize = 0;
        gameObjects = new GameObject[maxSize];
    }

    public void insert(GameObject[] gameOs){

        for(GameObject g : gameOs){
            if(g != null) {
               insert(g);
            }
        }

    }

    public boolean isEmpty(){
        return (currentSize == 0);
    }

    public boolean insert(GameObject object){

        if(currentSize == maxSize)
            return false;
        gameObjects[currentSize] = object;
        trickleUp(currentSize++);
        return true;

    }

    private void trickleUp(int index){

        int parent = (index - 1)/2;
        GameObject bottom = gameObjects[index];
        while (index > 0 &&
                gameObjects[parent].getInitiative() < bottom.getInitiative()){

            gameObjects[index] = gameObjects[parent];
            index = parent;
            parent = (parent - 1)/2;

        }

        gameObjects[index] = bottom;

    }

    public GameObject remove(){

        GameObject root = gameObjects[0];
        gameObjects[0] = gameObjects[--currentSize];
        trickleDown(0);
        return root;

    }

    private void trickleDown(int index){

        int largerChild;
        GameObject top = gameObjects[index];

        while (index < currentSize/2){

            int leftChild = 2*index + 1;
            int rightChild = leftChild + 1;

            if(rightChild < currentSize &&
                    gameObjects[leftChild].getInitiative() < gameObjects[rightChild].getInitiative())
                largerChild = rightChild;
            else
                largerChild = leftChild;
            if(top.getInitiative() >= gameObjects[largerChild].getInitiative())
                break;

            gameObjects[index] = gameObjects[largerChild];
            index = largerChild;

        }

        gameObjects[index] = top;

    }

    public void display(){

        for(int i = 0;  i < currentSize; i++)
            Printer.print(gameObjects[i].getName() + ": " + gameObjects[i].getInitiative());

    }

}
