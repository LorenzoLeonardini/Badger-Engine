#pragma once

#include <iostream>
#include <GL/glew.h>
#include <GLFW/glfw3.h>
#include "../utils.h"

namespace badger {
	namespace window {

		class Window
		{
		private:
			const char *m_Title;
			int m_Width, m_Height;
			GLFWwindow *m_Window;
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
		private:
			bool init();
		};

	}
}