package com.StekStudio.Orb.State;


public interface IState {

	void update(float delta);
	
	void render();
	
	void dispose();
	
	void animateOut(float delta);
	
	void animationIn(float delta);
	
	boolean isAnimationDone();
	
	void resetZoomAndOpacity();
}
