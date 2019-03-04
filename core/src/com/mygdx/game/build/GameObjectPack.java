package com.mygdx.game.build;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.decals.Decal;
import com.mygdx.game.interfaces.GameObject;
import com.mygdx.game.items.CelticFire;
import com.mygdx.game.objects.*;
import com.mygdx.game.playable.Orc;
import com.mygdx.game.playable.Skeleton;
import com.mygdx.game.playable.Spider;

public class GameObjectPack {

    private TexturePack texturePack;
    private AssetManager assetManager;

    public GameObjectPack(TexturePack texturePack, AssetManager assetManager) {
        this.texturePack = texturePack;
        this.assetManager = assetManager;
    }

    public  GameObject getObjectById(int id){

        GameObject gameObject = null;

        switch (id){

            case 1:

                gameObject = new Orc();
                break;

            case 2:

                gameObject = new Skeleton();
                break;

            case 3:

                gameObject = new Spider();
                break;

            case 4:

                gameObject = new BlueFountain();

                break;

            case 6:
                gameObject = new Column();
                break;

            case 7:
                gameObject = new CelticFire();
                break;
            case 8:
                gameObject = new Chest();
                break;

            case 5:
                default:

                    gameObject = new ModelEntity("Wall", assetManager.get("wall.obj", Model.class));



        }

        return gameObject;

    }

}
