#pragma once

#include "../engine/camera.h"

namespace badger {
	namespace renderer {

		using namespace engine;

		class Screen
		{
		private:
			int width;
		public:
			Screen(int width, int height);
			void render(Camera *camera);
		};

	}
}