#include "engine.h"

namespace badger {
	namespace engine {

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
			delete keyboard;
			delete mouse;
		}

		void Engine2D::createWindow(int width, int height, const char* title)
		{
			this->HEIGHT = height;
			
			window = new Window(width, height, title);
			keyboard = new Keyboard(window->m_Window);
			mouse = new Mouse(window->m_Window);
			//TODO: icon
		}

		void Engine2D::start()
		{
			m_Running = true;
			m_StartTime = std::chrono::duration_cast<std::chrono::milliseconds>(std::chrono::system_clock::now().time_since_epoch()).count();
			//glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
			run();
		}

		void Engine2D::stop()
		{
			m_Running = false;
		}

		void Engine2D::update()
		{
			GLenum error = glGetError();
			if (error != GL_NO_ERROR)
				std::cout << "OpenGL Error: " << error << std::endl;
		}

		void Engine2D::run()
		{
			using namespace graphics;
			//loop.start();
			
			mat4 ortho = mat4::orthographic(0.0f, 16.0f, 0.0f, 9.0f, -1.0f, 1.0f);


			Shader shader("src/shaders/basic.vert", "src/shaders/basic.frag");
			shader.enable();
			shader.setUniformMat4("pr_matrix", ortho);
			shader.setUniformMat4("ml_matrix", mat4::translation(vec3(4, 3, 0)));

			Renderable2D sprite(vec3(5, 5, 0), vec2(4, 4), vec4(0.2f, 0.3f, 0.8f, 1), shader);
			Renderable2D sprite2(vec3(7, 1, 0), vec2(2, 3), vec4(0.2f, 0, 1, 1), shader);
			Simple2DRenderer renderer;
			
			shader.setUniform2f("light_pos", vec2(4, 1.5f));
			shader.setUniform4f("col", vec4(0.2f, 0.3f, 0.8f, 1.0f));
			
			while (m_Running)
			{
				if (fpsDelta())
					continue;
				handleInput();
				window->clear();
				update();
				double x, y;
				mouse->getMousePosition(x, y);
				shader.setUniform2f("light_pos", vec2((float)(x * 16 / 900), (float)(9 - y * 9 / 516)));
				renderer.submit(&sprite);
				renderer.submit(&sprite2);
				renderer.flush();
				//loop.run();
				window->update();
				m_Running = m_Running && !window->closed();
			}

			//loop.stop();
		}

	}
}