package com.StekStudio.Orb;

import com.StekStudio.Orb.Screens.GameScreen;
import com.StekStudio.Orb.State.EGameStates;
import com.StekStudio.Orb.State.IState;
import com.StekStudio.Orb.Utilities.ResManager;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class OrbGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private static IState currentState;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		ResManager.load();
		setGameState(EGameStates.GAME);
	}
	public void update()
	{
		float delta = Gdx.graphics.getDeltaTime();
		currentState.update(delta);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		currentState.render(batch);
		batch.end();
	}
	
	public static void setGameState(EGameStates state)
	{
		switch (state) {
		case GAME:
			currentState = new GameScreen();
			break;
		case WELCOME:
			
			break;
		case LEVEL:
			
			break;
		}
	}
}
