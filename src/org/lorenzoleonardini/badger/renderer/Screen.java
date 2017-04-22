package org.lorenzoleonardini.badger.renderer;

import java.awt.Color;
import java.io.File;
import java.util.Random;

import org.lorenzoleonardini.badger.physics.Object;
import org.lorenzoleonardini.badger.window.Game;

/**
 * The Screen class does all the actual rendering of the engine
 * 
 * @author Lorenzo Leonardini
 *
 */
public class Screen
{
	private int width, height;
	private int[] pixels;
	private Game game;

	private Random random;

	private Object mario;

	private Color bg = Color.black;
	private Color target = Color.black;

	private double R, G, B, r = 0, g = 0, b = 0;

	public Screen(int width, int height, int[] pixels, Game game)
	{
		this.width = width;
		this.height = height;
		this.pixels = pixels;
		this.game = game;

		random = new Random();

		File f = new File("C:\\Users\\Lorenzo\\Desktop\\Mario_8Bit.png");
		mario = new Object(width / 2 - 8, 0, game.loader.loadTexture(f));
		// mario.flip();
	}

	int div = 2000;

	/**
	 * Clear the screen
	 */
	private void clear()
	{
		if(Math.abs(target.getRed() - r) < 10)
			R = 0;
		if(Math.abs(target.getGreen() - g) < 10)
			G = 0;
		if(Math.abs(target.getBlue() - b) < 10)
			B = 0;
		if (R == 0 && G == 0 && B == 0)
		{
			target = new Color(random.nextFloat(), random.nextFloat(), random.nextFloat());

			R = target.getRed() - bg.getRed();
			R /= div;
			G = target.getGreen() - bg.getGreen();
			G /= div;
			B = target.getBlue() - bg.getBlue();
			B /= div;
		}
			
		r += R;
		if(r < 0) r = 0;
		if(r > 255) r = 255;
		g += G;
		if(g < 0) g = 0;
		if(g > 255) g = 255;
		b += B;
		if(b < 0) b = 0;
		if(b > 255) b = 255;
		
		bg = new Color((int) r, (int) g, (int) b);

		
		for (int i = 0; i < pixels.length; i++)
			pixels[i] = bg.getRGB();
	}
	
	public void render()
	{
		clear();

		mario.render(pixels, width);
	}
}
