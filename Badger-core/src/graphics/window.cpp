#include "window.h"

namespace badger {
	namespace graphics {

		void window_resize(GLFWwindow *window, int width, int height);

		Window::Window(int width, int height, const char *title)
		{
			m_Title = title;
			m_Width = width;
			m_Height = height;
			if (!init())
				glfwTerminate();
		}

		Window::~Window()
		{
			glfwTerminate();
		}

		void Window::setIconImages()
		{

		}

		void Window::printVersion() const
		{

		}

		bool Window::init()
		{
			if (!glfwInit())
			{
				Log("Failed initializing GLFW");
				return false;
			}

			m_Window = glfwCreateWindow(m_Width, m_Height, m_Title, NULL, NULL);
			if (!m_Window)
			{
				glfwTerminate();
				Log("Failed creating GLFW window!");
				return false;
			}
			glfwMakeContextCurrent(m_Window);
			glfwSetWindowUserPointer(m_Window, this);
			glfwSetWindowSizeCallback(m_Window, window_resize);

			if (glewInit() != GLEW_OK)
			{
				Log("Could not initialize GLEW!");
				return false;
			}

			std::cout << "OpenGL " << glGetString(GL_VERSION) << std::endl << std::endl;
			return true;
		}

		void Window::clear() const
		{
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		}
		
		void Window::update()
		{
			glfwPollEvents();
			glfwSwapBuffers(m_Window);
		}

		bool Window::closed() const
		{
			return glfwWindowShouldClose(m_Window);
		}

		void window_resize(GLFWwindow *window, int width, int height)
		{
			glViewport(0, 0, width, height);
		}

	}
}