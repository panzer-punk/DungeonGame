package com.mygdx.game.build;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/**
 * Created by Даниил on 30.05.2018.
 */
public class TexturePack {

    TextureAtlas textures;
    private Texture wall, floor, floor1, hole, player, orc, skeleton, spider, door;

    public TexturePack(TextureAtlas textureAtlas){

        textures = textureAtlas;

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
    }

    //Terrain
    public Texture getFloor_min(){return floor;}//debug code
    public Texture getFloor_mid(){return floor1;}//debug code
    public Texture getFloor_max(){return null;}
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

}