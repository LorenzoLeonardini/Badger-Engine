#pragma once

#include "../physics/vector.h"

namespace badger {
	namespace engine {

		using namespace physics;

		class Camera
		{
		public:
			Vector3D *position;
		private:
			Vector3D *velocity = new Vector3D(0, 0, 0);
			Vector3D *acceleration = new Vector3D(0, 0, 0);
		public:
			Camera(double x, double y);
			Camera(double x, double y, double z);
			~Camera();
			void update(double delta);
			inline Vector3D *getVelocity() { return velocity; }
			void applyForce(Vector2D *force);
			void applyForce(Vector3D *force);
		};

	}
}