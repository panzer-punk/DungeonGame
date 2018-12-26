package com.mygdx.game.build;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 * Created by Даниил on 20.12.2018.
 */
public class NewTexturePack {

    public static TextureRegion wall, floor, floor1, hole, player, orc, skeleton,
            spider, door, sand, sand1, sand2, water, water1,
            dirt, dirt1, dirt2, dirt3, dirt4,
            blueFountain, celticFire, chestClosed,
            chestOpen, crumbledColumn, tomb1,
            orcishIdol;
    public static TextureRegion arrow;
    public static Image inventory;
    public static Skin skin;

    public static  void init(){

        wall = new TextureRegion(new Texture(Gdx.files.internal("wall.png")));
        floor = new TextureRegion(new Texture(Gdx.files.internal("floor.png")));
        floor1 = new TextureRegion(new Texture(Gdx.files.internal("floor1.png")));
        hole = new TextureRegion(new Texture(Gdx.files.internal("hole.png")));
        player = new TextureRegion(new Texture(Gdx.files.internal("player.png")));
        orc = new TextureRegion(new Texture(Gdx.files.internal("orc.png")));
        skeleton = new TextureRegion(new Texture(Gdx.files.internal("skeleton.png")));
        spider = new TextureRegion( new Texture(Gdx.files.internal("spider.png")));
        door = new TextureRegion(new Texture(Gdx.files.internal("door.png")));
        sand = new TextureRegion( new Texture(Gdx.files.internal("sand.png")));
        sand1 = new TextureRegion(new Texture(Gdx.files.internal("sand1.png")));
        sand2 = new TextureRegion( new Texture(Gdx.files.internal("sand2.png")));
        water = new TextureRegion( new Texture(Gdx.files.internal("water.png")));
        water1 = new TextureRegion(new Texture(Gdx.files.internal("water1.png")));
        inventory = new Image(new Texture(Gdx.files.internal("inventoryicon.png")));
        dirt  = new TextureRegion (new Texture(Gdx.files.internal("dirt.png")));
        dirt1 = new TextureRegion (new Texture(Gdx.files.internal("dirt1.png")));
        dirt2 = new TextureRegion(new Texture(Gdx.files.internal("dirt2.png")));
        dirt3 = new TextureRegion(new Texture(Gdx.files.internal("dirt3.png")));
        dirt4 = new TextureRegion(new Texture(Gdx.files.internal("dirt4.png")));
        blueFountain = new TextureRegion(new Texture(Gdx.files.internal("blue_fountain.png")));
        celticFire = new TextureRegion(new Texture(Gdx.files.internal("celtic_fire.png")));
        chestClosed = new TextureRegion(new Texture(Gdx.files.internal("chest_closed.png")));
        chestOpen = new TextureRegion(new Texture(Gdx.files.internal("chest_open.png")));
        crumbledColumn = new TextureRegion(new Texture(Gdx.files.internal("crumbled_column.png")));
        orcishIdol = new TextureRegion(new Texture(Gdx.files.internal("orcish_idol.png")));
        tomb1 = new TextureRegion(new Texture(Gdx.files.internal("tomb1.png")));
        arrow = new TextureRegion(new Texture(Gdx.files.internal("arrow.png")));
        skin = new Skin(Gdx.files.internal("uiskin.json"));

    }
}
