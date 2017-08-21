#pragma once
#include <GLFW/glfw3.h>

namespace badger {
	namespace input {

		/**
			Class which handles all the inputs from the mouse

			@author Lorenzo Leonardini
			@version 08/21/2017
		*/
		class Mouse
		{
		private:
			static bool m_buttons[GLFW_MOUSE_BUTTON_LAST];
			static double mx, my;
		public:
			/**
				Initialize the Mouse class using the GLFW window it will take care of

				@param window the window
			*/
			Mouse(GLFWwindow *window);

			/**
				Get mouse position in the variables put in

				@param x the x coordinate
				@param y the y coordinate
			*/
			void getMousePosition(double &x, double &y);

			/**
				Check if mouse button is pressed

				@param button the button code
				@return true if the button is pressed
			*/
			inline bool pressed(unsigned int button) const { return m_buttons[button]; }
		private:
			friend void mouse_button_callback(GLFWwindow *window, int button, int action, int mods);
			friend void cursor_position_callback(GLFWwindow *window, double xpos, double ypos);
		};

		/**
			Class which handles all the inputs from the keyboard

			@author Lorenzo Leonardini
			@version 08/21/2017
		*/
		class Keyboard
		{
		private:
			static bool m_keys[GLFW_KEY_LAST];
		public:
			/**
				Initialize the Keyboard class using the GLFW window it will take care of

				@param window the window
			*/
			Keyboard(GLFWwindow *window);

			/**
				Check if key is pressed

				@param key the key code
				@return true if the key is pressed
			*/
			inline bool pressed(unsigned int key) const	{ return m_keys[key]; }
		private:
			friend void key_callback(GLFWwindow *window, int key, int scancode, int action, int mods);
		};

	}
}
