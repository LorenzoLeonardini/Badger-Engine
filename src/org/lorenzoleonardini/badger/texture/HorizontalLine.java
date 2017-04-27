package org.lorenzoleonardini.badger.texture;

import java.awt.Color;

public class HorizontalLine extends ObjectRender
{
	//TODO: Horizontal Line
	
	private int y;
	private Color color = Color.gray;

	public HorizontalLine(int y)
	{
		this.y = y;
	}

	@Override
	public void render(int[] pixels, int width, int x, int y, boolean flipped)
	{
		for (int X = 0; X < width; X++)
		{
			pixels[X + this.y * width] = color.getRGB();
		}
	}
}
