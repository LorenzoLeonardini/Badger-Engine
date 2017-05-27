package org.lorenzoleonardini.badger.texture;

import java.awt.Color;

public class VerticalLine extends ObjectRender
{
	private Color color = Color.gray;

	public VerticalLine()
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
		if(x < 0 || x >= width)
			return;
		
		for (int Y = 0; Y < pixels.length / width; Y++)
		{
			pixels[x + Y * width] = color.getRGB();
		}
	}
}
