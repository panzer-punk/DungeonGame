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

    public TexturePack(TextureAtlas textureAtlas){

        textures = textureAtlas;

    }
    //Terrain
    public Texture getFloor_min(){return new Texture (Gdx.files.internal("floor.png"));}//debug code
    public Texture getFloor_mid(){return new Texture(Gdx.files.internal("floor1.png"));}//debug code
    public Texture getFloor_max(){return null;}
    public Texture getHole(){return new Texture(Gdx.files.internal("hole.png"));}//debug code
    //Entity
    public Texture getWall_1(){return new Texture(Gdx.files.internal("wall.png"));}//debug code
    public Texture getWall_2(){return null;}
    //Items
    public Texture getSword_1(){return null;}
    public Texture getSword_2(){return null;}
    public Texture getSword_3(){return null;}
    public Texture getArmor_1(){return null;}
    public Texture getArmor_2(){return null;}
    public Texture getArmor_3(){return null;}
    //Enemies
    public Texture getOrc(){return new Texture(Gdx.files.internal("orc.png")); }


}
