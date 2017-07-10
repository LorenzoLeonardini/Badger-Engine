#include "camera.h"

namespace badger {
	namespace engine {

		Camera::Camera(double x, double y)
		{
			position = new Vector3D(x, y, 0);
		}

		Camera::Camera(double x, double y, double z)
		{
			position = new Vector3D(x, y, z);
		}

		Camera::~Camera()
		{
			delete position;
			delete velocity;
			delete acceleration;
		}
		
		void Camera::update(double delta)
		{
			velocity->x += acceleration->x * delta;
			velocity->y += acceleration->y * delta;
			velocity->z += acceleration->z * delta;
			position->x += velocity->x;
			position->y += velocity->y;
			position->z += velocity->z;

			acceleration->x = 0;
			acceleration->y = 0;
			acceleration->z = 0;
		}

		void Camera::applyForce(Vector2D *force)
		{
			acceleration->x += force->x;
			acceleration->y += force->y;
		}

		void Camera::applyForce(Vector3D *force)
		{
			acceleration->x += force->x;
			acceleration->y += force->y;
			acceleration->z += force->z;
		}

	}
}