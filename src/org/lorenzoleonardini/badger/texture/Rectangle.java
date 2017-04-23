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
	
	/**
	 * Change the width
	 * @param w
	 */
	public void changeWidth(int w)
	{
		this.w = w;

		pixels = new int[w * h];

		reload();
	}

	/**
	 * @return the width
	 */
	public int getRadius()
	{
		return w;
	}
	
	/**
	 * Change the height
	 * @param h
	 */
	public void changeHeight(int h)
	{
		this.h = h;

		pixels = new int[w * h];

		reload();
	}

	/**
	 * @return the height
	 */
	public int getHeight()
	{
		return h;
	}
	
	/**
	 * Change the size
	 * @param w
	 * @param h
	 */
	public void changeSize(int w, int h)
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
		
		for(int x = 0; x < w; x++)
			for(int y = 0; y < strokeSize; y++)
				pixels[x + y * w] = 0xffffff;
		
		for(int y = strokeSize; y < h; y++)
			for(int x = 0; x < strokeSize; x++)
				pixels[x + y * w] = 0xffffff;
		
		for(int x = 0; x < w; x++)
			for(int y = h - 1; y >= h - strokeSize; y--)
				pixels[x + y * w] = 0xffffff;
		
		for(int y = strokeSize; y < h; y++)
			for(int x = w - 1; x >= w - strokeSize; x--)
				pixels[x + y * w] = 0xffffff;

		calcVolume();
	}
	
	@Override
	protected void calcVolume()
	{
		volume = pixels.length;
	}

}
