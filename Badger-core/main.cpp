#include "src/graphics/window.h"

int main(void)
{	
	using namespace badger;
	using namespace graphics;

	Window window("Badger Engine!", 800, 600);
	glClearColor(0.2f, 0.3f, 0.7f, 1.0f);

	while (!window.closed())
	{
		window.clear();
		glBegin(GL_TRIANGLES);
		glVertex2f(-.5f, -.5f);
		glVertex2f(0.0f, .5f);
		glVertex2f(.5f, -.5f);
		glEnd();
		window.update();
	}

	return 0;
}