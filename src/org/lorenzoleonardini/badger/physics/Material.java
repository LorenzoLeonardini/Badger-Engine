package org.lorenzoleonardini.badger.physics;

/**
 * The Material class stores the information about the object density to
 * calculate its mass
 * @author Lorenzo Leonardini
 *
 */
public class Material
{
	private boolean transparent = false;
	private double density;

	public Material(int density)
	{
		this.density = density;
	}

	/**
	 * Set the object as a "transparent object". This means that other objects
	 * can't collide with it.
	 * @param transparent
	 */
	public void setTransparent(boolean transparent)
	{
		this.transparent = transparent;
	}

	/**
	 * @return true if the object is transparent
	 */
	public boolean isTransparent()
	{
		return transparent;
	}

	public double getDensity()
	{
		return density;
	}

	public double getMass(int volume)
	{
		return density * volume / 250;
	}
}
