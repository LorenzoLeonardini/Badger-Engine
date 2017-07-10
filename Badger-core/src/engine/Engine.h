#pragma once
#include <iostream>
#include <chrono>
#include "../window/window.h"
#define Log(x) std::cout << "ENGINE > " << x << std::endl

namespace badger {
	namespace engine {

		class Engine
		{
		private:
			int m_Fps = 0;
			long long time, lastTime = 0;
			double dt = 1000000000;
			const char *VERSION = "v0.3.1Beta";
		protected:
			long long startTime;
			Camera *camera;
		public:
			double HEIGHT;
			//Keyboard keyboard;
			//Mouse mouse;
			bool logFPS = true, logObjects = true;
		public:
			Engine();
			~Engine();
			inline double getDelta() const { return dt; }
			//void loop();
			inline Camera *getCamera() const { return camera; }
		private:
			bool checkVersion();
		protected:
			void handleInput();
			bool fpsDelta();
		};

		class Engine2D : Engine
		{
		private:
			badger::window::Window *window;
			bool running = false;
			//PhysicsEngine physicsEngine;
		public:
			//Loader loader;
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