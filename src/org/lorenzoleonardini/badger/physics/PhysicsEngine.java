package org.lorenzoleonardini.badger.physics;

import java.util.ArrayList;
import java.util.List;

import org.lorenzoleonardini.badger.Engine;

/**
 * @author Lorenzo Leonardini
 */
public class PhysicsEngine
{
	private Vector2D gravity = new Vector2D(0, 5);

	private List<PhysicsObject> toRemove = new ArrayList<PhysicsObject>();

	private Engine engine;

	public World world;

	public PhysicsEngine(Engine engine)
	{
		this.engine = engine;
		world = new World();
	}

	public void update()
	{
		List<PhysicsObject> objs = new ArrayList<PhysicsObject>(ObjectManager.getObjects());

		for (PhysicsObject o : objs)
		{
			if (o.isAffectedByGravity() && !o.isUnmovable())
				o.applyForce(gravity);

			o.update(engine.getDelta());

			if (o.killWhenOutOfBounds())
				if (o.position.y - o.objectRender.h >= engine.HEIGHT)
					toRemove.add(o);

			if (!toRemove.contains(o))
				if (o.toBeKilled())
					toRemove.add(o);
		}

		ObjectManager.getObjects().removeAll(toRemove);

		for (PhysicsObject o : objs)
		{
			o.collide(world.getNeightbours(o));
		}
	}
}
