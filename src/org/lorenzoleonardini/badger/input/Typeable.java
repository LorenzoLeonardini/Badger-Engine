package org.lorenzoleonardini.badger.input;

import java.util.ArrayList;
import java.util.List;

/**
 * This class defines every subclass that can have KeyboardEvents
 */
public abstract class Typeable
{
	public List<KeyboardEvent> keyEvents = new ArrayList<KeyboardEvent>();
	
	/**
	 * Add a KeyboardEvent to the object
	 * @param e
	 */
	public void addKeyboardEvent(KeyboardEvent e)
	{
		keyEvents.add(e);
	}
	
	/**
	 * Remove a KeyboardEvent to the object
	 * @param e
	 */
	public void removeKeyboardEvent(KeyboardEvent e)
	{
		keyEvents.remove(e);
	}
}
