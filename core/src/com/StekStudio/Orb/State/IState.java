package com.StekStudio.Orb.State;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface IState {

	void update(float delta);
	
	void render(SpriteBatch batch);
}
