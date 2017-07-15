#include "src/engine/engine.h"

int main(void)
{	
	using namespace badger;
	using namespace engine;
	using namespace graphics;

	Engine2D *engine = new Engine2D();
	engine->createWindow(900, 516, "Badger Engine!");
	engine->start();

	delete engine;

	return 0;
}