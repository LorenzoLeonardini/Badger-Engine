package org.lorenzoleonardini.badger.renderer;

import java.util.ArrayList;
import java.util.List;

import org.lorenzoleonardini.badger.Camera;
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
			pixels[i] = 0x383838;
	}

	/**
	 * Clear the screen and render all the objects
	 */
	public void render(Camera camera)
	{
		clear();

		List<PhysicsObject> list = new ArrayList<PhysicsObject>(ObjectManager.getObjects());

		for (PhysicsObject o : list)
		{
			o.render(pixels, width, camera);
		}
	}
}
