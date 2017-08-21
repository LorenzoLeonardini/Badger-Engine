#pragma once

#include <iostream>
#include <vector>

#ifdef BADGER_EMSCRIPTEN
	#define GLFW_INCLUDE_ES3
	#include <GLFW/glfw3.h>
#else
	#include <GL/glew.h>
#endif

#include "../maths/maths.h"
#include "../utils/fileutils.h"

namespace badger {
	namespace graphics {

		/**
			The class which handles the shader program in OpenGL

			@author Yan Chernikov
			@version 04/16/2015
		*/
		class Shader
		{
		private:
			const char *m_VertPath, *m_FragPath;
		public:
			GLuint m_ShaderID;
			/**
				Create the shader

				@param vertPath the path to the vertex shader file
				@param fragPath the path to the fragment shader file
			*/
			Shader(const char *vertPath, const char *fragPath);
			~Shader();

			/**
				Set float uniform value

				@param name the name of the variable in the shader
				@param value the value
			*/
			void setUniform1f(const GLchar *name, float value);
			/**
				Set float array uniform value

				@param name the name of the variable in the shader
				@param value the array pointer
				@param count the size of the array
			*/
			void setUniform1fv(const GLchar *name, float* value, int count);
			/**
				Set integer uniform value

				@param name the name of the variable in the shader
				@param value the value
			*/
			void setUniform1i(const GLchar *name, int value);
			/**
				Set integer array uniform value

				@param name the name of the variable in the shader
				@param value the array pointer
				@param count the size of the array
			*/
			void setUniform1iv(const GLchar *name, int* value, int count);
			/**
				Set vec2 uniform value

				@param name the name of the variable in the shader
				@param vector the vector
			*/
			void setUniform2f(const GLchar *name, const maths::vec2 &vector);
			/**
				Set vec3 uniform value

				@param name the name of the variable in the shader
				@param vector the vector
			*/
			void setUniform3f(const GLchar *name, const maths::vec3 &vector);
			/**
				Set vec4 uniform value

				@param name the name of the variable in the shader
				@param vector the vector
			*/
			void setUniform4f(const GLchar *name, const maths::vec4 &vector);
			/**
				Set mat4 uniform value

				@param name the name of the variable in the shader
				@param matrix the matrix
			*/
			void setUniformMat4(const GLchar *name, const maths::mat4 &matrix);

			void enable() const;
			void disable() const;
		private:
			GLint getUniformLocation(const GLchar *name);
			GLuint load();
		};

	}
}