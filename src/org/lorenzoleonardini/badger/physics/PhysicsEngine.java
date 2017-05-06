package org.lorenzoleonardini.badger.physics;

import java.util.ArrayList;
import java.util.List;

import org.lorenzoleonardini.badger.Engine;

/**
 * @author Lorenzo Leonardini
 */
public class PhysicsEngine
{
	private Vector2D gravity = new Vector2D(0, 2);

	private List<PhysicsObject> toRemove = new ArrayList<PhysicsObject>();

	private Engine engine;

	public PhysicsEngine(Engine engine)
	{
		this.engine = engine;
	}

	public void update()
	{
		for (PhysicsObject o : ObjectManager.getObjects())
		{
			if (o.isAffectedByGravity())
				o.applyForce(gravity);

			o.update(engine.getDelta());

			if (o.killWhenOutOfBounds())
			{
				if (o.position.y - o.objectRender.h >= engine.HEIGHT)
					toRemove.add(o);
			}
		}

		ObjectManager.getObjects().removeAll(toRemove);
	}
}
