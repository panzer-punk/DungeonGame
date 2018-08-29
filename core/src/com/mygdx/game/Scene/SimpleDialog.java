package com.mygdx.game.Scene;

import com.badlogic.gdx.scenes.scene2d.ui.*;


/**
 * Created by Даниил on 29.08.2018.
 */
public class SimpleDialog extends com.badlogic.gdx.scenes.scene2d.ui.Dialog {

    public SimpleDialog(String title, Skin skin) {
        super(title, skin);
    }

    @Override
    public Dialog text(String text) {

        Label label = new Label(text,getSkin());
        label.setBounds(0,0,250,250);

        getContentTable().reset();
        text(label);


        return this;

    }
}
