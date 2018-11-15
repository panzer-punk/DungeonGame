package com.mygdx.game.systems;

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

        new SimpleDialog(name, hud.skin).text(text).show(hud.stage);//Тест


    }

    public static void showLettering(String title, String text){


    }



}
