package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		//System.setProperty("org.lwjgl.opengl.Display.allowSoftwareOpenGL", "true");
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		System.setProperty("user.name", "Public");//заставвляет openAl работать
		config.forceExit = true;
		config.height =720;
		config.width = 1080;
		config.vSyncEnabled = true; // Setting to false disables vertical sync
		config.foregroundFPS = 0; // Setting to 0 disables foreground fps throttling
		config.backgroundFPS = 0; // Setting to 0 disables background fps throttling
		new LwjglApplication(new MyGdxGame(), config);
	}
}
