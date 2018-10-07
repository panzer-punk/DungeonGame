package com.mygdx.game.build;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.tools.Dice;

/**
 * Created by Даниил on 30.05.2018.
 */
public class TexturePack {

    TextureAtlas textures;
    private Texture wall, floor, floor1, hole, player, orc, skeleton,
                    spider, door, sand, sand1, sand2, water, water1,
                    dirt, dirt1, dirt2, dirt3, dirt4;
    private Image inventory;
    private Skin skin;

    public TexturePack(TextureAtlas textureAtlas){

        textures = textureAtlas;
        skin = new Skin(Gdx.files.internal("rusty-robot-ui.json"));

    }

    public TexturePack() {//default texture pack

        wall = new Texture(Gdx.files.internal("wall.png"));
        floor = new Texture(Gdx.files.internal("floor.png"));
        floor1 = new Texture(Gdx.files.internal("floor1.png"));
        hole = new Texture(Gdx.files.internal("hole.png"));
        player = new Texture(Gdx.files.internal("player.png"));
        orc = new Texture(Gdx.files.internal("orc.png"));
        skeleton = new Texture(Gdx.files.internal("skeleton.png"));
        spider = new Texture(Gdx.files.internal("spider.png"));
        door = new Texture(Gdx.files.internal("door.png"));
        sand = new Texture(Gdx.files.internal("sand.png"));
        sand1 = new Texture(Gdx.files.internal("sand1.png"));
        sand2 = new Texture(Gdx.files.internal("sand2.png"));
        water = new Texture(Gdx.files.internal("water.png"));
        water1 = new Texture(Gdx.files.internal("water1.png"));
        inventory = new Image(new Texture(Gdx.files.internal("inventoryicon.png")));
        dirt  = new Texture(Gdx.files.internal("dirt.png"));
        dirt1 = new Texture(Gdx.files.internal("dirt1.png"));
        dirt2 = new Texture(Gdx.files.internal("dirt2.png"));
        dirt3 = new Texture(Gdx.files.internal("dirt3.png"));
        dirt4 = new Texture(Gdx.files.internal("dirt4.png"));
        skin = new Skin(Gdx.files.internal("rusty-robot-ui.json"));

    }

    //Terrain
    public Texture getFloor_min(){return floor;}//debug code
    public Texture getFloor_mid(){return floor1;}//debug code
    public Texture getFloor_max(){return null;}

    public Skin getSkin() {
        return skin;
    }

    public Texture getSand(){

        switch (Dice.d4()){

            case 1:
                return sand1;
            case 2:
                return sand2;

                default:
                    return sand;


        }

    }

    public Texture getWater(){

        switch (Dice.d4()){

            case 1:
            case 2:
                return water1;
                default:
                    return water;

        }

    }

    public Texture getDirt(){

        switch (Dice.d4()){

            case 1:
                return dirt;
            case 2:
                return dirt1;
            case 3:
                return dirt2;
            case 4:
                return dirt3;
                default:
                    return dirt4;


        }


    }

    public Texture getHole(){return hole;}//debug code
    //Entity
    public Texture getWall_1(){return wall;}//debug code
    public Texture getWall_2(){return null;}
    public Texture getDoor(){return door;}
    //Items
    public Texture getSword_1(){return null;}
    public Texture getSword_2(){return null;}
    public Texture getSword_3(){return null;}
    public Texture getArmor_1(){return null;}
    public Texture getArmor_2(){return null;}
    public Texture getArmor_3(){return null;}
    //Enemies
    public Texture getOrc(){return orc;}
    public Texture getSkeleton(){return skeleton;}
    public Texture getSpider(){return spider;}
    //Player (debug)
    public Texture getPlayer(){return player;}
    //Icons
    public Image getInventoryIcon(){return inventory;}

}