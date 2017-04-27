package org.lorenzoleonardini.badger.physics;

import java.util.Random;

/**
 * The Vector3D class represent a 3D vector
 * 
 * @author Lorenzo Leonardini
 *
 */
public class Vector3D
{
	public double x = 0;
	public double y = 0;
	public double z = 0;

	public Vector3D(double x, double y, double z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Create a random vector. The magnitude will be used as maximum value of
	 * its component
	 * @param magnitude
	 * @return the created Vector
	 */
	public static Vector3D randomVector(int magnitude)
	{
		Random r = new Random();
		double length = r.nextDouble() * magnitude;
		double alpha = r.nextDouble() * 360;
		double beta = r.nextDouble() * 360;
		double x = Math.cos(Math.toRadians(alpha)) * Math.cos(Math.toRadians(beta));
		double y = Math.sin(Math.toRadians(alpha)) * Math.cos(Math.toRadians(beta));
		double z = Math.sin(Math.toRadians(beta));
		x *= length;
		y *= length;
		z *= length;
		return new Vector3D(x, y, z);
	}

	/**
	 * Create a random vector with a default magnitude of 1
	 * @return the created Vector
	 */
	public static Vector3D randomVector()
	{
		return randomVector(1);
	}

	/**
	 * Add a vector to this one
	 * @param vec
	 */
	public void addVector(Vector3D vec)
	{
		x += vec.x;
		y += vec.y;
		z += vec.z;
	}

	public String toString()
	{
		return "[x : " + x + " ; y :" + y + " ; z : " + z + "]";
	}

	/**
	 * @return a new Vector with the exact components of this one
	 */
	public Vector3D copy()
	{
		return new Vector3D(x, y, z);
	}

	/**
	 * Invert the vector components
	 */
	public void invert()
	{
		x *= -1;
		y *= -1;
		z *= -1;
	}

	/**
	 * Multiply the length of the vector with a number
	 * @param d
	 */
	public void multiply(double d)
	{
		x *= d;
		y *= d;
		z *= d;
	}

	/**
	 * Normalize the vector. Its length will be 1
	 */
	public void normalize()
	{
		double length = Math.sqrt(x * x + y * y + z * z);
		multiply(1 / length);
	}
}
