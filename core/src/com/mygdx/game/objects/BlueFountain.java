package com.mygdx.game.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.decals.Decal;
import com.mygdx.game.build.NewTexturePack;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.systems.DialogManager;
import com.mygdx.game.tools.Dice;

/**
 * Created by Даниил on 03.12.2018.
 */
public class BlueFountain extends DialogSpriteEntity {
    public BlueFountain() {
        super("Blue Fountain", 21, 0, 0, "Fountain says","Can you hear me?",new Sprite(NewTexturePack.blueFountain));
    }

    public BlueFountain(String name, int hp, int x, int y, String title, String text, Sprite sprite) {
        super(name, hp, x, y, title, text, sprite);
    }
    public BlueFountain(String name, String title, String text) {
        super(name, 21, 0, 0, title, text, new Sprite(NewTexturePack.blueFountain));
    }

    @Override
    public void takeDamage(GameObject gameObject){

        if(gameObject.getDEX() + Dice.d20() >= 15)
           // DialogManager.showObjectMessage(name, text);
            DialogManager.showObjectDialog(title, "{SLOW}{WAVE}Hello," + gameObject.getName());
    }
}
