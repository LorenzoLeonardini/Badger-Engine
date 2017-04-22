package org.lorenzoleonardini.badger.window;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import org.lorenzoleonardini.badger.assets.Loader;
import org.lorenzoleonardini.badger.input.Keyboard;
import org.lorenzoleonardini.badger.physics.ObjectManager;
import org.lorenzoleonardini.badger.physics.PhysicsEngine;
import org.lorenzoleonardini.badger.physics.Vector2D;
import org.lorenzoleonardini.badger.renderer.Screen;

/**
 * The Game class contains the main game loop and manage all the components of it 
 * 
 * @author Lorenzo Leonardini
 *
 */
public class Game extends Canvas implements Runnable
{
	private static final long serialVersionUID = 1L;

	private static int WIDTH, HEIGHT;

	private Thread thread;
	private JFrame frame;
	private boolean running = false;

	private BufferedImage image;
	private int[] pixels;

	private PhysicsEngine pe;
	private Screen screen;
	public Loader loader;
	public Keyboard keyboard;

	private int fps = 0;
	private long startTime;

	private long time, lastTime = 0;
	private double dt = 1000000000;

	public Game(int width, int height, int scale, String title)
	{
		WIDTH = width;
		HEIGHT = height;
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

		loader = new Loader();
		screen = new Screen(width, height, pixels, this);
		pe = new PhysicsEngine(this);

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

	public void start()
	{
		running = true;
		startTime = System.currentTimeMillis();
		thread = new Thread(this, "Display");
		thread.start();
	}

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

	private boolean fpsDelta()
	{
		boolean b = false;
		
		if(dt == 1000000000)
			b = true;
		fps++;
		if (System.currentTimeMillis() > startTime + 1000)
		{
			startTime = System.currentTimeMillis();
			System.out.println("FPS: " + fps);
			fps = 0;
		}

		time = System.currentTimeMillis();
		dt = (time - lastTime) / 1000.0f;
		lastTime = time;
		return b;
	}

	private void update()
	{
		if(ObjectManager.getObjects().get(0).isOnGround && keyboard.isPressed(KeyEvent.VK_SPACE))
		{
			ObjectManager.getObjects().get(0).isOnGround = false;
			ObjectManager.getObjects().get(0).velocity().y+=-500 * getDelta();
		}
		
		if(keyboard.isPressed(KeyEvent.VK_D))
		{
			ObjectManager.getObjects().get(0).position.x += 500 * getDelta();
			if(ObjectManager.getObjects().get(0).flip)
				ObjectManager.getObjects().get(0).flip = false;
		}
		
		if(keyboard.isPressed(KeyEvent.VK_A))
		{
			ObjectManager.getObjects().get(0).position.x -= 500 * getDelta();
			if(!ObjectManager.getObjects().get(0).flip)
				ObjectManager.getObjects().get(0).flip = true;
		}
		
		pe.update();
	}

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

	public void run()
	{
		while (running)
		{
			if(fpsDelta())
				continue;
			update();
			render();
		}
	}

	public double getDelta()
	{
		return dt;
	}
}
