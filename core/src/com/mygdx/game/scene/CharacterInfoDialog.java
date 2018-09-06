package com.mygdx.game.scene;


import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.interfaces.GameObject;

/**
 * Created by Даниил on 01.09.2018.
 */
public class CharacterInfoDialog extends Dialog {

    private Stage stage;
    private boolean activeFlag = false;

    public CharacterInfoDialog( Skin skin, Stage stage) {
        super("Info", skin);
        this.stage = stage;
    }

    public void show(GameObject gameObject ){

        if(activeFlag)
            activeFlag = false;
        else
            activeFlag = true;
        if(activeFlag) {
            text("Health points: " + gameObject.getHP() + "\n" +
                    "Movement points: " + gameObject.getMP() + "\n" +
                    "Strength (+ mod)" + gameObject.getStrength() + "( " + gameObject.getSTR() + ")" + "\n" +
                    "Constitution (+ mod)" + gameObject.getConstitution() + "( " + gameObject.getCON() + ")" + "\n" +
                    "Dexterity (+ mod)" + gameObject.getDexterity() + "( " + gameObject.getDEX() + ")" + "\n" +
                    "Armor Class (AC) " + gameObject.getArmor().getArmor() + "\n" +
                    "Weapon (Distance)" + gameObject.getWeapon().getLabel() + gameObject.getWeapon().getDistance());

            show(stage);
        }else
            hide();
    }

}
