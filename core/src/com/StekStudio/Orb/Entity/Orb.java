package com.StekStudio.Orb.Entity;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Orb {

	Vector2 position;
	final float orbRadius = 16, recSize = 7;
	float rotation;
	float speed = -170;
	Color color;
	
	public Orb()
	{
		position = new Vector2(0, 0);
		color = Color.RED;
	}
	
	public void update(float delta)
	{
		rotation += 100f * delta;
		position.y += speed * delta;
	}
	
	public void render(ShapeRenderer render)
	{
		render.setColor(0.5f, 0.3f, 0.8f, 0.5f);
		render.circle(position.x, position.y, orbRadius);
		render.setColor(color);
		render.circle(position.x, position.y, recSize);
	}
	
	public Vector2 getPosition(){
		return position;
	}
	
	public void moveToX(float x){
		position.x = x;
	}
	
	public void setColor(Color color){
		this.color = color;
	}
}
