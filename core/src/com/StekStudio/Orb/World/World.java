package com.StekStudio.Orb.World;

import java.util.ArrayList;
import java.util.List;

import com.StekStudio.Orb.Entity.Orb;
import com.StekStudio.Orb.Polygon.Line;
import com.StekStudio.Orb.Polygon.PolygonObject;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Intersector;
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
	    points[0] = new Vector2(120, 20);
	    points[1] = new Vector2(0, 0);
	    points[2] = new Vector2(-70, 0);
	    points[3] = new Vector2(-70, -50);
	    points[4] = new Vector2(120, -40);
	    listPolygons.add(new PolygonObject(new Vector2(0, -300), Color.GREEN, points));
	    
	    points = new Vector2[5];
	    points[0] = new Vector2(-120, 20);
	    points[1] = new Vector2(0, 0);
	    points[2] = new Vector2(70, 0);
	    points[3] = new Vector2(70, -50);
	    points[4] = new Vector2(-120, -40);
	    listPolygons.add(new PolygonObject(new Vector2(0, -600), Color.GREEN, points));
	}
	
	public void update(float delta)
	{
		orb.update(delta);
		for(PolygonObject po : listPolygons)
			po.update(delta);
		collision();
	}
	public void renderPoly(PolygonSpriteBatch polyBatch){
			for(PolygonObject po : listPolygons)
				po.render(polyBatch);
	}
	
	public boolean collision()
	{
		for(PolygonObject po : listPolygons)
		{
			for (Line line : po.getLines()) {
				if(Intersector.distanceSegmentPoint(line.getStart(),line.getEnd(), orb.getPosition()) <= 7)
				{
					System.out.println(Intersector.distanceSegmentPoint(line.getStart(),line.getEnd(), orb.getPosition()));
					orb.setColor(Color.YELLOW);
					return true;
				}
			}
		}
		return false;
	}
	
	public void renderOrb(ShapeRenderer render){
		orb.render(render);	
	}
	
	public Orb getOrb(){
		return orb;
	}
}
