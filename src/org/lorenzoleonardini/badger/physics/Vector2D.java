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

	/**
	 * Create a random vector. The magnitude will be used as maximum value of
	 * its component
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

	/**
	 * Add a vector to this one
	 * @param vec
	 */
	public void addVector(Vector2D vec)
	{
		x += vec.x;
		y += vec.y;
	}

	public String toString()
	{
		return "[x : " + x + " ; y :" + y + "]";
	}

	/**
	 * @return a new Vector with the exact components of this one
	 */
	public Vector2D copy()
	{
		return new Vector2D(x, y);
	}

	/**
	 * Invert the vector components
	 */
	public void invert()
	{
		x *= -1;
		y *= -1;
	}

	/**
	 * Multiply the length of the vector with a number
	 * @param d
	 */
	public void multiply(double d)
	{
		x *= d;
		y *= d;
	}

	/**
	 * Normalize the vector. Its length will be 1
	 */
	public void normalize()
	{
		double length = Math.sqrt(x * x + y * y);
		multiply(1 / length);
	}
}
