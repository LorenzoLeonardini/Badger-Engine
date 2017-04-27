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
	protected double alpha = 255;

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
	 * Change the fill color of the shape
	 * @param color
	 *            the Color
	 * @param alpha
	 *            the alpha channel
	 */
	public void fill(Color color, int alpha)
	{
		fill = color;
		this.alpha = alpha;
	}

	/**
	 * Change the fill color of the shape
	 * @param r
	 *            the r parameter of the color
	 * @param g
	 *            the g parameter of the color
	 * @param b
	 *            the b parameter of the color
	 * @param alpha
	 *            the alpha channel
	 */
	public void fill(int r, int g, int b, int alpha)
	{
		fill(new Color(r, g, b));
		this.alpha = alpha;
	}

	/**
	 * Change the fill color of the shape
	 * @param rgb
	 *            this value will be used as all of the RGB parameters
	 * @param alpha
	 *            the alpha channel
	 */
	public void fill(int rgb, int alpha)
	{
		fill(rgb, rgb, rgb);
		this.alpha = alpha;
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

		int fg = fill.getRGB();
		double fgR = (fg & 0x00FF0000) >> 16;
		double fgG = (fg & 0x0000FF00) >> 8;
		double fgB = (fg & 0xFF);

		alpha /= 255;
		fgR /= 255;
		fgG /= 255;
		fgB /= 255;
		
		for (int X = 0; X < w; X++)
		{
			for (int Y = 0; Y < h; Y++)
			{
				if (x + X < 0 || x + X >= width || y + Y < 0 || y + Y >= pixels.length / width)
					continue;
				if (this.pixels[X + Y * w] == 0xff00ff)
					continue;
				if (this.pixels[X + Y * w] == 0)
				{
					int bg = pixels[x + X + (y + Y) * width];
					double bgR = (bg & 0xFF0000) >> 16;
					double bgG = (bg & 0x00FF00) >> 8;
					double bgB = (bg & 0xFF);

					bgR /= 255;
					bgG /= 255;
					bgB /= 255;

					double a, r, g, b;

					a = 1 - (1 - alpha) * (1 - 1); // 0.75
					r = fgR * alpha / a + bgR * 1 * (1 - alpha) / a; // 0.67
					g = fgG * alpha / a + bgG * 1 * (1 - alpha) / a; // 0.33
					b = fgB * alpha / a + bgB * 1 * (1 - alpha) / a; // 0.00

					r *= 255;
					g *= 255;
					b *= 255;
					
					pixels[x + X + (y + Y) * width] = new Color((int) r, (int) g, (int) b).getRGB();
				}
				if (this.pixels[X + Y * w] == 0xffffff)
					pixels[x + X + (y + Y) * width] = stroke.getRGB();
			}
		}
		
		alpha *= 255;
	}
}