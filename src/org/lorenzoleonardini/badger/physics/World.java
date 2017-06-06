package org.lorenzoleonardini.badger.physics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is used to find all the objects and order them by distance
 * 
 * @author Lorenzo
 */
public class World
{
	private static final List<PhysicsObject> empty = new ArrayList<PhysicsObject>();

	public List<PhysicsObject> getNeightbours(PhysicsObject o)
	{
		if (o.material.isTransparent())
			return empty;

		List<PhysicsObject> objs = new ArrayList<PhysicsObject>(ObjectManager.getObjects());

		Map<Double, PhysicsObject> map = new HashMap<Double, PhysicsObject>();

		for (int i = 0; i < objs.size(); i++)
			if (objs.get(i) != o && !objs.get(i).material.isTransparent())
				map.put(getDistance(o.position, objs.get(i).position), objs.get(i));

		List<PhysicsObject> ret = new ArrayList<PhysicsObject>();

		List<Double> sortedKeys = new ArrayList<Double>(map.keySet());
		Collections.sort(sortedKeys);

		for (double key : sortedKeys)
		{
			ret.add(map.get(key));
			map.remove(key);
		}

		return ret;
	}

	private double getDistance(Vector2D a, Vector2D b)
	{
		return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
	}
}
