package org.lorenzoleonardini.badger.input;

import java.util.ArrayList;
import java.util.List;

/**
 * This class defines every subclass that can have KeyboardEvents and
 * MouseEvents
 * 
 * @author Lorenzo Leonardini
 */
public abstract class Input
{
	public List<MouseEvent> mouseEvents = new ArrayList<MouseEvent>();
	public List<KeyboardEvent> keyEvents = new ArrayList<KeyboardEvent>();

	public void addMouseEvent(MouseEvent e)
	{
		mouseEvents.add(e);
	}

	public void removeMouseEvent(MouseEvent e)
	{
		mouseEvents.remove(e);
	}

	public void addKeyboardEvent(KeyboardEvent e)
	{
		keyEvents.add(e);
	}

	public void removeKeyboardEvent(KeyboardEvent e)
	{
		keyEvents.remove(e);
	}
}
