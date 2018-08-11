package com.mygdx.game.tools;

import com.mygdx.game.build.Room;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.screens.GameScreen;

import java.util.ArrayList;

public abstract class Trigger {

    private ArrayList<Point> coordinats;
    private Room room;
    protected int repeats;

    public Trigger(Room room, int repeats) {

        coordinats = new ArrayList<Point>();
        this.room = room;
        this.repeats = repeats;
    }

    public void addPoint(Point point){

    coordinats.add(point);

    }

    public int getRepeats() {
        return repeats;
    }

    public abstract void Do(GameObject gameObject);

    public ArrayList<Point> getCoordinats() {
        return coordinats;
    }
}
