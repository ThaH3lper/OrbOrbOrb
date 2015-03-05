package com.StekStudio.Orb.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.StekStudio.Orb.OrbGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
		//16:9
		config.width = 360;
		config.height = 640;
		
		//3:2
		//config.width = 320;
		//config.height = 480;
		
		//4:3
		//config.width = 240;
		//config.height = 320;
		new LwjglApplication(new OrbGame(), config);
	}
}
