#include "Engine.h"

namespace badger {
	namespace engine {

		using namespace window;

		Engine::Engine()
		{
			//keyboard = &Keyboard(this);
			//mouse = &Mouse(this);
			camera = new Camera(0, 0);
			if(!checkVersion())
				std::cout << "Can't check for a newest version" << std::endl << std::endl << std::endl;
		}

		Engine::~Engine()
		{
			delete camera;
		}

		bool Engine::checkVersion()
		{
			//TODO: check version :D
			return false;
		}

		void Engine::handleInput()
		{
			//keyboard.update();
			//mouse.update();
		}

		bool Engine::fpsDelta()
		{
			bool b = false;

			if (dt == 1000000000)
				b = true;
			m_Fps++;
			return false;
			long long cur = std::chrono::duration_cast<std::chrono::milliseconds>(std::chrono::system_clock::now().time_since_epoch()).count();
			if (cur > startTime + 1000)
			{
				startTime = cur;
				if (logFPS)
					Log("FPS: " + m_Fps);
				m_Fps = 0;
				if (logObjects)
					Log("NUMBER OF OBJECTS : "); //TODO: add obj
			}

			time = cur;
			dt = (time - lastTime) / 1000.0f;
			lastTime = time;
			return b;
		}



		Engine2D::Engine2D()
		{
			//loader = new Loader();
			//physicsEngine(this);
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
			//TODO: input

		}

		void Engine2D::start()
		{
			running = true;
			startTime = std::chrono::duration_cast<std::chrono::milliseconds>(std::chrono::system_clock::now().time_since_epoch()).count();
			glClearColor(0.2f, 0.3f, 0.7f, 1.0f);
			run();
		}

		void Engine2D::stop()
		{
			running = false;
		}

		void Engine2D::update()
		{
			camera->update(getDelta());
			//physicsEngine.update();
		}

		void Engine2D::run()
		{
			using namespace window;
			//loop.start();

			while (running)
			{
				if (fpsDelta())
					continue;
				handleInput();
				update();
				//loop.run();
				window->render(camera);
				running = running && !window->closed();
			}

			//loop.stop();
		}

	}
}