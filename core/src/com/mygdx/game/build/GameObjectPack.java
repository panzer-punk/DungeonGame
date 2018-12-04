package com.mygdx.game.build;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.items.CelticFire;
import com.mygdx.game.objects.*;
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

                gameObject = new BlueFountain(new Sprite((texturePack.getBlueFountain())));

                break;

            case 6:
                gameObject = new Column(new Sprite(texturePack.getCrumbledColumn()));
                break;

            case 7:
                gameObject = new CelticFire(new Sprite(texturePack.getCelticFire()));
                break;
            case 8:
                gameObject = new Chest(new Sprite(texturePack.getChestClosed()), new Sprite(texturePack.getChestOpen()));
                break;

            case 5:
                default:

                    gameObject = new Entity("Wall", new Sprite(texturePack.getWall_1()));



        }

        return gameObject;

    }

}
