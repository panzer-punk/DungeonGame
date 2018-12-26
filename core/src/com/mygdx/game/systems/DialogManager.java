package com.mygdx.game.systems;

import com.badlogic.gdx.utils.Timer;
import com.mygdx.game.scene.HUD;
import com.mygdx.game.scene.SimpleDialog;

/**
 * Created by Даниил on 10.10.2018.
 *
 * Класс необходим для вывода на экран различных сообщений
 * Надписей на объектах
 * Информацию об объектах
 * Диалоги с NPC
 * и прочего
 */
public class DialogManager {

    static HUD hud;

    public static void init(HUD h){

        hud = h;


    }

    public static void showObjectMessage(String text, String name){//от вызова метода зависит тема применяемая к диалогу
        final SimpleDialog simpleDialog;
       simpleDialog = new SimpleDialog(name, hud.skin, hud);
       simpleDialog.text(text).show(hud.stage);
       hud.blockGameScreen();
       simpleDialog.button("Ok", true);

    }

    public static void showTitleDialog(String title, String text, int delay){}




}
