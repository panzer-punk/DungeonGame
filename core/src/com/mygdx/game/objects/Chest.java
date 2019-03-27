package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.decals.Decal;
import com.mygdx.game.build.NewTexturePack;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.systems.DialogManager;

/**
 * Created by Даниил on 04.12.2018.
 */
public class Chest extends DialogSpriteEntity {
    Sprite chestClosed;
    boolean isOpen;

    public Chest(String name, int hp, int x, int y, String title, String text, Sprite sprite, Sprite chestClosed, boolean isOpen) {
        super(name, hp, x, y, title, text, sprite);
        this.chestClosed = chestClosed;
        this.isOpen = isOpen;
    }

    public Chest(){
        super("Chest", 10, 0, 0, "Title", "Text",new Sprite(NewTexturePack.chestClosed));
        this.chestClosed = new Sprite(NewTexturePack.chestOpen);
        chestClosed.setSize(1,1);
        chestClosed.flip(false, true);

    }
    {
        isOpen = false;
    }
    @Override
    public void takeDamage(GameObject gameObject){//TODO заменить на рабочий код

        if(!isOpen) {
            replaceSprite();
            DialogManager.showObjectMessage(title, text);
        }

    }

    @Override
    public void setXY(int x, int y){
        super.setXY(x,y);
        chestClosed.setX(sprite.getX());
        chestClosed.setY(sprite.getY());

    }

    private void replaceSprite(){

        isOpen = true;
        sprite = chestClosed;

    }

}
