#include "tilelayer.h"

TileLayer::TileLayer(badger::graphics::Shader *shader)
	: Layer(new badger::graphics::BatchRenderer2D(), shader, badger::maths::mat4::orthographic(-16.0f, 16.0f, -9.0f, 9.0f, -1.0f, 1.0f))
{

}
	
TileLayer::~TileLayer()
{

}
