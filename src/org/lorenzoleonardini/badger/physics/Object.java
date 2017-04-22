package org.lorenzoleonardini.badger.physics;

import org.lorenzoleonardini.badger.assets.Texture;

/**
 * The Object class is the abstraction of an object in the physics engine. This class is used to represent all
 * the possible elements in the abstract world.
 * 
 * @author Lorenzo Leonardini
 *
 */
public class Object
{
	private Texture texture;
	private boolean unmovable = false;
	private boolean transparent = false;
	private boolean affectedByGravity = true;
	public boolean isOnGround = false;

	public boolean flip = false;

	public Vector2D position;
	private Vector2D velocity = new Vector2D(0, 0);
	private Vector2D acceleration = new Vector2D(0, 0);

	/**
	 * Create an object in a certain position using a defined texture
	 * @param x
	 * @param y
	 * @param texture
	 */
	public Object(double x, double y, Texture texture)
	{
		this.position = new Vector2D(x, y);
		this.texture = texture;
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
		position.x += velocity.x;
		position.y += velocity.y;

		acceleration.x = 0;
		acceleration.y = 0;

		if (position.y >= 146)
		{
			position.y = 146;
			velocity.y = 0;
			isOnGround = true;
		}
	}

	/**
	 * @return the velocity
	 */
	public Vector2D velocity()
	{
		return velocity;
	}

	/**
	 * Apply a force to the object
	 * @param force
	 */
	public void applyForce(Vector2D force)
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
	 */
	public void render(int[] pixels, int screenWidth)
	{
		int x = (int) position.x;
		int y = (int) position.y;

		if (!flip)
			for (int X = 0; X < texture.getWidth(); X++)
				for (int Y = 0; Y < texture.getHeight(); Y++)
				{
					if (x + X >= screenWidth || x + X < 0 || y + Y >= pixels.length / screenWidth || y + Y < 0 || texture.pixels[X + Y * texture.getWidth()] == 0xff00ff)
						continue;
					pixels[x + X + (y + Y) * screenWidth] = texture.pixels[X + Y * texture.getWidth()];
				}
		else
			for (int X = 1; X <= texture.getWidth(); X++)
				for (int Y = 0; Y < texture.getHeight(); Y++)
				{
					if (x + X >= screenWidth || x + X < 0 || y + Y >= pixels.length / screenWidth || y + Y < 0 || texture.pixels[texture.getWidth() - X + Y * texture.getWidth()] == 0xff00ff)
						continue;
					pixels[x + X + (y + Y) * screenWidth] = texture.pixels[texture.getWidth() - X + Y * texture.getWidth()];
				}
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
	public void setPosition(Vector2D vec)
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

	/**
	 * @return true if the object is unmovable
	 */
	public boolean isUnmovable()
	{
		return unmovable;
	}

	/**
	 * Set the object as a "transparent object". This means that other objects
	 * can't collide with it.
	 * @param transparent
	 */
	public void setTransparent(boolean transparent)
	{
		this.transparent = transparent;
	}

	/**
	 * @return true if the object is transparent
	 */
	public boolean isTransparent()
	{
		return transparent;
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
}
