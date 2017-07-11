#pragma once
#include <iostream>
#include <chrono>
#include "../window/window.h"
#define _USE_MATH_DEFINES
#include <math.h>
#include "../utils.h"

namespace badger {
	namespace engine {

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
			double HEIGHT;
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
		public:
			badger::window::Window *window;
			bool m_Running = false;
		public:
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