package org.lorenzoleonardini.badger.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import org.lorenzoleonardini.badger.Engine;
import org.lorenzoleonardini.badger.physics.ObjectManager;
import org.lorenzoleonardini.badger.physics.PhysicsObject;

/**
 * The Keyboard class manages all the input from the user's keyboard
 * 
 * @author Lorenzo Leonardini
 *
 */
public class Keyboard implements KeyListener
{
	private List<Integer> pressedKeys = new ArrayList<Integer>();
	private List<Integer> toRemove = new ArrayList<Integer>();
	
	private Engine engine;
	
	public Keyboard(Engine engine)
	{
		this.engine = engine;
	}

	/**
	 * Updates the keyboard lists
	 */
	public void update()
	{
		pressedKeys.removeAll(toRemove);
		toRemove.clear();
		
		List<PhysicsObject> list = new ArrayList<PhysicsObject>(ObjectManager.getObjects());
		for (int i = 0; i < pressedKeys.size(); i++)
		{
			int e = pressedKeys.get(i);
			for (PhysicsObject o : list)
				for (KeyboardEvent evt : o.keyEvents)
					evt.onKeyDown(e);
			for (KeyboardEvent evt : engine.keyEvents)
				evt.onKeyDown(e);
		}
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (!pressedKeys.contains(e.getKeyCode()))
		{
			pressedKeys.add(e.getKeyCode());
			List<PhysicsObject> list = new ArrayList<PhysicsObject>(ObjectManager.getObjects());
			for (PhysicsObject o : list)
				for (KeyboardEvent evt : o.keyEvents)
					evt.onKeyPressed(e.getKeyCode());
			for (KeyboardEvent evt : engine.keyEvents)
				evt.onKeyPressed(e.getKeyCode());
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		toRemove.add(e.getKeyCode());
		List<PhysicsObject> list = new ArrayList<PhysicsObject>(ObjectManager.getObjects());
		for (PhysicsObject o : list)
			for (KeyboardEvent evt : o.keyEvents)
				evt.onKeyReleased(e.getKeyCode());
		for (KeyboardEvent evt : engine.keyEvents)
			evt.onKeyReleased(e.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
	}
}
