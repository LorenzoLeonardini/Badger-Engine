#pragma once

#define _USE_MATH_DEFINES
#include <math.h>

namespace badger { namespace maths {

	/**
		Convert degrees in radians

		@param degrees
		@return radians
	*/
	inline float toRadians(float degrees)
	{
		return degrees * (M_PI / 180.0f);
	}

} }