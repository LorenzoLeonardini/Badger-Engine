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

		class Window
		{
		public:
			GLFWwindow *m_Window;
		private:
			const char *m_Title;
			int m_Width, m_Height;
		public:
			Window(int width, int height, const char *title);
			~Window();
			void setIconImages();
			void printVersion() const;
			void render();

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