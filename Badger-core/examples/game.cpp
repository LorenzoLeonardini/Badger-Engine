#include "../src/badger.h"

using namespace badger;
using namespace graphics;
using namespace input;
using namespace physics;

class Game : public Badger
{
private:
	Window *window;
	Layer *layer;
	Label *fps;
	Entity *e;
	Shader *shader;
	Sprite *s;
public:
	Game()
	{

	}

	~Game()
	{
		delete layer;
	}

	void init() override
	{
		window = createWindow(960, 540, "Test Game");

		FontManager::setScale(window->getWidth() / 900, window->getHeight() / 516);
		
#ifdef BADGER_EMSCRIPTEN
		shader = new Shader("res/shaders/verybasic.es3.vert", "res/shaders/verybasic.es3.frag");
#else
		shader = new Shader("src/shaders/verybasic.vert", "src/shaders/verybasic.frag");
#endif

		layer = new Layer(new BatchRenderer2D(), shader, maths::mat4::orthographic(-450, 450, -258, 258, -1, 1));

#ifdef BADGER_EMSCRIPTEN
		s = new Sprite(50, 50, new Texture("res/test3.png"));
		e = new Entity(0, 0, s);
		e->applyForce(maths::randomVec2(1000));
#else
		s = new Sprite(50, 50, new Texture("test3.png"));
		e = new Entity(0, 0, s);
		e->applyForce(maths::randomVec2(1000));
		e->hitbox->addHitbox(new CircleHitbox(maths::vec2(1, 1), 1));
#endif

		layer->add(e->getSprite());

		fps = new Label("", -440, 230, "cour", 25, 0xffffffff);
		layer->add(fps);
	}

	void tick() override
	{
		fps->text = std::to_string(getFPS()) + " fps";
		std::cout << getUPS() << " ups, " << getFPS() << " fps" << std::endl;
	}

	void update() override
	{
		float speed = 0.5f;
		if (keyboard->pressed(GLFW_KEY_W))
			e->position.y += speed;
		if (keyboard->pressed(GLFW_KEY_S))
			e->position.y -= speed;
		if (keyboard->pressed(GLFW_KEY_A))
			e->position.x -= speed;
		if (keyboard->pressed(GLFW_KEY_D))
			e->position.x += speed;

		if (rand() % 100 < 5)
		{
			Entity *temp = new Entity(0, 0, new Sprite(*s));
			temp->applyForce(maths::randomVec2(1000));
			layer->add(temp->getSprite());
		}

		double x, y;
		mouse->getMousePosition(x, y);
		shader->setUniform2f("light_pos", maths::vec2((float)(x * 900 / window->getWidth() - 450), (float)(258 - y * 516 / window->getHeight())));
	}

	void render() override
	{
		layer->render();
	}
};

int main()
{
	Game game;
	game.start();
	return 0;
}