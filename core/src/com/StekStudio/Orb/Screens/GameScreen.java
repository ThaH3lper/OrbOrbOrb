package com.StekStudio.Orb.Screens;

import com.StekStudio.Orb.State.StandardScreen;
import com.StekStudio.Orb.World.World;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;

public class GameScreen extends StandardScreen{
	
	PolygonSpriteBatch polyBatch;
	World world;
	
	public GameScreen(){
	    world = new World();
	    polyBatch = new PolygonSpriteBatch();
	}
	
	@Override
	public void update(float delta) {
		world.update(delta);
	}

	@Override
	public void render() {
		batch.setProjectionMatrix(camera.combined);
		polyBatch.setProjectionMatrix(camera.combined);
		
		batch.begin();
		batch.setColor(1, 1, 1, opacity);
		polyBatch.begin();
		world.render(batch, polyBatch);
		
		polyBatch.end();
		batch.end();
	}

	@Override
	public void dispose() {
		polyBatch.dispose();
		batch.dispose();
	}
}
