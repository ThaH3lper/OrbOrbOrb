package com.StekStudio.Orb.Polygon;

import com.badlogic.gdx.math.Vector2;

public class Line {
	private Vector2 start, end;
	
	public Line(Vector2 start, Vector2 end){
		this.start = start;
		this.end = end;
	}
	
	public Vector2 getStart(){
		return start;
	}
	
	public Vector2 getEnd(){
		return end;
	}
}
