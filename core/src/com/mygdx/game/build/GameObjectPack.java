package com.mygdx.game.build;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.objects.Door;
import com.mygdx.game.objects.Entity;
import com.mygdx.game.playable.Orc;
import com.mygdx.game.playable.Skeleton;
import com.mygdx.game.playable.Spider;

public class GameObjectPack {

    private TexturePack texturePack;

    public GameObjectPack(TexturePack texturePack) {
        this.texturePack = texturePack;
    }

    public GameObject getObjectById(int id){

        GameObject gameObject = null;

        switch (id){

            case 1:

                gameObject = new Orc(new Sprite(texturePack.getOrc()));
                break;

            case 2:

                gameObject = new Skeleton(new Sprite(texturePack.getSkeleton()));
                break;

            case 3:

                gameObject = new Spider(new Sprite(texturePack.getSpider()));
                break;

            case 4:

                break;

                default:

                    gameObject = new Entity("Wall", new Sprite(texturePack.getWall_1()));



        }

        return gameObject;

    }

}
