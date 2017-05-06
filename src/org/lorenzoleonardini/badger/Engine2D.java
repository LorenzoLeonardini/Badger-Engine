package org.lorenzoleonardini.badger;

import org.lorenzoleonardini.badger.assets.Loader;
import org.lorenzoleonardini.badger.physics.PhysicsEngine;
import org.lorenzoleonardini.badger.window.Window;

/**
 * @author Lorenzo Leonardini
 */
public class Engine2D extends Engine implements Runnable
{
	private Window window;

	private Thread thread;
	private boolean running = false;

	private PhysicsEngine physicsEngine;
	public Loader loader;

	public Engine2D()
	{
		loader = new Loader();
		physicsEngine = new PhysicsEngine(this);
	}

	/**
	 * Create the window and initialize all its components
	 */
	public void createWindow(int width, int height, int scale, String title)
	{
		this.HEIGHT = height;
		window = new Window(width, height, scale, title);
		window.addKeyListener(keyboard);
		window.addMouseListener(mouse);
		window.addMouseMotionListener(mouse);
		window.addMouseWheelListener(mouse);
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
		camera.update(getDelta());
		physicsEngine.update();
	}

	public void run()
	{
		while (running)
		{
			if (fpsDelta())
				continue;
			handleInput();
			update();
			loop.loop();
			window.render(camera);
		}
	}
}
