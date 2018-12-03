package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.tools.Dice;

/**
 * Created by Даниил on 03.12.2018.
 */
public class BlueFountain extends DialogEntity {
    public BlueFountain(Sprite sprite) {
        super("Fountain", sprite, "Fountain says:", "Can you hear me?");
    }

    @Override
    public void takeDamage(GameObject gameObject){

        if(gameObject.getDEX() + Dice.d20() >= 15)
            super.takeDamage(gameObject);

    }
}
