#include "vector.h"

namespace badger {
	namespace physics {

		Vector3D::Vector3D(double x, double y, double z)
		{
			this->x = x;
			this->y = y;
			this->z = z;
		}

		void Vector3D::addVector(Vector3D *vec)
		{
			x += vec->x;
			y += vec->y;
			z += vec->z;
		}

		void Vector3D::subtractVector(Vector3D *vec)
		{
			x -= vec->x;
			y -= vec->y;
			z -= vec->z;
		}

		void Vector3D::invert()
		{
			x *= -1;
			y *= -1;
			z *= -1;
		}

		void Vector3D::multiply(double d)
		{
			x *= d;
			y *= d;
			z *= d;
		}

		void Vector3D::multiply(double x, double y)
		{
			this->x *= x;
			this->y *= y;
		}

		void Vector3D::multiply(double x, double y, double z)
		{
			this->x *= x;
			this->y *= y;
			this->z *= z;
		}

		void Vector3D::normalize()
		{
			double length = sqrt(x * x + y * y + z * z);
			if (length == 0)
				return;
			multiply(1 / length);
		}

		double Vector3D::length()
		{
			return sqrt(lengthSquare());
		}

		double Vector3D::lengthSquare()
		{
			return x * x + y * y + z * z;
		}

		Vector3D *random3DVector(int magnitude)
		{
			double length = (rand() / RAND_MAX) * magnitude;
			double alpha = (rand() / RAND_MAX) * 360;
			double beta = (rand() / RAND_MAX) * 360;
			double x = cos(alpha * (M_PI / 180)) * cos(beta * (M_PI / 180));
			double y = sin(alpha * (M_PI / 180)) * cos(beta * (M_PI / 180));
			double z = sin(beta * (M_PI / 180));
			x *= length;
			y *= length;
			z *= length;
			return new Vector3D(x, y, z);
		}

		Vector3D *random3DVector()
		{
			return random3DVector(1);
		}

		Vector2D::Vector2D(double x, double y)
		{
			this->x = x;
			this->y = y;
		}

		void Vector2D::addVector(Vector2D *vec)
		{
			x += vec->x;
			y += vec->y;
		}

		void Vector2D::subtractVector(Vector2D *vec)
		{
			x -= vec->x;
			y -= vec->y;
		}

		void Vector2D::invert()
		{
			x *= -1;
			y *= -1;
		}

		void Vector2D::multiply(double d)
		{
			x *= d;
			y *= d;
		}

		void Vector2D::multiply(double x, double y)
		{
			this->x *= x;
			this->y *= y;
		}

		void Vector2D::normalize()
		{
			double length = sqrt(x * x + y * y);
			if (length == 0)
				return;
			multiply(1 / length);
		}

		double Vector2D::length()
		{
			return sqrt(lengthSquare());
		}

		double Vector2D::lengthSquare()
		{
			return x * x + y * y;
		}

		Vector2D *random2DVector(int magnitude)
		{
			double length = (rand() / RAND_MAX) * magnitude;
			double angle = (rand() / RAND_MAX) * 360;
			double x = cos(angle * (M_PI / 180)) * length;
			double y = sin(angle * (M_PI / 180)) * length;
			return new Vector2D(x, y);
		}

		Vector2D *random2DVector()
		{
			return random2DVector(1);
		}

	}
}