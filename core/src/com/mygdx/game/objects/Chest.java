package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.systems.DialogManager;

/**
 * Created by Даниил on 04.12.2018.
 */
public class Chest extends Entity {
    Sprite chestClosed;
    private boolean isOpen;
    public Chest(Sprite s, Sprite chestClosed) {
        super("Chest", s);
        this.chestClosed = chestClosed;
        chestClosed.setSize(1,1);
        chestClosed.setFlip(false,true);
        isOpen = false;
    }

    @Override
    public void takeDamage(GameObject gameObject){//TODO заменить на рабочий код

        if(!isOpen) {
            replaceSprite();
            DialogManager.showObjectMessage("Chest", "You open chest");
        }

    }

    @Override
    public void setXY(int x, int y){
        super.setXY(x,y);
        chestClosed.setX(x);
        chestClosed.setY(y);

    }

    private void replaceSprite(){

        isOpen = true;
        sprite = chestClosed;

    }

}
