package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Room room;
	Orc orc;
	GameObject player;
	Map map;

	@Override
	public void create () {
		batch = new SpriteBatch();
		map = new Map(20, 10, new Terrain(1, "test", new Texture("C:/Users/Даниил/Desktop/floor.png")));
		room = new Room(3,6, map);
		orc = new Orc();
		player = new Player("Donny", 50, 10, new Texture("C:/Users/Даниил/Desktop/player.png"));
		room.setObject(player);
		room.setObject(orc);
		room.move(0,0, 1, 1);
		room.move(0, 1, 2, 1);
	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		room.drawMap(batch);
		room.drawObjects(batch);
		batch.end();
	}

	public void update(){}

	@Override
	public void dispose () {
		batch.dispose();
//		img.dispose();
	}
}
