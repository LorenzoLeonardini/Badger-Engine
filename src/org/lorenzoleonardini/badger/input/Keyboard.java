package org.lorenzoleonardini.badger.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

/**
 * The Keyboard class manages all the input from the user's keyboard
 * 
 * @author Lorenzo Leonardini
 *
 */
public class Keyboard implements KeyListener
{
	public List<Integer> pressedKeys = new ArrayList<Integer>();
	public List<Integer> typedKeys = new ArrayList<Integer>();

	/**
	 * Updates the keyboard lists
	 */
	public void update()
	{
		typedKeys.clear();
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (!pressedKeys.contains(e.getKeyCode()))
		{
			pressedKeys.add(e.getKeyCode());
			typedKeys.add(e.getKeyCode());
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		pressedKeys.remove((Integer) e.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
	}

	/**
	 * @param key
	 * @return true if the key is pressed
	 */
	public boolean isPressed(int key)
	{
		return pressedKeys.contains(key);
	}

	/**
	 * @param key
	 * @return true if the key has just been pressed
	 */
	public boolean isTyped(int key)
	{
		return typedKeys.contains(key);
	}

}
