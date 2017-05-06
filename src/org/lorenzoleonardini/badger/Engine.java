package org.lorenzoleonardini.badger;

import org.lorenzoleonardini.badger.input.Input;
import org.lorenzoleonardini.badger.input.Keyboard;
import org.lorenzoleonardini.badger.input.Mouse;
import org.lorenzoleonardini.badger.physics.ObjectManager;

/**
 * @author Lorenzo Leonardini
 */
public abstract class Engine extends Input
{
	private int fps = 0;
	protected long startTime;

	private long time, lastTime = 0;
	private double dt = 1000000000;
	public double HEIGHT;
	public Keyboard keyboard;
	public Mouse mouse;
	protected Camera camera;
	
	protected Loop loop = new Loop()
	{
		@Override
		public void loop()
		{
		}
	};

	public boolean logFPS = true, logObjects = true;

	public Engine()
	{
		keyboard = new Keyboard(this);
		mouse = new Mouse(this);
		camera = new Camera(0, 0);
	}
	
	protected void handleInput()
	{
		keyboard.update();
		mouse.update();
	}
	
	/**
	 * Calculate the delta value and the fps
	 * @return
	 */
	protected boolean fpsDelta()
	{
		boolean b = false;

		if (dt == 1000000000)
			b = true;
		fps++;
		if (System.currentTimeMillis() > startTime + 1000)
		{
			startTime = System.currentTimeMillis();
			if (logFPS)
				Log("FPS: " + fps);
			fps = 0;
			if (logObjects)
				Log("NUMBER OF OBJECTS : " + ObjectManager.getObjects().size());
		}

		time = System.currentTimeMillis();
		dt = (time - lastTime) / 1000.0f;
		lastTime = time;
		return b;
	}

	public double getDelta()
	{
		return dt;
	}

	/**
	 * Set what the engine must do every loop cycle
	 * @param callback
	 */
	public void loop(Loop callback)
	{
		loop = callback;
	}

	public static void Log(String message)
	{
		System.out.println("ENGINE > " + message);
	}
	
	public Camera getCamera()
	{
		return camera;
	}
}
