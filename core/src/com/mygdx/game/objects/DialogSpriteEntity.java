package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.interfaces.Weapon;
import com.mygdx.game.systems.DialogManager;

/**
 * Created by Даниил on 27.03.2019.
 */
public class DialogSpriteEntity extends SpriteEntity {
    protected String title, text;

    public DialogSpriteEntity(String name, int hp, int x, int y,String title, String text, Sprite sprite) {
        super(name, hp, x, y, sprite);
        this.title = title;
        this.text = text;
    }

    @Override
    public void takeDamage(GameObject gameObject) {

        DialogManager.showObjectMessage(text, title);

    }

    @Override
    public void takeDamage(Weapon weapon) {}


}
