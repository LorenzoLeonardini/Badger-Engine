#include "font.h"

namespace badger { namespace graphics {

	Font::Font(std::string name, std::string filename, unsigned int size)
		: m_Name(name), m_Filename(filename), m_Size(size)
	{
		m_FTAtlas = ftgl::texture_atlas_new(512, 512, 2);
		m_FTFont = ftgl::texture_font_new_from_file(m_FTAtlas, size, filename.c_str());
	}

	void Font::setScale(float x, float y)
	{
		m_Scale = maths::vec2(x, y);
	}

} }