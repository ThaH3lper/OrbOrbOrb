package com.StekStudio.Orb.Screens;

import com.StekStudio.Orb.Polygon.PolygonObject;
import com.StekStudio.Orb.State.IState;
import com.StekStudio.Orb.Utilities.ResManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GameScreen implements IState{
	
	PolygonObject pol;
	PolygonSpriteBatch polyBatch;
	
	OrthographicCamera camera;
	
	public GameScreen(){
		camera = new OrthographicCamera(ResManager.virtualWidth, ResManager.virtualNewHeight);
		camera.update();
		
		System.out.println(ResManager.virtualWidth + " " + ResManager.virtualNewHeight);
		
	    Vector2[] points = new Vector2[5];
	    points[0] = new Vector2(-50, -50);
	    points[1] = new Vector2(50, -50);
	    points[2] = new Vector2(0, 0);
	    points[3] = new Vector2(100, 100);
	    points[4] = new Vector2(-70, 160);
	    pol = new PolygonObject(new Vector2(0, 0), Color.GREEN, points);
	    
	    polyBatch = new PolygonSpriteBatch();
	}
	
	@Override
	public void update(float delta) {

	}

	@Override
	public void render(SpriteBatch batch) {
		polyBatch.begin();
		polyBatch.setProjectionMatrix(camera.combined);
		pol.render(polyBatch);
		polyBatch.end();
	}

	@Override
	public void dispose() {
	}

}
