package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/**
 * Created by Даниил on 30.05.2018.
 */
public class TexturePack {

    TextureAtlas textures;

    public TexturePack(TextureAtlas textureAtlas){

        textures = textureAtlas;

    }
    //Terrain
    public Texture getFloor_min(){return new Texture("C:/Users/Даниил/Desktop/floor.png");}//debug code
    public Texture getFloor_mid(){return new Texture("C:/Users/Даниил/Desktop/floor1.png");}//debug code
    public Texture getFloor_max(){return null;}
    public Texture getHole(){return new Texture("C:/Users/Даниил/Desktop/hole.png");}//debug code
    //Entity
    public Texture getWall_1(){return new Texture("C:/Users/Даниил/Desktop/wall.png");}//debug code
    public Texture getWall_2(){return null;}
    //Items
    public Texture getSword_1(){return null;}
    public Texture getSword_2(){return null;}
    public Texture getSword_3(){return null;}
    public Texture getArmor_1(){return null;}
    public Texture getArmor_2(){return null;}
    public Texture getArmor_3(){return null;}
    //Enemies


}
