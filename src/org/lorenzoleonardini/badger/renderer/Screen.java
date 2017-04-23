package org.lorenzoleonardini.badger.renderer;

import org.lorenzoleonardini.badger.physics.ObjectManager;
import org.lorenzoleonardini.badger.physics.PhysicsObject;
import org.lorenzoleonardini.badger.window.Window;

/**
 * The Screen class does all the actual rendering of the engine
 * 
 * @author Lorenzo Leonardini
 *
 */
public class Screen
{
	private int width;
	private int[] pixels;

	public Screen(int width, int height, int[] pixels, Window game)
	{
		this.width = width;
		this.pixels = pixels;
	}

	int div = 2000;

	/**
	 * Clear the screen
	 */
	private void clear()
	{
		for (int i = 0; i < pixels.length; i++)
			pixels[i] = 0;
	}

	/**
	 * Clear the screen and render all the objects
	 */
	public void render()
	{
		clear();

		for (PhysicsObject o : ObjectManager.getObjects())
		{
			o.render(pixels, width);
		}
	}
}
