package org.lorenzoleonardini.badger;

import org.lorenzoleonardini.badger.assets.Loader;
import org.lorenzoleonardini.badger.input.Keyboard;
import org.lorenzoleonardini.badger.physics.PhysicsEngine;
import org.lorenzoleonardini.badger.window.Window;

/**
 * This is the Engine2D class. It contains the loop and everything you use.
 * 
 * @author Lorenzo Leonardini
 *
 */
public class Engine2D extends Engine implements Runnable
{
	private Window window;

	private Thread thread;
	private boolean running = false;

	private PhysicsEngine physicsEngine;
	public Loader loader;
	public Keyboard keyboard;

	public Engine2D()
	{
		loader = new Loader();
		physicsEngine = new PhysicsEngine(this);
		keyboard = new Keyboard();
	}

	/**
	 * Create the window and initialize all its components
	 * @param width
	 *            the window width
	 * @param height
	 *            the window height
	 * @param scale
	 *            the scale
	 * @param title
	 *            the window title
	 */
	public void createWindow(int width, int height, int scale, String title)
	{
		this.HEIGHT = height;
		window = new Window(width, height, scale, title);
		window.addKeyListener(keyboard);
	}

	/**
	 * Start the game loop
	 */
	public void start()
	{
		running = true;
		startTime = System.currentTimeMillis();
		thread = new Thread(this, "Display");
		thread.start();
	}

	/**
	 * Stop the game loop
	 */
	public void stop()
	{
		running = false;
		try
		{
			thread.join();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Updates the physics engine and manage all the inputs
	 */
	private void update()
	{
		physicsEngine.update();
		keyboard.update();
	}

	/**
	 * Set what the engine must do every loop cycle
	 * @param callback
	 */
	public void update(UpdateCallback callback)
	{
		loop = callback;
	}

	/**
	 * The Loop
	 */
	public void run()
	{
		while (running)
		{
			if (fpsDelta())
				continue;
			update();
			loop.update();
			window.render();
		}
	}
}
