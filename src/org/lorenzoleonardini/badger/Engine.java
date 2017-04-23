package org.lorenzoleonardini.badger;

import org.lorenzoleonardini.badger.physics.ObjectManager;

/**
 * Abstract class of the Engine
 * @author Lorenzo Leonardini
 *
 */
public abstract class Engine
{
	private int fps = 0;
	protected long startTime;

	private long time, lastTime = 0;
	private double dt = 1000000000;
	public double HEIGHT;
	
	protected UpdateCallback loop = new UpdateCallback();
	
	public boolean logFPS = true, logObjects = true;
	
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
			if(logFPS)
				Log("FPS: " + fps);
			fps = 0;
			if(logObjects)
				Log("NUMBER OF OBJECTS : " + ObjectManager.getObjects().size());
		}

		time = System.currentTimeMillis();
		dt = (time - lastTime) / 1000.0f;
		lastTime = time;
		return b;
	}
	
	/**
	 * @return the delta value
	 */
	public double getDelta()
	{
		return dt;
	}
	
	public static void Log(String message)
	{
		System.out.println("ENGINE > " + message);
	}
}
