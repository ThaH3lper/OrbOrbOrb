package com.StekStudio.Orb.Polygon;

import com.StekStudio.Orb.Utilities.ResManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.PolygonRegion;
import com.badlogic.gdx.graphics.g2d.PolygonSprite;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class PolygonObject {
	
	private PolygonSprite poly;
	private Line[] lines;
	
	public PolygonObject(Vector2 position, Color color, Vector2[] points)
	{
		//Generate lines, triangles and 
		lines = new Line[points.length];
		
		float[] vertices = new float[points.length * 2];
		short[] triangles = new short[(3 * points.length) - 6];
		for(int i = 0; i < points.length; i++)
		{
			if(i + 1 >= points.length)
				lines[i] = new Line(new Vector2(points[i].x + position.x, points[i].y + position.y), new Vector2(points[0].x + position.x, points[0].y + position.y));
			else
				lines[i] = new Line(new Vector2(points[i].x + position.x, points[i].y + position.y), new Vector2(points[i + 1].x + position.x, points[i + 1].y + position.y));
			
			vertices[i * 2] = points[i].x;
			vertices[(i * 2) + 1] = points[i].y;
			
			if(i >= 2)
			{
				int temp = (i-2) * 3;
				triangles[temp] = 0;
				triangles[temp + 1] = (short) (i-2 + 1);
				triangles[temp + 2] = (short) (i-2 + 2);
			}
		}
		PolygonRegion polyReg = new PolygonRegion(new TextureRegion(ResManager.manager.get("General/dot.png", Texture.class)), vertices, triangles);
		
		poly = new PolygonSprite(polyReg);
	    poly.setPosition(position.x, position.y);
	    poly.setColor(color);

	}
	public void update(float delta)
	{
		
	}
	
	public void render(PolygonSpriteBatch polyBatch){
	    poly.draw(polyBatch);
	}
	
	public void setColor(Color color){
		poly.setColor(color);
	}
	
	public Line[] getLines(){
		return lines;
	}
}
