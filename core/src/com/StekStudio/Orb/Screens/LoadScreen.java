package com.StekStudio.Orb.Screens;

import com.StekStudio.Orb.OrbGame;
import com.StekStudio.Orb.State.EGameStates;
import com.StekStudio.Orb.State.StandardScreen;
import com.StekStudio.Orb.Utilities.ResManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class LoadScreen extends StandardScreen{

	private final float time = 5f, logoSize = 180;
	private float currentTime = 0;
	private boolean done = false;
	
	private float rotation = 0f, scale = 1f;
	
	public LoadScreen() {
		opacity = 1;
		camera.zoom = 1f;
	}
	@Override
	public void update(float delta) {
		camera.update();
		updateSin(delta);
		
		if(ResManager.manager.update())
			done = true;
		
		if(done && time < currentTime)
			OrbGame.setGameState(EGameStates.GAME);
	}

	@Override
	public void render() {
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		if(ResManager.manager.isLoaded("General/stek_logo.png"))
		{
			batch.setColor(1, 1, 1, opacity);
			batch.draw(new TextureRegion(ResManager.manager.get("General/stek_logo.png", Texture.class)), -logoSize/2, -logoSize/2, logoSize/2, logoSize/2, logoSize, logoSize, scale, scale, rotation);
			batch.setColor(opacity);
		}
		batch.end();
	}
	
	private void updateSin(float delta)
	{
		currentTime += delta;
		rotation = (float) Math.sin(currentTime * 3) * 10;
		scale = (float) ((Math.sin(currentTime * 2))/10) + 1;
	}
	
	@Override
	public void animateOut(float delta) {
		updateSin(delta);
		super.animateOut(delta);
	}

	@Override
	public void dispose() {
		
	}
}
