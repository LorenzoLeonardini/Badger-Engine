package org.lorenzoleonardini.badger.texture;

/**
 * This class represents the shape circle
 * 
 * @author Lorenzo Leonardini
 *
 */
public class Circle extends Shape
{
	private int r;

	public Circle(int r)
	{
		this.r = r;
		this.w = r * 2 - 1;
		this.h = r * 2 - 1;

		pixels = new int[w * h];

		reload();
	}

	/**
	 * Change the circle radius
	 * @param r
	 */
	public void changeRadius(int r)
	{
		this.r = r;
		this.w = r * 2 - 1;
		this.h = r * 2 - 1;

		pixels = new int[w * h];

		reload();
	}

	/**
	 * @return the radius
	 */
	public int getRadius()
	{
		return r;
	}

	@Override
	public void reload()
	{
		for (int x = 0; x < r * 2 - 1; x++)
		{
			for (int y = 0; y < r * 2 - 1; y++)
			{
				double dist = Math.sqrt((x - r + 1) * (x - r + 1) + (y - r + 1) * (y - r + 1));
				if (dist > r)
					pixels[x + y * (r * 2 - 1)] = 0xff00ff;
				if ((int) dist >= r - strokeSize && dist <= r)
					pixels[x + y * (r * 2 - 1)] = 0xffffff;
			}
		}
		calcVolume();
	}

}
