package org.lorenzoleonardini.badger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONObject;
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
	
	private final String VERSION = "v0.2.4Betaa";

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
		try
		{
			checkVersion();
		}
		catch (IOException e)
		{
			System.out.println("Can't check for a newest version\n\n");
		}
	}

	private void checkVersion() throws IOException
	{
		URL url = new URL("https://api.github.com/repos/LorenzoLeonardini/Badger-Engine/releases/latest");
		URLConnection conn = url.openConnection();
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

		JSONObject json = new JSONObject(br.readLine());
		if(!VERSION.equals(json.getString("tag_name")))
		{
			System.out.println("NEW VERSION AVAILABLE! - \"" + json.getString("name") + "\"\n\t\t\t\tpublished in " + json.getString("published_at").split("T")[0] + ", by " + json.getJSONObject("author").getString("login"));
			System.out.println(json.getString("body").replace("### Bug fixes:\r\n_none_", ""));
		}

		br.close();
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
