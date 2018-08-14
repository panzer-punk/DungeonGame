package com.mygdx.game;

import com.badlogic.gdx.*;
import com.mygdx.game.build.TexturePack;
import com.mygdx.game.screens.EditorScreen;
import com.mygdx.game.screens.GameScreen;
import com.mygdx.game.screens.MainMenuScreen;

public class MyGdxGame extends Game{


	@Override
	public void create () {


	    setScreen(new MainMenuScreen(this, new TexturePack()));

	}



}
