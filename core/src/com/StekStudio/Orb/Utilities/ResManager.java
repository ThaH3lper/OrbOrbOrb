package com.StekStudio.Orb.Utilities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;

public class ResManager {
	
	public static Texture dot;
	
	public static final int virtualWidth = 240, virtualHeight = 320;
	public static int virtualNewHeight;
	
	public static void load(){
		virtualNewHeight = (int)(((float)Gdx.graphics.getHeight()/(float)Gdx.graphics.getWidth()) * (float)virtualWidth);
		
		Pixmap pixel = new Pixmap(1, 1, Format.RGB565);
		pixel.setColor(Color.WHITE);
		pixel.fill();
		dot = new Texture(pixel);
	}

}
