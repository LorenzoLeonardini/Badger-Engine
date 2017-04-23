package org.lorenzoleonardini.badger.texture;

import org.lorenzoleonardini.badger.assets.Texture;

/**
 * This class represent the texture of an object that can actually be rendered
 * 
 * @author Lorenzo Leonardini
 *
 */
public class ObjectTexture extends ObjectRender
{
	private Texture texture;
	
	private int scale = 1;

	public ObjectTexture(Texture texture)
	{
		this.texture = texture;
		this.w = texture.getWidth();
		this.h = texture.getHeight();
		
		this.pixels = new int[texture.pixels.length];
		for(int i = 0; i < pixels.length; i++)
		{
			this.pixels[i] = texture.pixels[i];
		}
	}
	
	/**
	 * Scale the texture
	 * @param scale
	 */
	public void scale(int scale)
	{
		this.scale = scale;
		this.w = texture.getWidth() * scale;
		this.h = texture.getHeight() * scale;
		reload();
	}
	
	/**
	 * Reload the texture with the new scale
	 */
	private void reload()
	{
		this.pixels = new int[texture.pixels.length * scale * scale];
		for(int x = 0; x < w; x++)
		{
			for(int y = 0; y < h; y++)
			{
				pixels[x + y * w] = texture.pixels[(int)(x / scale) + (int)(y / scale) * texture.getWidth()];
			}
		}
	}

	@Override
	public void render(int[] pixels, int width, int x, int y, boolean flipped)
	{
		if (!flipped)
			for (int X = 0; X < w; X++)
				for (int Y = 0; Y < h; Y++)
				{
					if (x + X >= width || x + X < 0 || y + Y >= pixels.length / width || y + Y < 0 || this.pixels[X + Y * w] == 0xff00ff)
						continue;
					pixels[x + X + (y + Y) * width] = this.pixels[X + Y * w];
				}
		else
			for (int X = 1; X <= w; X++)
				for (int Y = 0; Y < h; Y++)
				{
					if (x + X >= width || x + X < 0 || y + Y >= pixels.length / width || y + Y < 0 || this.pixels[w - X + Y * w] == 0xff00ff)
						continue;
					pixels[x + X + (y + Y) * width] = this.pixels[w - X + Y * w];
				}
	}
}
