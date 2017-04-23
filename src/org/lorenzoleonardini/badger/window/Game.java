package org.lorenzoleonardini.badger.window;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Random;

import javax.swing.JFrame;

import org.lorenzoleonardini.badger.assets.Loader;
import org.lorenzoleonardini.badger.input.Keyboard;
import org.lorenzoleonardini.badger.physics.Material;
import org.lorenzoleonardini.badger.physics.Object;
import org.lorenzoleonardini.badger.physics.ObjectManager;
import org.lorenzoleonardini.badger.physics.PhysicsEngine;
import org.lorenzoleonardini.badger.physics.Vector2D;
import org.lorenzoleonardini.badger.renderer.Screen;
import org.lorenzoleonardini.badger.texture.Circle;
import org.lorenzoleonardini.badger.texture.Shape;

/**
 * The Game class contains the main game loop and manage all the components of
 * it
 * 
 * @author Lorenzo Leonardini
 *
 */
public class Game extends Canvas implements Runnable
{
	private static final long serialVersionUID = 1L;

	public final int WIDTH, HEIGHT;

	private Thread thread;
	private JFrame frame;
	private boolean running = false;

	private BufferedImage image;
	private int[] pixels;

	private PhysicsEngine physicsEngine;
	private Screen screen;
	public Loader loader;
	public Keyboard keyboard;

	private int fps = 0;
	private long startTime;

	private long time, lastTime = 0;
	private double dt = 1000000000;

	/**
	 * Initialize the game
	 * @param width
	 *            the window width
	 * @param height
	 *            the window height
	 * @param scale
	 *            the scale
	 * @param title
	 *            the window title
	 */
	public Game(int width, int height, int scale, String title)
	{
		WIDTH = width;
		HEIGHT = height;
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

		loader = new Loader();
		screen = new Screen(width, height, pixels, this);
		physicsEngine = new PhysicsEngine(this);

		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);

		keyboard = new Keyboard();

		addKeyListener(keyboard);
		setFocusable(true);

		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle(title);
		frame.add(this);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
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

	Material m = new Material(1);
	Random random = new Random();

	/**
	 * Calculate the delta value and the fps THIS METHOD IS MOMENTARILY USED TO
	 * CREATE OBJECT TO DISPLAY ON THE SCREEN
	 * @return
	 */
	private boolean fpsDelta()
	{
		boolean b = false;

		if (dt == 1000000000)
			b = true;
		fps++;
		if (System.currentTimeMillis() > startTime + 1000)
		{
			startTime = System.currentTimeMillis();
			System.out.println("FPS: " + fps);
			fps = 0;
			System.out.println("NUMBER OF OBJECTS : " + ObjectManager.getObjects().size());
		}

		if ((System.currentTimeMillis() - startTime) % 10 == 0)
		{
			Object obj = new Object(WIDTH / 2 + random.nextInt(10) - 5, 100 + random.nextInt(10), new Circle(random.nextInt(12) + 12), m);
			((Shape) obj.objectRender).fill(255);
			((Shape) obj.objectRender).strokeWeight(1);
			((Shape) obj.objectRender).stroke(38);
			obj.applyForce(Vector2D.randomVector(200));
		}

		time = System.currentTimeMillis();
		dt = (time - lastTime) / 1000.0f;
		lastTime = time;
		return b;
	}

	/**
	 * Updates the physics engine and manage all the inputs
	 */
	private void update()
	{
		// if(ObjectManager.getObjects().get(0).isOnGround &&
		// keyboard.isTyped(KeyEvent.VK_SPACE))
		// {
		// ObjectManager.getObjects().get(0).isOnGround = false;
		// ObjectManager.getObjects().get(0).velocity().y+=-500 * getDelta();
		// }
		//
		// if(keyboard.isPressed(KeyEvent.VK_D))
		// {
		// ObjectManager.getObjects().get(0).position.x += 500 * getDelta();
		// if(ObjectManager.getObjects().get(0).flip)
		// ObjectManager.getObjects().get(0).flip = false;
		// }
		//
		// if(keyboard.isPressed(KeyEvent.VK_A))
		// {
		// ObjectManager.getObjects().get(0).position.x -= 500 * getDelta();
		// if(!ObjectManager.getObjects().get(0).flip)
		// ObjectManager.getObjects().get(0).flip = true;
		// }
		//
		// if(keyboard.isTyped(KeyEvent.VK_1))
		// {
		// ((Shape)ObjectManager.getObjects().get(0).objectRender).strokeWeight(((Shape)ObjectManager.getObjects().get(0).objectRender).getStrokeWeight()
		// + 1);
		// }
		//
		// if(keyboard.isTyped(KeyEvent.VK_2))
		// {
		// ((Circle)ObjectManager.getObjects().get(0).objectRender).changeRadius(((Circle)ObjectManager.getObjects().get(0).objectRender).getRadius()
		// + 1);
		// }
		//
		physicsEngine.update();
		keyboard.update();
	}

	/**
	 * Render to the screen
	 */
	private void render()
	{
		BufferStrategy bs = getBufferStrategy();
		if (bs == null)
		{
			createBufferStrategy(3);
			return;
		}

		screen.render();

		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();
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
			render();
		}
	}

	/**
	 * @return the delta value
	 */
	public double getDelta()
	{
		return dt;
	}
}
