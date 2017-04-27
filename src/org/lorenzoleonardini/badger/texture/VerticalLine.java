package org.lorenzoleonardini.badger.texture;

import java.awt.Color;

public class VerticalLine extends ObjectRender
{
	//TODO: Vertical Line
	
	private int x;
	private Color color = Color.gray;

	public VerticalLine(int x)
	{
		this.x = x;
	}

	@Override
	public void render(int[] pixels, int width, int x, int y, boolean flipped)
	{
		for (int Y = 0; Y < pixels.length / width; Y++)
		{
			pixels[this.x + Y * width] = color.getRGB();
		}
	}
}
