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
	
	@Override
	public void keyPressed(KeyEvent e)
	{
		if(!pressedKeys.contains(e.getKeyCode()))
			pressedKeys.add(e.getKeyCode());
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
	
	public boolean isPressed(int key)
	{
		return pressedKeys.contains(key);
	}

}
