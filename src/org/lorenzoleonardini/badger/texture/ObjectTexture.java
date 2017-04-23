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

	public ObjectTexture(Texture texture)
	{
		this.texture = texture;
		this.pixels = texture.pixels;
		this.w = texture.getWidth();
		this.h = texture.getHeight();
	}

	@Override
	public void render(int[] pixels, int width, int x, int y, boolean flipped)
	{
		if (!flipped)
			for (int X = 0; X < w; X++)
				for (int Y = 0; Y < h; Y++)
				{
					if (x + X >= width || x + X < 0 || y + Y >= pixels.length / width || y + Y < 0 || pixels[X + Y * w] == 0xff00ff)
						continue;
					pixels[x + X + (y + Y) * width] = pixels[X + Y * w];
				}
		else
			for (int X = 1; X <= w; X++)
				for (int Y = 0; Y < h; Y++)
				{
					if (x + X >= width || x + X < 0 || y + Y >= pixels.length / width || y + Y < 0 || pixels[w - X + Y * w] == 0xff00ff)
						continue;
					pixels[x + X + (y + Y) * width] = pixels[w - X + Y * w];
				}
	}
}
