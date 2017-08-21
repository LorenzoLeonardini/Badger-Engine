#pragma once

#include "renderable2d.h"
#include "font_manager.h"

namespace badger { namespace graphics {

	/**
		Renderable for text

		@author Yan Chernikov
		@version 04/12/2015
	*/
	class Label : public Renderable2D
	{
	public:
		Font *m_Font;
		std::string text;
		maths::vec3 &position;
		float x, y;
	public:
		/**
			Create Label

			@param text the content
			@param x x coordinate
			@param y y coordinate
			@param font the Font object used to render the string
			@param color the text color
		*/
		Label(std::string text, float x, float y, Font *font, unsigned int color);
		/**
			Create Label

			@param text the content
			@param x x coordinate
			@param y y coordinate
			@param font the name associated to the Font object that will be used to render the string
			@param color the text color
		*/
		Label(std::string text, float x, float y, const std::string &font, unsigned int color);
		/**
			Create Label

			@param text the content
			@param x x coordinate
			@param y y coordinate
			@param font the name associated to the Font object that will be used to render the string
			@param size the Font size
			@param color the text color
		*/
		Label(std::string text, float x, float y, const std::string &font, unsigned int size, unsigned int color);
		/**
			Submit the Label to a Renderer2D
		*/
		void submit(Renderer2D *renderer) const override;
	private:
		void validateFont(const std::string &name, unsigned int size = -1);
	};

} }