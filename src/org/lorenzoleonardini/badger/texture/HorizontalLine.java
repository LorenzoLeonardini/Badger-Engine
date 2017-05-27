package org.lorenzoleonardini.badger.texture;

import java.awt.Color;

public class HorizontalLine extends ObjectRender
{
	private Color color = Color.gray;

	public HorizontalLine()
	{
	}
	
	public void color(Color color)
	{
		this.color = color;
	}

	public void color(int r, int g, int b)
	{
		color(new Color(r, g, b));
	}

	public void color(int rgb)
	{
		color(rgb, rgb, rgb);
	}

	@Override
	public void render(int[] pixels, int width, int x, int y, boolean flipped)
	{
		if(y < 0 || y >= pixels.length / width)
			return;
		
		for (int X = 0; X < width; X++)
		{
			pixels[X + y * width] = color.getRGB();
		}
	}
}
