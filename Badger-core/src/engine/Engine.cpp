#include "engine.h"

namespace badger {
	namespace engine {

		using namespace window;

		Engine::Engine()
		{
			if(!checkVersion())
				std::cout << "Can't check for a newest version" << std::endl << std::endl << std::endl;
		}

		Engine::~Engine()
		{
		}

		bool Engine::checkVersion()
		{
			//TODO: check version :D
			return false;
		}

		void Engine::handleInput()
		{
		}

		bool Engine::fpsDelta()
		{
			bool b = false;

			if (m_Dt == 1000000000)
				b = true;
			m_Fps++;
			long long cur = std::chrono::duration_cast<std::chrono::milliseconds>(std::chrono::system_clock::now().time_since_epoch()).count();
			if (cur > m_StartTime + 1000)
			{
				m_StartTime = cur;
				if (m_LogFPS)
					Log("FPS: " << m_Fps);
				m_Fps = 0;
				if (m_LogObjects)
					Log("NUMBER OF OBJECTS : "); //TODO: add obj
			}

			m_Time = cur;
			m_Dt = (m_Time - m_LastTime) / 1000.0f;
			m_LastTime = m_Time;
			return b;
		}



		Engine2D::Engine2D()
		{
		}

		Engine2D::~Engine2D()
		{
			delete window;
		}

		void Engine2D::createWindow(int width, int height, const char* title)
		{
			this->HEIGHT = height;
			
			window = new Window(width, height, title);

			//TODO: icon
		}

		void Engine2D::start()
		{
			m_Running = true;
			m_StartTime = std::chrono::duration_cast<std::chrono::milliseconds>(std::chrono::system_clock::now().time_since_epoch()).count();
			glClearColor(0.2f, 0.3f, 0.8f, 1.0f);
			run();
		}

		void Engine2D::stop()
		{
			m_Running = false;
		}

		void Engine2D::update()
		{
			glBegin(GL_TRIANGLE_STRIP);
			for (int i = 0; i <= 360; i+=2) {
				double angle = 2 * M_PI * i / 360;
				double x = cos(angle) * .3f;
				double y = sin(angle) * .3f;
				glVertex2d(x, y);
				i+=2;
				angle = 2 * M_PI * i / 360;
				x = cos(angle) * .3f;
				y = sin(angle) * .3f;
				glVertex2d(x, y);
				glVertex2d(0, 0);
			}
			glEnd();
		}

		void Engine2D::run()
		{
			using namespace window;
			//loop.start();
			
			GLuint vao;
			glGenVertexArrays(1, &vao);
			glBindVertexArray(vao);

			while (m_Running)
			{
				if (fpsDelta())
					continue;
				handleInput();
				window->clear();
				//update();
				glDrawArrays(GL_ARRAY_BUFFER, 0, 6);
				//loop.run();
				window->update();
				m_Running = m_Running && !window->closed();
			}

			//loop.stop();
		}

	}
}