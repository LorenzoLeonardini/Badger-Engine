#pragma once

#include "vec3.h"
#include "vec4.h"
#include "maths_func.h"

namespace badger {
	namespace maths {

		/**
			4x4 Matrix object

			@author Yan Chernikov
			@version 04/11/2015
		*/
		struct mat4
		{
			union
			{
				float elements[4 * 4];
				vec4 columns[4];
			};

			/**
				Create matrix
			*/
			mat4();
			/**
				Create matrix setting a diagonal value

				@param diagonal the diagonal
			*/
			mat4(float diagonal);

			/**
				@return an identity matrix
			*/
			static mat4 identity();

			mat4 &multiply(const mat4 &other);
			friend mat4 operator*(const mat4 left, const mat4 &right);
			mat4 &operator*=(const mat4 &other);

			vec3 multiply(const vec3& other) const;
			friend vec3 operator*(const mat4& left, const vec3& right);

			vec4 multiply(const vec4& other) const;
			friend vec4 operator*(const mat4& left, const vec4& right);

			mat4 &invert();

			/**
				Create an ortographic matrix

				@param left left plane
				@param right right plane
				@param bottom bottom plane
				@param top top plane
				@param near near plane
				@param far far plane
				@return the generated matrix
			*/
			static mat4 orthographic(float left, float right, float bottom, float top, float near, float far);
			/**
				Create a perspective matrix

				@param fov the field of view
				@param aspectRatio the aspect ratio
				@param near near plane
				@param far far plane
				@return the generated matrix
			*/
			static mat4 perspective(float fov, float aspectRatio, float near, float far);

			/**
				Create a translation matrix

				@param translation vec3 translation
				@return the generated matrix
			*/
			static mat4 translation(const vec3 &translation);
			/**
				Create a rotation matrix

				@param angle float angle
				@param axis vec3 axis
				@return the generated matrix
			*/
			static mat4 rotation(float angle, const vec3 &axis);
			/**
				Create a scale matrix

				@param translation vec3 scale
				@return the generated matrix
			*/
			static mat4 scale(const vec3 &scale);

		};

	}
}