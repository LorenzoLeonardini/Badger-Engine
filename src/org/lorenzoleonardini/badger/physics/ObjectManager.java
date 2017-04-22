package org.lorenzoleonardini.badger.physics;

import java.util.ArrayList;
import java.util.List;

/**
 * The ObjectManager class, as the name suggest, manages all the objects in the physics engine.
 * 
 * @author Lorenzo Leonardini
 *
 */
public class ObjectManager
{
	private static List<Object> objects = new ArrayList<Object>();
	
	protected static void addObject(Object o)
	{
		objects.add(o);
	}
	
	public static List<Object> getObjects()
	{
		return objects;
	}
}
