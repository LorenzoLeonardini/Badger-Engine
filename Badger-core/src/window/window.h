#pragma once

#include <GLFW/glfw3.h>
#include <iostream>
#include "../renderer/screen.h"

namespace badger {
	namespace window {

		using namespace renderer;
		using namespace engine;

		class Window
		{
		private:
			const char *m_Title;
			int m_Width, m_Height;
			GLFWwindow *m_Window;
			//Screen *screen;
		public:
			Window(int width, int height, const char *title);
			~Window();
			void setIconImages();
			void printVersion() const;
			void render(Camera *camera);

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