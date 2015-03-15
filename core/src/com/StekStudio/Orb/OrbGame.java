package com.StekStudio.Orb;

import com.StekStudio.Orb.Screens.GameScreen;
import com.StekStudio.Orb.Screens.LoadScreen;
import com.StekStudio.Orb.State.EGameStates;
import com.StekStudio.Orb.State.IState;
import com.StekStudio.Orb.Utilities.ResManager;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class OrbGame extends ApplicationAdapter {
	private static IState currentState, outState;
	static boolean animation;
	
	@Override
	public void create () {
		ResManager.load();
		setGameState(EGameStates.LOADING);
	}
	
	public void update()
	{
		float delta = Gdx.graphics.getDeltaTime();
		if(animation)
		{
			currentState.animationIn(delta);
			if(outState != null)
			{
				outState.animateOut(delta);
				if(outState.isAnimationDone())
				{
					currentState.resetZoomAndOpacity();
					animation = false;
					outState.dispose();
					outState = null;
				}
			}
		}
		else
			currentState.update(delta);
	}

	@Override
	public void render () {
		update();
		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		currentState.render();
		if(outState != null)
			outState.render();
	}
	
	public static void setGameState(EGameStates state)
	{
		if(currentState != null){
			outState = currentState;
			animation = true;
		}
		switch (state) {
		case GAME:
			currentState = new GameScreen();
			break;
		case WELCOME:
			
			break;
		case LEVEL:
			
			break;
		case LOADING:
			currentState = new LoadScreen();
			break;
		}
	}
}
