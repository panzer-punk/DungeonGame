package com.mygdx.game.scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.systems.DialogManager;
import com.rafaskoberg.gdx.typinglabel.TypingLabel;

/**
 * Created by Даниил on 09.01.2019.
 */
public class NPCDialog extends Dialog {
    private HUD hud;
    private TypingLabel typingLabel;
    private Table btnTable;
    public NPCDialog(String title, Skin skin, HUD holder) {
        super(title, skin);
        typingLabel = new TypingLabel("", skin);
      //  setDebug(true);
        btnTable = getButtonTable();
        getContentTable().left();
        getContentTable().top();
        getContentTable().add(typingLabel);
                getContentTable().row();
        getButtonTable().pad(25,0,0,0);
        hud = holder;
    }

    @Override
    public Dialog text(String string) {
        typingLabel.setText(string);
       getContentTable().add(typingLabel);
       return this;
    }

    @Override
    public Dialog button(String text, final Object object) {
        TextButton button = new TextButton(text, hud.skin);
        button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){

                result(object);

            }
        });
        btnTable.add(button).row();
        return this;
    }


    @Override
    public Dialog show(Stage stage){
        return super.show(stage);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        typingLabel.act(Gdx.graphics.getDeltaTime());
    }

    @Override
    public void result(Object o){

       // hud.unblockGameScreen();
        this.remove();

    }
}
