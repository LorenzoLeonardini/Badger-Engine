#pragma once

#include <iostream>
#include <chrono>
#include "../graphics/window.h"
#define _USE_MATH_DEFINES
#include <math.h>
#include "../utils/utils.h"
#include "../input/input.h"
#include "../maths/maths.h"
#include "../graphics/shader.h"

#include "../graphics/buffers/buffer.h"
#include "../graphics/buffers/indexbuffer.h"
#include "../graphics/buffers/vertexarray.h"

#include "../graphics/simple2drenderer.h"
#include "../graphics/renderable2d.h"

namespace badger {
	namespace engine {

		using namespace graphics;
		using namespace input;
		using namespace maths;

		class Engine
		{
		private:
			int m_Fps = 0;
			long long m_Time, m_LastTime = 0;
			double m_Dt = 1000000000;
			const char *VERSION = "v0.3.1Beta";
		protected:
			long long m_StartTime;
		public:
			bool m_LogFPS = true, m_LogObjects = true;
		public:
			Engine();
			~Engine();
			inline double getDelta() const { return m_Dt; }
			//void loop();
		private:
			bool checkVersion();
		protected:
			void handleInput();
			bool fpsDelta();
		};

		class Engine2D : Engine
		{
		private:
			Keyboard *keyboard;
			Mouse *mouse;
		public:
			bool m_Running = false;
		public:
			badger::graphics::Window *window;
			double HEIGHT;
		public:
			Engine2D();
			~Engine2D();
			void createWindow(int width, int height, const char *title);
			void setIconImages();
			void start();
			void stop();
			void update();
			void run();
		};

	}
}