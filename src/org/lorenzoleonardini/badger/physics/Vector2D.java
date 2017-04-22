package org.lorenzoleonardini.badger.physics;

import java.util.Random;

/**
 * The Vector2D class represent a 2D vector
 * 
 * @author Lorenzo Leonardini
 *
 */
public class Vector2D
{
	public double x = 0;
	public double y = 0;
	
	public Vector2D(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public static Vector2D randomVector()
	{
		Random r = new Random();
		return new Vector2D(r.nextDouble(), r.nextDouble());
	}
	
	public void addVector(Vector2D vec)
	{
		x += vec.x;
		y += vec.y;
	}
	
	public String toString()
	{
		return "[x : " + x + " ; y :" + y + "]";
	}
	
	public Vector2D copy()
	{
		return new Vector2D(x, y);
	}
	
	public void invert()
	{
		x *= -1;
		y *= -1;
	}
	
	public void multiply(double d)
	{
		x *= d;
		y *= d;
	}
}
