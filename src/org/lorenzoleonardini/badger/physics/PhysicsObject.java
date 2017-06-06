package org.lorenzoleonardini.badger.physics;

import java.util.List;

import org.lorenzoleonardini.badger.Camera;
import org.lorenzoleonardini.badger.input.Input;
import org.lorenzoleonardini.badger.texture.Circle;
import org.lorenzoleonardini.badger.texture.ObjectRender;

/**
 * The PhysicsObject class is the abstraction of an object in the physics
 * engine. This class is used to represent all the possible elements in the
 * abstract world.
 * 
 * @author Lorenzo Leonardini
 *
 */
public class PhysicsObject extends Input
{
	protected Material material;

	public ObjectRender objectRender;
	private boolean unmovable = false;
	private boolean affectedByGravity = true;
	public boolean isOnGround = false;

	private boolean killWhenOutOfBounds = true;

	public boolean flip = false;

	public Vector2D position;
	private Vector2D velocity = new Vector2D(0, 0);
	private Vector2D acceleration = new Vector2D(0, 0);

	private double lifespan = -1;
	private double life = 0;

	private String name;

	protected int gridXs[], gridYs[];

	public PhysicsObject(String name, double x, double y, ObjectRender objectRender, Material material)
	{
		this.name = name;
		this.position = new Vector2D(x, y);
		this.objectRender = objectRender;
		this.material = material;
		ObjectManager.addObject(this);
	}

	/**
	 * The object is updated and moved depending to the delta value
	 * @param delta
	 */
	public void update(double delta)
	{
		velocity.x += acceleration.x * delta;
		velocity.y += acceleration.y * delta;

		acceleration.x = 0;
		acceleration.y = 0;

		life += delta;
	}

	public void collide(List<PhysicsObject> objs)
	{
		Vector2D movement = velocity.copy();
		
		for (PhysicsObject o : objs)
		{
			double mvmt = collisionDetection(o);
			if (mvmt == -1)
				continue;
			else if (mvmt == -2)
				break;
			else
				mvmt *= velocity.length();

			movement.normalize();
			movement.multiply(mvmt);

			Vector2D other = o.velocity.copy();
			other.normalize();
			other.multiply(mvmt);
			o.position.addVector(other);

			// Calcolate bounce

			Vector2D n = new Vector2D(o.position.x - position.x, o.position.y - position.y);
			n.normalize();
			double a1 = velocity.x * n.x + velocity.y * n.y;
			double a2 = o.velocity.x * n.x + o.velocity.y * n.y;

			double mass1 = getMass(), mass2 = o.getMass();
			if (unmovable)
				mass1 = 1000000;
			if (o.unmovable)
				mass2 = 1000000;

			double optimizedP = (2 * (a1 - a2)) / (mass1 + mass2);

			n.multiply(optimizedP);

			Vector2D n2 = n.copy();

			if (!unmovable)
			{
				n.multiply(mass2);
				velocity.subtractVector(n);
//				velocity.multiply(material.getBounciness());
			}

			if (!o.unmovable)
			{
				n2.multiply(mass1);
				o.velocity.addVector(n2);
//				o.velocity.multiply(o.material.getBounciness());
			}

			break;
		}
		position.addVector(movement);
	}

	public double collisionDetection(PhysicsObject obj)
	{
		if (!(objectRender instanceof Circle) || !(obj.objectRender instanceof Circle))
			return -1;
		
		Vector2D v = velocity.copy();
		v.subtractVector(obj.velocity);
		
		double r = objectRender.w / 2;
		double oR = obj.objectRender.w / 2;

		// Check
		// http://www.gamasutra.com/view/feature/131424/pool_hall_lessons_fast_accurate_.php
		// for the theory

		// Check nr 1
		Vector2D c = new Vector2D(obj.position.x - position.x, obj.position.y - position.y);
		double dist = c.length();
		
		dist -= r + oR;

		if (v.length() < dist)
			return -2;

		// Check nr 2
		if (v.x * c.x + v.y * c.y <= 0)
			return -1;

		// Check nr 3
		Vector2D n = v.copy();
		n.normalize();
		double d = n.x * c.x + n.y * c.y;
		double f = c.lengthSquare() - d * d;
		if (f > (r + oR) * (r + oR))
			return -1;

		// Find the actual movement
		double t = (r + oR) * (r + oR) - f;
		// Security check
//		if (t < 0)
//			return -1;

		double distance = d - Math.sqrt(t);

		// Check nr 4
		if (v.lengthSquare() < distance * distance)
			return -1;

		return distance / v.length();
	}

	public Vector2D velocity()
	{
		return velocity;
	}

	public void applyForce(Vector2D force)
	{
		this.acceleration.x += force.x;
		this.acceleration.y += force.y;
	}

	public void applyForce(Vector3D force)
	{
		this.acceleration.x += force.x;
		this.acceleration.y += force.y;
	}

	/**
	 * This method renders the object to the screen
	 * @param pixels
	 *            is the array of pixels
	 * @param screenWidth
	 *            is the width of the screen
	 * @param camera
	 *            the camera. You know. To move everything...
	 */
	public void render(int[] pixels, int screenWidth, Camera camera)
	{
		int x = (int) position.x;
		int y = (int) position.y;

		objectRender.render(pixels, screenWidth, x - (int) camera.position.x, y - (int) camera.position.y, flip);
	}

	/**
	 * This method flips the texture of the object
	 */
	public void flip()
	{
		flip = !flip;
	}

	public void setPosition(Vector3D vec)
	{
		position.x = vec.x;
		position.y = vec.y;
	}

	/**
	 * Set the object as an "unmovable object". This means that no force can
	 * affect and move this object.
	 * @param unmovable
	 */
	public void setUnmovable(boolean unmovable)
	{
		this.unmovable = unmovable;
	}

	public boolean isUnmovable()
	{
		return unmovable;
	}

	public void setAffectedByGravity(boolean affectedByGravity)
	{
		this.affectedByGravity = affectedByGravity;
	}

	public boolean isAffectedByGravity()
	{
		return affectedByGravity;
	}

	/**
	 * Set if the object will be deleted when it will be outside the screen
	 * bounds
	 * @param affectedByGravity
	 */
	public void setKillWhenOutOfBounds(boolean killWhenOutOfBounds)
	{
		this.killWhenOutOfBounds = killWhenOutOfBounds;
	}

	public boolean killWhenOutOfBounds()
	{
		return killWhenOutOfBounds;
	}

	/**
	 * Just kill this object manually!
	 */
	public void kill()
	{
		ObjectManager.getObjects().remove(this);
	}

	public void setLifespan(double lifespan)
	{
		this.lifespan = lifespan;
	}

	protected boolean toBeKilled()
	{
		return lifespan != -1 && life >= lifespan;
	}
	
	public double getMass()
	{
		return material.getDensity() * objectRender.volume;
	}

	public String toString()
	{
		return name;
	}
}
