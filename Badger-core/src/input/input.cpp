#include "input.h"

namespace badger {
	namespace input {

		bool Mouse::m_buttons[GLFW_MOUSE_BUTTON_LAST];
		double Mouse::mx;
		double Mouse::my;

		Mouse::Mouse(GLFWwindow *window)
		{
			glfwSetMouseButtonCallback(window, mouse_button_callback);
			glfwSetCursorPosCallback(window, cursor_position_callback);

			for (int i = 0; i < GLFW_MOUSE_BUTTON_LAST; i++)
				Mouse::m_buttons[i] = false;
		}

		void Mouse::getMousePosition(double &x, double &y)
		{
			x = Mouse::mx;
			y = Mouse::my;
		}

		void mouse_button_callback(GLFWwindow *window, int button, int action, int mods)
		{
			Mouse::m_buttons[button] = action != GLFW_RELEASE;
		}

		void cursor_position_callback(GLFWwindow *window, double xpos, double ypos)
		{
			Mouse::mx = xpos;
			Mouse::my = ypos;
		}

		bool Keyboard::m_keys[GLFW_KEY_LAST];

		Keyboard::Keyboard(GLFWwindow *window)
		{
			glfwSetKeyCallback(window, key_callback);

			for (int i = 0; i < GLFW_KEY_LAST; i++)
				Keyboard::m_keys[i] = false;
		}

		void key_callback(GLFWwindow *window, int key, int scancode, int action, int mods)
		{
			Keyboard::m_keys[key] = action != GLFW_RELEASE;
		}

	}
}