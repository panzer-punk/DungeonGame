package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.decals.Decal;
import com.mygdx.game.build.NewTexturePack;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.systems.DialogManager;
import com.mygdx.game.tools.Dice;

/**
 * Created by Даниил on 03.12.2018.
 */
public class BlueFountain extends DialogDecalEntity {
    public BlueFountain() {
        super("Fountain", Decal.newDecal(0.8f, 0.8f, NewTexturePack.blueFountain, true), "Fountain says:", "Can you hear me?");
    }

    public BlueFountain(String n, Decal s, String text, String title) {
        super(n, s, text, title);
    }

    @Override
    public void takeDamage(GameObject gameObject){

        if(gameObject.getDEX() + Dice.d20() >= 15)
           // DialogManager.showObjectMessage(name, text);
            DialogManager.showObjectDialog(text, "{SLOW}{WAVE}Hello," + gameObject.getName());
    }
}
