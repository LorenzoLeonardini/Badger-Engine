package org.lorenzoleonardini.badger.texture;

/**
 * This class represent the part of an Object that can be rendered.
 * 
 * @author Lorenzo Leonardini
 *
 */
public abstract class ObjectRender
{
	public int w, h;

	public int volume;

	public int pixels[];

	/**
	 * Render the Object to the screen
	 * @param pixels
	 *            the array of screen pixels
	 * @param width
	 *            the width of the screen
	 * @param x
	 *            the x position of the Object
	 * @param y
	 *            the y position of the Object
	 * @param flipped
	 *            if this value is true the object will be rendered flipped
	 */
	public abstract void render(int pixels[], int width, int x, int y, boolean flipped);

	/**
	 * Calculate the volume of the object IMPORTANT! Call this method only after
	 * editing the pixels
	 */
	protected void calcVolume()
	{
		volume = 0;
		for (int i = 0; i < pixels.length; i++)
			if (pixels[i] != 0xff00ff)
				volume++;
	}

	public int getVolume()
	{
		return volume;
	}
}
