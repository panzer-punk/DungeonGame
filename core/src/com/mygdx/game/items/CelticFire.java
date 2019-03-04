package com.mygdx.game.items;

import com.badlogic.gdx.Gdx;
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
import com.mygdx.game.screens.GameScreen;

/**
 * Created by Даниил on 04.12.2018.
 */
public class CelticFire extends DecalEntity implements  Item {

    private float maxY = 0.20f;
    private boolean up = true;

    public CelticFire() {
        super(Decal.newDecal(0.45f, 0.45f, new TextureRegion(NewTexturePack.celticFire), true), "Celtic fire");
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

    @Override
    public void draw(ModelBatch modelBatch, DecalBatch decalBatch, Environment environment) {
        //decal.lookAt(GameScreen.perspectiveCamera.position, GameScreen.perspectiveCamera.up);
      //  decal.rotateY(60 * Gdx.graphics.getDeltaTime());
        if(decal.getY() > maxY)
            up = false;
        if( !up && decal.getY() <= 0)
            up = true;

        if(up)
        decal.setY(decal.getY() + 0.1f *  Gdx.graphics.getDeltaTime());
        else
            decal.setY(decal.getY() - 0.1f *  Gdx.graphics.getDeltaTime());
        decalBatch.add(decal);
    }
}
