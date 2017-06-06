package org.lorenzoleonardini.badger;

import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

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
		
		try
		{
			Image img128 = ImageIO.read(Window.class.getResource("logo128.png"));
			Image img64 = ImageIO.read(Window.class.getResource("logo64.png"));
			Image img32 = ImageIO.read(Window.class.getResource("logo32.png"));
			Image img16 = ImageIO.read(Window.class.getResource("logo16.png"));
			List<Image> imgs = new ArrayList<Image>();
			imgs.add(img128);
			imgs.add(img64);
			imgs.add(img32);
			imgs.add(img16);
			setIconImages(imgs);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		window.addKeyListener(keyboard);
		window.addMouseListener(mouse);
		window.addMouseMotionListener(mouse);
		window.addMouseWheelListener(mouse);		
	}
	
	public void setIconImages(List<Image> imgs)
	{
		window.setIconImages(imgs);
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
