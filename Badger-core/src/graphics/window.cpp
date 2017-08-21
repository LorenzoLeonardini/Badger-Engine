#include "window.h"

#include <Windows.h>

namespace badger {
	namespace graphics {

#define CAP_FPS 0

		void window_resize(GLFWwindow *window, int width, int height);

		Window::Window(int width, int height, const char *title)
			: m_Title(title), m_Width(width), m_Height(height)
		{
			if (!init())
				glfwTerminate();

#ifdef BADGER_EMSCRIPTEN
			FontManager::add(new Font("arial", "res/arial.ttf", 25));
#else
			FontManager::add(new Font("arial", "arial.ttf", 25));
#endif

#ifdef BADGER_EMSCRIPTEN
			FreeImage_Initialise();
#endif

			audio::SoundManager::init();
		}

		Window::~Window()
		{
			glfwTerminate();
			FontManager::clean();
			audio::SoundManager::clean();
		}

		void Window::setIconImages(GLFWimage images[], int count)
		{
			glfwSetWindowIcon(m_Window, count, images);
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
			glfwSetFramebufferSizeCallback(m_Window, window_resize);
			glfwSwapInterval(CAP_FPS);
			glfwSetWindowUserPointer(m_Window, this);

#ifndef BADGER_EMSCRIPTEN
			if (glewInit() != GLEW_OK)
			{
				Log("Could not initialize GLEW!");
				return false;
			}
#endif
			glEnable(GL_BLEND);
			glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);

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
			Window *win = (Window *) glfwGetWindowUserPointer(window);
			win->m_Width = width;
			win->m_Height = height;
		}

	}
}