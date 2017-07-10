#include "src/engine/engine.h"

int main(void)
{	
	using namespace badger;
	using namespace engine;

	Engine2D *engine = new Engine2D();
	engine->createWindow(900, 516, "Badger Engine!");
	engine->start();

	/*while (!window.closed())
	{
		window.clear();
		glBegin(GL_TRIANGLES);
		glVertex2f(-.5f, -.5f);
		glVertex2f(0.0f, .5f);
		glVertex2f(.5f, -.5f);
		glEnd();
		window.update();
	}*/

	delete engine;

	return 0;
}