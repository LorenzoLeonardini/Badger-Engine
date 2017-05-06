package org.lorenzoleonardini.badger.physics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lorenzo Leonardini
 */
public class ObjectManager
{
	private static List<PhysicsObject> objects = new ArrayList<PhysicsObject>();

	protected static void addObject(PhysicsObject o)
	{
		objects.add(o);
	}

	public static List<PhysicsObject> getObjects()
	{
		return objects;
	}
}
