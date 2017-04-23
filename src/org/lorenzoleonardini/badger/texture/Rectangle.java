package org.lorenzoleonardini.badger.texture;

/**
 * This class represent the shape of a rectangle
 * 
 * @author Lorenzo Leonardini
 *
 */
public class Rectangle extends Shape
{
	public Rectangle(int w, int h)
	{
		this.w = w;
		this.h = h;

		pixels = new int[w * h];

		reload();
	}

	@Override
	public void reload()
	{
		for (int i = 0; i < pixels.length; i++)
			pixels[i] = 0;

		calcVolume();
	}

}
