#include "../src/badger.h"

using namespace badger;
using namespace graphics;
using namespace input;

class Game : public Badger
{
private:
	Window *window;
	Layer *layer;
	Label *fps;
	Sprite *sprite;
	Shader *shader;
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
		FontManager::get()->setScale(window->getWidth() / 32, window->getHeight() / 18);
		
#ifdef BADGER_EMSCRIPTEN
		shader = new Shader("res/shaders/basic.es3.vert", "res/shaders/basic.es3.frag");
#else
		shader = new Shader("src/shaders/basic.vert", "src/shaders/basic.frag");
#endif

		layer = new Layer(new BatchRenderer2D(), shader, maths::mat4::orthographic(-16, 16, -9, 9, -1, 1));

#ifdef BADGER_EMSCRIPTEN
		sprite = new Sprite(0, 0, 4, 4, new Texture("res/test3.png"));
#else
		sprite = new Sprite(0, 0, 4, 4, new Texture("test3.png"));
#endif

		layer->add(sprite);

		fps = new Label("", -15.5f, 7.8f, "arial", 0xffffffff);
		layer->add(fps);
	}

	void tick() override
	{
		fps->text = std::to_string(getFPS()) + " FPS";
		std::cout << getUPS() << " ups, " << getFPS() << " fps" << std::endl;
	}

	void update() override
	{
		float speed = 0.5f;
		if (keyboard->pressed(GLFW_KEY_W))
			sprite->position.y += speed;
		if (keyboard->pressed(GLFW_KEY_S))
			sprite->position.y -= speed;
		if (keyboard->pressed(GLFW_KEY_A))
			sprite->position.x -= speed;
		if (keyboard->pressed(GLFW_KEY_D))
			sprite->position.x += speed;

		double x, y;
		mouse->getMousePosition(x, y);
		shader->setUniform2f("light_pos", maths::vec2((float)(x * 32 / window->getWidth() - 16), (float)(9 - y * 18 / window->getHeight())));
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