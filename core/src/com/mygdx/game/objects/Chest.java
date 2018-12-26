package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.decals.Decal;
import com.mygdx.game.build.NewTexturePack;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.systems.DialogManager;

/**
 * Created by Даниил on 04.12.2018.
 */
public class Chest extends DecalEntity {
    Decal chestClosed;
    boolean isOpen;
    public Chest(Decal chestOpen, String name, Decal chestClosed ) {
        super(chestOpen, name);
        this.chestClosed = chestClosed;
    }

    public Chest(){

        super(Decal.newDecal(1,1, NewTexturePack.chestClosed, true), "Chest");
        this.chestClosed = Decal.newDecal(1,1, NewTexturePack.chestOpen, true);

    }
    {
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
        chestClosed.setX(decal.getX());
        chestClosed.setZ(decal.getZ());

    }

    private void replaceSprite(){

        isOpen = true;
        decal = chestClosed;

    }

}
