#pragma once

#ifdef BADGER_EMSCRIPTEN
	#include <emscripten/emscripten.h>
#endif

#include "graphics/window.h"
#include "graphics/sprite.h"
#include "graphics/label.h"
#include "graphics/font_manager.h"
#include "graphics/batchrenderer2d.h"
#include "graphics/layers/layer.h"

#include "physics/physicsengine.h"

#include "maths/maths.h"
#include "utils/timer.h"


#ifdef BADGER_EMSCRIPTEN

static void dispatch_main(void *fp)
{
	std::function<void()> *func = (std::function<void()>*)fp;
	(*func)();
}

#endif

namespace badger
{
	class Badger
	{
	private:
		physics::PhysicsEngine *m_PhysicsEngine;
		graphics::Window *m_Window;
		Timer *m_Timer;
		unsigned int m_FramesPerSecond, m_UpdatesPerSecond;
	protected:
		input::Keyboard *keyboard;
		input::Mouse *mouse;
	protected:
		Badger() : m_FramesPerSecond(0), m_UpdatesPerSecond(0)
		{
			m_PhysicsEngine = new physics::PhysicsEngine();
			srand(static_cast <unsigned> (time(0)));
		}
		virtual ~Badger() 
		{ 
			delete m_Window;
			delete m_Timer;
			delete keyboard;
			delete mouse;
		}

		graphics::Window *createWindow(int width, int height, const char *name)
		{
			m_Window = new graphics::Window(width, height, name);
			keyboard = new input::Keyboard(m_Window->m_Window);
			mouse = new input::Mouse(m_Window->m_Window);
			return m_Window;
		}

	public:
		void start()
		{
			init();
			run();
		}

	protected:
		// Runs once upon initialization
		virtual void init() = 0;
		// Runs once per second
		virtual void tick() { }
		// Runs 60 times per second
		virtual void update() { }
		// Runs as fast as possible (unless vsync is enabled)
		virtual void render() = 0;

		const unsigned int getFPS() const { return m_FramesPerSecond; }
		const unsigned int getUPS() const { return m_UpdatesPerSecond; }
	private:
		void run()
		{
			m_Timer = new Timer();
			float timer = 0.0f;
			float updateTimer = 0.0f;
			float updateTick = 1.0f / 60.0f;
			unsigned int frames = 0;
			unsigned int updates = 0;

			#ifdef BADGER_EMSCRIPTEN
			std::function<void()> mainLoop = [&]() {
				#else
			while (!m_Window->closed())
			{
				#endif
				m_Window->clear();

				if (m_Timer->elapsed() - updateTimer > updateTick)
				{
					update();
					m_PhysicsEngine->update(updateTick);
					updates++;
					updateTimer += updateTick;
				}

				render();
				frames++;
				m_Window->update();
				if (m_Timer->elapsed() - timer > 1.0f)
				{
					timer += 1.0f;
					m_FramesPerSecond = frames;
					m_UpdatesPerSecond = updates;
					frames = 0;
					updates = 0;
					tick();
				}
#ifdef BADGER_EMSCRIPTEN
			};
			emscripten_set_main_loop_arg(dispatch_main, &mainLoop, 0, 1);
#else
			}
#endif
		}
	};
}