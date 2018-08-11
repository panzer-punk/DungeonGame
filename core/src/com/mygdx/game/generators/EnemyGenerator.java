package com.mygdx.game.generators;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.armor.LeatherArmor;
import com.mygdx.game.build.TexturePack;
import com.mygdx.game.interfaces.Armor;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.interfaces.Weapon;
import com.mygdx.game.playable.Orc;
import com.mygdx.game.playable.Skeleton;
import com.mygdx.game.playable.Spider;
import com.mygdx.game.tools.BuffPool;
import com.mygdx.game.weaponry.SpiderBite;

/**
 * Created by Даниил on 11.09.2017.
 */
public class EnemyGenerator {

    GameObject enemy;
    TexturePack texturePack;

    public EnemyGenerator(TexturePack texturePack){

        this.texturePack = texturePack;

    }

    public GameObject createEemy(Armor armor, Weapon weapon){


        int r = (int)(Math.random()*3) + 1;
        switch (r) {
            case 1:

                enemy = new Orc(new Sprite(texturePack.getOrc()));

                break;
            case 2:

                enemy = new Skeleton(new Sprite(texturePack.getSkeleton()));

                break;

            case 3:

                enemy = new Spider(new Sprite(texturePack.getSpider()));
                enemy.equipWeapon(new SpiderBite());
                enemy.equipArmor(new LeatherArmor());

                break;
        }

        if(enemy.getClass() != Spider.class) {
            enemy.equipArmor(armor);
            enemy.equipWeapon(weapon);
        }

        return  enemy;
    }
}
