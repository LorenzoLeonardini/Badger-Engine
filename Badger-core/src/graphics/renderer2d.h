#pragma once

#include <vector>

#ifdef BADGER_EMSCRIPTEN
	#define GLFW_INCLUDE_ES3
	#include <GLFW/glfw3.h>
#else
	#include <GL/glew.h>
#endif

#include "font.h"
#include "../maths/maths.h"

namespace badger {
	namespace graphics {

		class Renderable2D;

		/**
			Abstract structure of a 2D renderer

			@author Lorenzo Leonardini
			@version 08/21/2017
		*/
		class Renderer2D
		{
		protected:
			std::vector<maths::mat4> m_TransformationStack;
			const maths::mat4 *m_TransformationBack;
		protected:
			Renderer2D()
			{
				m_TransformationStack.push_back(maths::mat4::identity());
				m_TransformationBack = &m_TransformationStack.back();
			}
		public:
			virtual ~Renderer2D() { }
			/**
				Push a transformation matrix which affect all the Renderable2D from now on

				@param matrix the transformation matrix
				@param override [optional] if false or omitted the matrix will be added to the current one. If true it will override the previous ones
			*/
			void push(const maths::mat4 &matrix, bool override = false)
			{
				if(override)
					m_TransformationStack.push_back(matrix);
				else
					m_TransformationStack.push_back(m_TransformationStack.back() * matrix);

				m_TransformationBack = &m_TransformationStack.back();
			}

			/**
				Pop the last transformation matrix
			*/
			void pop()
			{
				if(m_TransformationStack.size() > 1)
					m_TransformationStack.pop_back();
				//TODO: Add to log!

				m_TransformationBack = &m_TransformationStack.back();
			}

			virtual void begin() {}
			/**
				Submit a Renderable2D object to the renderer
			*/
			virtual void submit(const Renderable2D *renderable) = 0;
			/**
				Draw a string

				@param text the content
				@param position the position
				@param font the Font object used to render the string
				@param color the color used to render the string
			*/
			virtual void drawString(const std::string &text, const maths::vec3 &position, const Font &font, unsigned int color) {}
			virtual void end() {}
			virtual void flush() = 0;
		};

	}
}