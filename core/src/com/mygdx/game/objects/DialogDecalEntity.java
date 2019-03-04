package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.decals.Decal;
import com.mygdx.game.graphics.RenderType3D;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.interfaces.Item;
import com.mygdx.game.interfaces.Weapon;
import com.mygdx.game.systems.DialogManager;

/**
 * Created by Даниил on 03.12.2018.
 */
public class DialogDecalEntity extends DecalEntity implements RenderType3D {


    protected String title, text;

    public DialogDecalEntity(String n, Decal s, String text, String title) {
        super(s,n);
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
