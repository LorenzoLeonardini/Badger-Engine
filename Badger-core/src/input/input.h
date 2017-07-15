#pragma once
#include <GLFW/glfw3.h>

namespace badger {
	namespace input {

		class Mouse
		{
		private:
			static bool m_buttons[GLFW_MOUSE_BUTTON_LAST];
			static double mx, my;
		public:
			Mouse(GLFWwindow *window);

			void getMousePosition(double &x, double &y);

			inline bool pressed(unsigned int button) const { return m_buttons[button]; }
		private:
			friend static void mouse_button_callback(GLFWwindow *window, int button, int action, int mods);
			friend static void cursor_position_callback(GLFWwindow *window, double xpos, double ypos);
		};

		class Keyboard
		{
		private:
			static bool m_keys[GLFW_KEY_LAST];
		public:
			Keyboard(GLFWwindow *window);

			inline bool pressed(unsigned int key) const	{ return m_keys[key]; }
		private:
			friend static void key_callback(GLFWwindow *window, int key, int scancode, int action, int mods);
		};

	}
}
