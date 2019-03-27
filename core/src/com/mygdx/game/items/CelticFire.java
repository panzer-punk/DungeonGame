package com.mygdx.game.items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.decals.Decal;
import com.badlogic.gdx.graphics.g3d.decals.DecalBatch;
import com.mygdx.game.build.NewTexturePack;
import com.mygdx.game.build.Room;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.interfaces.Item;
import com.mygdx.game.objects.DecalEntity;
import com.mygdx.game.objects.ModelEntity;
import com.mygdx.game.objects.SpriteEntity;
import com.mygdx.game.screens.GameScreen;

/**
 * Created by Даниил on 04.12.2018.
 */
public class CelticFire extends SpriteEntity implements  Item {


    public CelticFire(String name, int hp, int x, int y, Sprite sprite) {
        super(name, hp, x, y, sprite);
    }

    public CelticFire(){
        super("Celtic Fire", 3, 0,0, new Sprite(NewTexturePack.celticFire));

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
