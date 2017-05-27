package org.lorenzoleonardini.badger.physics;

import java.util.Random;

/**
 * @author Lorenzo Leonardini
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

	/**
	 * Create a random vector. The magnitude will be used as maximum value of
	 * its length
	 * @param magnitude
	 * @return the created Vector
	 */
	public static Vector2D randomVector(int magnitude)
	{
		Random r = new Random();
		double length = r.nextDouble() * magnitude;
		double angle = r.nextDouble() * 360;
		double x = Math.cos(Math.toRadians(angle)) * length;
		double y = Math.sin(Math.toRadians(angle)) * length;
		return new Vector2D(x, y);
	}

	/**
	 * Create a random vector with a default magnitude of 1
	 * @return the created Vector
	 */
	public static Vector2D randomVector()
	{
		return randomVector(1);
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
	
	public void multiply(double x, double y)
	{
		this.x *= x;
		this.y *= y;
	}

	public void normalize()
	{
		double length = Math.sqrt(x * x + y * y);
		multiply(1 / length);
	}
}
