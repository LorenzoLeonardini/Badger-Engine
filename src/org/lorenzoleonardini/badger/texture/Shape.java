package org.lorenzoleonardini.badger.texture;

import java.awt.Color;

/**
 * This class represent an abstract shape that can be rendered
 * 
 * @author Lorenzo Leonardini
 *
 */
public abstract class Shape extends ObjectRender
{
	protected Color fill = Color.BLACK, stroke = Color.white;
	protected int strokeSize = 0;

	public abstract void reload();

	/**
	 * Change the stroke weight of the shape
	 * @param strokeSize
	 */
	public void strokeWeight(int strokeSize)
	{
		this.strokeSize = strokeSize;
		reload();
	}

	/**
	 * @return the stroke weight
	 */
	public int getStrokeWeight()
	{
		return strokeSize;
	}

	/**
	 * Change the fill color of the shape
	 * @param color
	 *            the Color
	 */
	public void fill(Color color)
	{
		fill = color;
	}

	/**
	 * Change the fill color of the shape
	 * @param r
	 *            the r parameter of the color
	 * @param g
	 *            the g parameter of the color
	 * @param b
	 *            the b parameter of the color
	 */
	public void fill(int r, int g, int b)
	{
		fill(new Color(r, g, b));
	}

	/**
	 * Change the fill color of the shape
	 * @param rgb
	 *            this value will be used as all of the RGB parameters
	 */
	public void fill(int rgb)
	{
		fill(rgb, rgb, rgb);
	}

	/**
	 * Change the stroke color of the shape
	 * @param color
	 *            the Color
	 */
	public void stroke(Color color)
	{
		stroke = color;
	}

	/**
	 * Change the stroke color of the shape
	 * @param r
	 *            the r parameter of the color
	 * @param g
	 *            the g parameter of the color
	 * @param b
	 *            the b parameter of the color
	 */
	public void stroke(int r, int g, int b)
	{
		stroke(new Color(r, g, b));
	}

	/**
	 * Change the stroke color of the shape
	 * @param rgb
	 *            this value will be used as all of the RGB parameters
	 */
	public void stroke(int rgb)
	{
		stroke(rgb, rgb, rgb);
	}

	@Override
	public void render(int pixels[], int width, int x, int y, boolean flipped)
	{
		x -= w / 2;
		y -= h / 2;
		for (int X = 0; X < w; X++)
		{
			for (int Y = 0; Y < h; Y++)
			{
				if (x + X < 0 || x + X >= width || y + Y < 0 || y + Y >= pixels.length / width)
					continue;
				if (this.pixels[X + Y * w] == 0xff00ff)
					continue;
				if (this.pixels[X + Y * w] == 0)
					pixels[x + X + (y + Y) * width] = fill.getRGB();
				if (this.pixels[X + Y * w] == 0xffffff)
					pixels[x + X + (y + Y) * width] = stroke.getRGB();
			}
		}
	}
}