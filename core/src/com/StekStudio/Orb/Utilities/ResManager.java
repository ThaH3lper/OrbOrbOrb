package com.StekStudio.Orb.Utilities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.TextureLoader.TextureParameter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;

public class ResManager {
	
	public static final int virtualWidth = 240, virtualHeight = 320, orbMargin = 20;
	public static int virtualNewHeight, paddingHeight;
	public static AssetManager manager;
	
	public static void load(){
		virtualNewHeight = (int)(((float)Gdx.graphics.getHeight()/(float)Gdx.graphics.getWidth()) * (float)virtualWidth);
		paddingHeight = (virtualNewHeight - virtualHeight) / 2;
		
		manager = new AssetManager();
		
		TextureParameter param = new TextureParameter();
		param.minFilter = TextureFilter.Linear;
		
		manager.load("General/stek_logo.png", Texture.class, param);
		manager.load("General/dot.png", Texture.class, param);
	}

}
