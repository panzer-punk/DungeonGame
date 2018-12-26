package com.mygdx.game.items;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.decals.Decal;
import com.mygdx.game.build.NewTexturePack;
import com.mygdx.game.build.Room;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.interfaces.Item;
import com.mygdx.game.objects.DecalEntity;
import com.mygdx.game.objects.ModelEntity;

/**
 * Created by Даниил on 04.12.2018.
 */
public class CelticFire extends DecalEntity implements  Item {


    public CelticFire() {
        super(Decal.newDecal(0.45f, 0.45f, NewTexturePack.celticFire, true), "Celtic fire");
    }

    public CelticFire(Decal decal, String name) {
        super(decal, name);
    }

    @Override
    public void use(GameObject gameObject) {//TODO добавить слоты активных вещей в GameObject

    }

    @Override
    public void takeDamage(GameObject gameObject){

        setHp(-100);
        gameObject.putItem(this);


    }

    @Override
    public void drop(Room room, GameObject gameObject) {
        setHp(1);
        gameObject.deleteItem(this);
        room.setObject(this);
    }
}
