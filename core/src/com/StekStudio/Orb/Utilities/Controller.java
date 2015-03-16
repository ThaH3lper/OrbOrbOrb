package com.StekStudio.Orb.Utilities;

import com.StekStudio.Orb.Entity.Orb;
import com.StekStudio.Orb.Screens.GameScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Controller {

	Orb orb;
	public Controller(Orb orb)
	{
		this.orb = orb;
	}
	
	public void update(GameScreen screen)
	{
		if(Gdx.input.isTouched(0))
			orb.moveToX(screen.screenToWorld(new Vector2(Gdx.input.getX(0), 0)).x);	
	}
}
