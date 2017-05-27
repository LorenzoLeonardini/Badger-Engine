package org.lorenzoleonardini.badger.physics;

/**
 * @author Lorenzo Leonardini
 */
public class Material
{
	private boolean transparent = false;

	private float bounciness = 1;
	
	public Material()
	{
	}
	
	public void setBounciness(float bounciness)
	{
		if(bounciness > 1)
			bounciness = 1;
		else if(bounciness < 0)
			bounciness = 0;
		this.bounciness = bounciness;
	}
	
	public float getBounciness()
	{
		return bounciness;
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

	public boolean isTransparent()
	{
		return transparent;
	}
}
