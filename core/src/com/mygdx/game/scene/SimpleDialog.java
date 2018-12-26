package com.mygdx.game.scene;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;


/**
 * Created by Даниил on 29.08.2018.
 */
public class SimpleDialog extends com.badlogic.gdx.scenes.scene2d.ui.Dialog {

    private HUD hud;

    public SimpleDialog(String title, Skin skin, HUD hud) {
        super(title, skin);
        getContentTable().padTop(15);
        getButtonTable().padTop(20);
        this.hud = hud;
    }

    @Override
    public Dialog text(String text) {
        super.text(text);
        return this;

    }

    @Override
    public Dialog show(Stage stage){
        hud.blockGameScreen();
        return super.show(stage);
    }

    @Override
    public void result(Object o){

        hud.unblockGameScreen();
        this.remove();

    }
}
