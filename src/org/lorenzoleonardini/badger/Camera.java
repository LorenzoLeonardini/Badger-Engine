package org.lorenzoleonardini.badger;

import org.lorenzoleonardini.badger.physics.Vector2D;
import org.lorenzoleonardini.badger.physics.Vector3D;

/**
 * The game camera :P
 * 
 * @author Lorenzo Leonardini
 */
public class Camera
{
	public Vector3D position;
	private Vector3D velocity = new Vector3D(0, 0, 0);
	private Vector3D acceleration = new Vector3D(0, 0, 0);
	
	public Camera(double x, double y)
	{
		position = new Vector3D(x, y, 0);
	}
	
	public Camera(double x, double y, double z)
	{
		position = new Vector3D(x, y, z);
	}
	
	/**
	 * The camera is updated and moved depending to the delta value
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
	}
	
	/**
	 * @return the velocity
	 */
	public Vector3D velocity()
	{
		return velocity;
	}

	/**
	 * Apply a force to the camera
	 * @param force
	 */
	public void applyForce(Vector2D force)
	{
		this.acceleration.x += force.x;
		this.acceleration.y += force.y;
	}
	
	/**
	 * Apply a force to the camera
	 * @param force
	 */
	public void applyForce(Vector3D force)
	{
		this.acceleration.x += force.x;
		this.acceleration.y += force.y;
		this.acceleration.z += force.z;
	}
}
