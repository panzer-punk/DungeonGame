package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.decals.Decal;
import com.badlogic.gdx.graphics.g3d.decals.DecalBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.build.NewTexturePack;
import com.mygdx.game.screens.GameScreen;

/**
 * Created by Даниил on 03.12.2018.
 */
public class Column extends DialogDecalEntity {
    Vector3 direction;
    public Column() {
        super("Column", Decal.newDecal(2,2, NewTexturePack.crumbledColumn, true), "Column says:", "I'm talking column, but it's fine to me.");

    }

    public Column(String n, Decal s, String text, String title) {
        super(n, s, text, title);
    }

    {
        direction = new Vector3();
    }

   /* public Column(Sprite sprite) {
        super("Column", sprite, "Column says:", "I'm talking column, but it's fine to me.");
    }*/
   @Override
   public void draw(ModelBatch modelBatch, DecalBatch decalBatch) {

       direction.set(GameScreen.perspectiveCamera.up.x,0 , GameScreen.perspectiveCamera.up.z);
       decal.setRotation(direction, GameScreen.perspectiveCamera.up);
       decalBatch.add(decal);

   }
}
