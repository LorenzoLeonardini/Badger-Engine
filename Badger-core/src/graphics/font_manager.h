#pragma once

#include <vector>
#include "font.h"

namespace badger { namespace graphics {

	/**
		Manage all the Font objects in the game

		@author Lorenzo Leonardini
		@version 08/21/2017
	*/
	class FontManager
	{
	private:
		static std::vector<Font*> m_Fonts;
		static float m_ScaleX, m_ScaleY;
	public:
		/**
			Add a Font object to the manager

			@param font
		*/
		static void add(Font *font);
		/**
			@return the default font
		*/
		static Font* get();
		/**
			@param name the name associated to the font
			@return the font with the specified name and the defaul size
		*/
		static Font* get(const std::string name);
		/**
			@param name the name associated to the font
			@param size the font size
			@return the font with the specified name and size. Generates a new font if a font with that name exists but not with that size
		*/
		static Font* get(const std::string name, unsigned int size);
		/**
			Set the scale for all the fonts in the manager

			@param x scaleX
			@param y scaleY
		*/
		static void setScale(float x, float y);
		static void clean();
	private:
		FontManager() {}
	};

} }