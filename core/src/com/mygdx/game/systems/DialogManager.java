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

    public static void showObjectMessage(String name, String text){//от вызова метода зависит тема применяемая к диалогу
        final SimpleDialog simpleDialog;
       simpleDialog = new SimpleDialog(text, hud.skin);
       simpleDialog.text(name).show(hud.stage);

        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {

                simpleDialog.remove();

            }
        },3);

    }

    public static void showLettering(String title, String text){


    }



}
