#pragma once

#include "renderable2d.h"

namespace badger { namespace graphics {

	/**
		Renderable2D which can be an image or a colored rectangle

		@author Lorenzo Leonardini
		@version 08/21/2017
	*/
	class Sprite : public Renderable2D
	{
	public:
		maths::vec3 &position;
	public:
		/**
			Create Sprite

			@param x x coordinate
			@param y y coordinate
			@param width width of the Sprite
			@param height height of the Sprite
			@param color the color of the Sprite
		*/
		Sprite(float x, float y, float width, float height, unsigned int color);
		/**
			Create Sprite

			@param x x coordinate
			@param y y coordinate
			@param width width of the Sprite
			@param height height of the Sprite
			@param texture the Texture object of the Sprite
		*/
		Sprite(float x, float y, float width, float height, Texture *texture);

		/**
			Create Sprite
			
			This constructor, without position, is used when the Sprite is part of an Entity, which
			takes care of its own position

			@param width width of the Sprite
			@param height height of the Sprite
			@param color the color of the Sprite
		*/
		Sprite(float width, float height, unsigned int color);
		/**
			Create Sprite

			This constructor, without position, is used when the Sprite is part of an Entity, which
			takes care of its own position

			@param width width of the Sprite
			@param height height of the Sprite
			@param texture the Texture object of the Sprite
		*/
		Sprite(float width, float height, Texture *texture);
	};

} }