package com.mygdx.game;

import com.badlogic.gdx.*;
import com.mygdx.game.screens.GameScreen;

public class MyGdxGame extends Game{


	@Override
	public void create () {


	    setScreen(new GameScreen(this));

	}



}
