#pragma once

#include <iostream>

#ifdef BADGER_EMSCRIPTEN
	#define GLFW_INCLUDE_ES3
	#include <FreeImage.h>
#else
	#include <GL/glew.h>
#endif

#include <GLFW/glfw3.h>

#include "../utils/utils.h"
#include "../input/input.h"

#include "font_manager.h"
#include "../audio/sound_manager.h"

namespace badger {
	namespace graphics {

		using namespace input;

		/**
			The Window class
			
			Used to handle input and window callback

			@author Lorenzo Leonardini
			@version 08/21/2017
		*/
		class Window
		{
		public:
			GLFWwindow *m_Window;
		private:
			const char *m_Title;
			int m_Width, m_Height;
		public:
			/**
				Create a new window

				@param width window width
				@param height window height
				@param title string title
			*/
			Window(int width, int height, const char *title);
			~Window();
			/**
				Set the icon of the window

				It takes in an array of GLFWimages, from which OpenGL will choose
				depending on the system

				@param images the array of GLFWimages
				@param count the size of the array
			*/
			void setIconImages(GLFWimage images[], int count);
			/**
				Print the OpenGL version
			*/
			void printVersion() const;

			void clear() const;
			void update();
			bool closed() const;

			inline int getWidth() const { return m_Width; }
			inline int getHeight() const { return m_Height; }

			friend void window_resize(GLFWwindow *window, int width, int height);
		private:
			bool init();
		};

	}
}