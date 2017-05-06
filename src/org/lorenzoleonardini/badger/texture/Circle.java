package org.lorenzoleonardini.badger.texture;

/**
 * @author Lorenzo Leonardini
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

	public void changeRadius(int r)
	{
		this.r = r;
		this.w = r * 2 - 1;
		this.h = r * 2 - 1;

		pixels = new int[w * h];

		reload();
	}

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
				if (strokeSize > 0)
					if ((int) dist >= r - strokeSize && dist <= r)
						pixels[x + y * (r * 2 - 1)] = 0xffffff;
			}
		}
		calcVolume();
	}

}
