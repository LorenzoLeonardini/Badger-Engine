#include "window.h"

namespace badger {
	namespace window {

		void windowResize(GLFWwindow *window, int width, int height);

		Window::Window(int width, int height, const char *title)
		{
			m_Title = title;
			m_Width = width;
			m_Height = height;
			if (!init())
				glfwTerminate();

			//screen = new Screen(width, height, this);
		}

		Window::~Window()
		{
			glfwTerminate();
			//delete screen;
		}

		void Window::setIconImages()
		{

		}

		void Window::printVersion() const
		{

		}

		void Window::render(Camera *camera)
		{
			clear();
			//screen.render(camera);
			update();
		}

		bool Window::init()
		{
			if (!glfwInit())
			{
				std::cout << "Failed initializing GLFW" << std::endl;
				return false;
			}

			m_Window = glfwCreateWindow(m_Width, m_Height, m_Title, NULL, NULL);
			if (!m_Window)
			{
				glfwTerminate();
				std::cout << "Failed creating GLFW window!" << std::endl;
				return false;
			}
			glfwMakeContextCurrent(m_Window);
			glfwSetWindowSizeCallback(m_Window, windowResize);
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

		void windowResize(GLFWwindow *window, int width, int height)
		{
			glViewport(0, 0, width, height);
		}
	}
}