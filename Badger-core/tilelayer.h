#pragma once

#include "src/graphics/layers/layer.h"
#include "src/graphics/batchrenderer2d.h"

class TileLayer : public badger::graphics::Layer
{
public:
	TileLayer(badger::graphics::Shader *shader);
	virtual ~TileLayer();
};
