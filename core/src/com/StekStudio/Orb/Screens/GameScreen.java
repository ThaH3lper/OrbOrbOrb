package com.StekStudio.Orb.Screens;

import com.StekStudio.Orb.State.StandardScreen;
import com.StekStudio.Orb.Utilities.Controller;
import com.StekStudio.Orb.Utilities.ResManager;
import com.StekStudio.Orb.World.World;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class GameScreen extends StandardScreen{
	
	PolygonSpriteBatch polyBatch;
	ShapeRenderer renderer;
	Controller controller;
	World world;
	
	public GameScreen(){
	    world = new World();
	    polyBatch = new PolygonSpriteBatch();
	    
	    renderer = new ShapeRenderer();
	    renderer.setAutoShapeType(true);
	    
	    controller = new Controller(world.getOrb());
		camera.position.y = world.getOrb().getPosition().y - ResManager.virtualHeight/2 + ResManager.orbMargin;
		camera.update();
	}
	
	@Override
	public void update(float delta) {
		controller.update(this);
		world.update(delta);
		camera.position.y = world.getOrb().getPosition().y - ResManager.virtualHeight/2 + ResManager.orbMargin;
		camera.update();
		
	}

	@Override
	public void render() {
		batch.setProjectionMatrix(camera.combined);
		polyBatch.setProjectionMatrix(camera.combined);
		renderer.setProjectionMatrix(camera.combined);
			
		polyBatch.begin();
		world.renderPoly(polyBatch);
		polyBatch.end();
		
		Gdx.gl.glEnable(GL20.GL_BLEND);
	    Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		renderer.begin();
	    renderer.set(ShapeType.Filled);
		world.renderOrb(renderer);
		renderer.end();
		Gdx.gl.glDisable(GL20.GL_BLEND);
	}

	@Override
	public void dispose() {
		polyBatch.dispose();
		batch.dispose();
	}
}
