package com.StekStudio.Orb.World;

import java.util.ArrayList;
import java.util.List;

import com.StekStudio.Orb.Entity.Orb;
import com.StekStudio.Orb.Polygon.PolygonObject;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class World {

	List<PolygonObject> listPolygons;
	Orb orb;
	public World()
	{
		listPolygons = new ArrayList<PolygonObject>();
		orb = new Orb();
		//Test Object
	    Vector2[] points = new Vector2[5];
	    points[0] = new Vector2(20, 20);
	    points[1] = new Vector2(20, -20);
	    points[2] = new Vector2(0, 0);
	    points[3] = new Vector2(-20, -20);
	    points[4] = new Vector2(-20, 20);
	    listPolygons.add(new PolygonObject(new Vector2(-100, 0), Color.GREEN, points));
	}
	
	public void update(float delta)
	{
		orb.update(delta);
		for(PolygonObject po : listPolygons)
			po.update(delta);
	}
	public void render(SpriteBatch batch, PolygonSpriteBatch polyBatch)
	{
		for(PolygonObject po : listPolygons)
			po.render(polyBatch);
		
	}
}
