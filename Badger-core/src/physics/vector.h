#pragma once

#include <random>
#define _USE_MATH_DEFINES
#include <math.h>

namespace badger {
	namespace physics {

		class Vector3D
		{
		public:
			double x = 0, y = 0, z = 0;
		public:
			Vector3D(double x, double y, double z);
			void addVector(Vector3D *vec);
			void subtractVector(Vector3D *vec);
			inline Vector3D *copy() const { return new Vector3D(x, y, z); }
			void invert();
			void multiply(double d);
			void multiply(double x, double y);
			void multiply(double x, double y, double z);
			void normalize();
			double length();
			double lengthSquare();
		};
		Vector3D *random3DVector(int magnitude);
		Vector3D *random3DVector();

		class Vector2D
		{
		public:
			double x = 0, y = 0;
		public:
			Vector2D(double x, double y);
			void addVector(Vector2D *vec);
			void subtractVector(Vector2D *vec);
			inline Vector2D *copy() const { return new Vector2D(x, y); }
			void invert();
			void multiply(double d);
			void multiply(double x, double y);
			void normalize();
			double length();
			double lengthSquare();
		};
		Vector2D *random2DVector(int magnitude);
		Vector2D *random2DVector();
	}
}