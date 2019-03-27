package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.decals.Decal;
import com.badlogic.gdx.graphics.g3d.decals.DecalBatch;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.build.NewTexturePack;
import com.mygdx.game.screens.EditorScreen;
import com.mygdx.game.screens.GameScreen;

/**
 * Created by Даниил on 03.12.2018.
 */
public class Column extends DialogSpriteEntity {

    public Column(String name, int hp, int x, int y, String title, String text, Sprite sprite) {
        super(name, hp, x, y, title, text, sprite);
    }
    public Column(){
        super("Columns", 20, 0, 0, "Writing on column",
                "It's been a while", new Sprite(NewTexturePack.crumbledColumn));
    }
}
