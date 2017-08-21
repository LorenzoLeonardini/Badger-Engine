#pragma once

#include <string>
#include "../maths/maths.h"
#include "../../ext/freetype-gl/freetype-gl.h"

namespace badger { namespace graphics {

	/**
		Font object used to render strings

		@author Lorenzo Leonardini
		@version 08/21/2017
	*/
	class Font
	{
	private:
		ftgl::texture_atlas_t *m_FTAtlas;
		ftgl::texture_font_t *m_FTFont;
		unsigned int m_Size;
		maths::vec2 m_Scale;
		std::string m_Name;
		std::string m_Filename;
	public:
		/**
			Create a font

			@param name the name associated to the font
			@param filename the ttf file path
			@param size the size of the font
		*/
		Font(std::string name, std::string filename, unsigned int size);

		/**
			Method used to set scale. The scale is used to adjust the font size
			based on the projection matrix.
		*/
		void setScale(float x, float y);

		/**
			Get the FTFont object

			@return FTFfont
		*/
		inline ftgl::texture_font_t *getFTFont() const { return m_FTFont; }

		inline const std::string &getName() const { return m_Name; }
		inline const maths::vec2 &getScale() const { return m_Scale; }
		inline const std::string &getFileName() const { return m_Filename; }
		inline const unsigned int getSize() const { return m_Size; }
		inline const unsigned int getID() const { return m_FTAtlas->id; }
	};

} }