package org.lorenzoleonardini.badger.physics;

import org.lorenzoleonardini.badger.window.Game;

/**
 * The PhysicsEngine class does all the actual physics of the engine
 * 
 * @author Lorenzo Leonardini
 *
 */
public class PhysicsEngine
{
	private Vector2D gravity = new Vector2D(0, 3);
	
	private Game game;
	
	public PhysicsEngine(Game game)
	{
		this.game = game;
	}
	
	/**
	 * Updates the physics engine and, by doing that, updates all the objects
	 */
	public void update()
	{
		for(Object o : ObjectManager.getObjects())
		{
			if(o.isAffectedByGravity())
				o.applyForce(gravity);
			
			o.update(game.getDelta());
		}
	}
}
