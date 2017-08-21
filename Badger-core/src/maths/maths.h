#pragma once

#include <math.h>
#include "maths_func.h"
#include "vec2.h"
#include "vec3.h"
#include "vec4.h"
#include "mat4.h"

namespace badger { namespace maths {

	/**
		Create a random 2D vector with defined magnitude
		
		@param magnitude
	*/
	static vec2 randomVec2(float magnitude)
	{
		float length = (static_cast <float> (rand()) / static_cast <float> (RAND_MAX)) * magnitude;
		float angle = (static_cast <float> (rand()) / static_cast <float> (RAND_MAX)) * 360;
		float x = cos(toRadians(angle)) * length;
		float y = sin(toRadians(angle)) * length;
		return vec2(x, y);
	}

	/**
		Create a random 2D vector with magnitude of 1
	*/
	static vec2 randomVec2()
	{
		float length = (static_cast <float> (rand()) / static_cast <float> (RAND_MAX));
		float angle = (static_cast <float> (rand()) / static_cast <float> (RAND_MAX)) * 360;
		float x = cos(toRadians(angle)) * length;
		float y = sin(toRadians(angle)) * length;
		return vec2(x, y);
	}

	/**
		Create a random 3D vector with defined magnitude

		@param magnitude
	*/
	static vec3 randomVec3(float magnitude)
	{
		float length = (static_cast <float> (rand()) / static_cast <float> (RAND_MAX)) * magnitude;
		float alpha = (static_cast <float> (rand()) / static_cast <float> (RAND_MAX)) * 360;
		float beta = (static_cast <float> (rand()) / static_cast <float> (RAND_MAX)) * 360;
		float x = cos(toRadians(alpha)) * cos(toRadians(beta));
		float y = sin(toRadians(alpha)) * cos(toRadians(beta));
		float z = sin(toRadians(beta));
		x *= length;
		y *= length;
		z *= length;
		return vec3(x, y, z);
	}

	/**
		Create a random 3D vector with magnitude of 1
	*/
	static vec3 randomVec3()
	{
		float length = (static_cast <float> (rand()) / static_cast <float> (RAND_MAX));
		float alpha = (static_cast <float> (rand()) / static_cast <float> (RAND_MAX)) * 360;
		float beta = (static_cast <float> (rand()) / static_cast <float> (RAND_MAX)) * 360;
		float x = cos(toRadians(alpha)) * cos(toRadians(beta));
		float y = sin(toRadians(alpha)) * cos(toRadians(beta));
		float z = sin(toRadians(beta));
		x *= length;
		y *= length;
		z *= length;
		return vec3(x, y, z);
	}

} }