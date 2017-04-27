package org.lorenzoleonardini.badger.physics;

import org.lorenzoleonardini.badger.Camera;
import org.lorenzoleonardini.badger.input.Input;
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
	private Material material;

	public ObjectRender objectRender;
	private boolean unmovable = false;
	private boolean affectedByGravity = true;
	public boolean isOnGround = false;

	private boolean killWhenOutOfBounds = true;

	public boolean flip = false;

	public Vector3D position;
	private Vector3D velocity = new Vector3D(0, 0, 0);
	private Vector3D acceleration = new Vector3D(0, 0, 0);

	/**
	 * Create an object in a certain position using a defined texture
	 * @param x
	 * @param y
	 * @param objectRender
	 */
	public PhysicsObject(double x, double y, ObjectRender objectRender, Material material)
	{
		this.position = new Vector3D(x, y, 0);
		this.objectRender = objectRender;
		this.material = material;
		ObjectManager.addObject(this);
	}

	/**
	 * Create an object in a certain position using a defined texture
	 * @param x
	 * @param y
	 * @param z
	 * @param objectRender
	 */
	public PhysicsObject(double x, double y, double z, ObjectRender objectRender, Material material)
	{
		this.position = new Vector3D(x, y, z);
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
		velocity.z += acceleration.z * delta;
		position.x += velocity.x;
		position.y += velocity.y;
		position.z += velocity.z;

		acceleration.x = 0;
		acceleration.y = 0;
		acceleration.z = 0;

		// if (position.y >= 146)
		// {
		// position.y = 146;
		// velocity.y = 0;
		// isOnGround = true;
		// }
	}

	/**
	 * @return the velocity
	 */
	public Vector3D velocity()
	{
		return velocity;
	}

	/**
	 * Apply a force to the object
	 * @param force
	 */
	public void applyForce(Vector2D force)
	{
		double mass = material.getMass(objectRender.getVolume());
		this.acceleration.x += force.x * mass;
		this.acceleration.y += force.y * mass;
	}

	/**
	 * Apply a force to the object
	 * @param force
	 */
	public void applyForce(Vector3D force)
	{
		double mass = material.getMass(objectRender.getVolume());
		this.acceleration.x += force.x * mass;
		this.acceleration.y += force.y * mass;
		this.acceleration.z += force.z * mass;
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

	/**
	 * Set the position to the one defined by the vector vec
	 * @param vec
	 */
	public void setPosition(Vector3D vec)
	{
		position.x = vec.x;
		position.y = vec.y;
		position.z = vec.z;
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

	/**
	 * @return true if the object is unmovable
	 */
	public boolean isUnmovable()
	{
		return unmovable;
	}

	/**
	 * Set if the object is affected by gravity or not.
	 * @param affectedByGravity
	 */
	public void setAffectedByGravity(boolean affectedByGravity)
	{
		this.affectedByGravity = affectedByGravity;
	}

	/**
	 * @return true if the object is affected by gravity
	 */
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

	/**
	 * @return true if the object will be killed when out of bounds
	 */
	public boolean killWhenOutOfBounds()
	{
		return killWhenOutOfBounds;
	}
}
