package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by Даниил on 03.12.2018.
 */
public class Column extends DialogEntity {
    public Column(Sprite sprite) {
        super("Column", sprite, "Column says:", "I'm talking column, but it's fine to me.");
    }
}
