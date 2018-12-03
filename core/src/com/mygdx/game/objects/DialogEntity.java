package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.interfaces.Item;
import com.mygdx.game.interfaces.Weapon;
import com.mygdx.game.systems.DialogManager;

/**
 * Created by Даниил on 03.12.2018.
 */
public class DialogEntity extends Entity {

    protected String title, text;

    public DialogEntity(String n, Sprite s, String text, String title) {
        super(n, s);
        this.text = text;
        this.title = title;
    }

    @Override
    public void putItem(Item item) {}

    @Override
    public void takeDamage(GameObject gameObject) {

        DialogManager.showObjectMessage(title, text);

    }

    @Override
    public void takeDamage(Weapon weapon) {}

}
