package com.StekStudio.Orb.State;

import com.StekStudio.Orb.Utilities.ResManager;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class StandardScreen implements IState{

	protected OrthographicCamera camera;
	protected SpriteBatch batch;
	float currentTime = 0f, time = 0.7f;
	boolean animationDone;
	protected float opacity = 0f;
	
	public StandardScreen() {
		batch = new SpriteBatch();
		camera = new OrthographicCamera(ResManager.virtualWidth, ResManager.virtualNewHeight);
		camera.zoom = 1.84f;
		camera.update();
	}
	
	@Override
	public abstract void update(float delta);

	@Override
	public abstract void render();

	@Override
	public void dispose() {
		
	}

	@Override
	public void animateOut(float delta) {
		opacity -= 1.2f * delta;
		currentTime += delta;
		camera.zoom += delta * 0.5f;
		camera.update();
		if(currentTime > time)
			animationDone = true;
	}

	@Override
	public void animationIn(float delta) {
		currentTime += delta;
		camera.zoom -= delta * 1.2f;
		camera.update();
	}
	@Override
	public void resetZoomAndOpacity(){
		camera.zoom = 1f;
		opacity = 1f;
	}

	@Override
	public boolean isAnimationDone() {
		return animationDone;
	}

}
