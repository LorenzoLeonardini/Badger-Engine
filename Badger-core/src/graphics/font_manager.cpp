#include "font_manager.h"

namespace badger { namespace graphics {

	std::vector<Font*> FontManager::m_Fonts;
	float FontManager::m_ScaleX;
	float FontManager::m_ScaleY;

	void FontManager::add(Font *font)
	{
		font->setScale(m_ScaleX, m_ScaleY);
		m_Fonts.push_back(font);
	}

	Font* FontManager::get()
	{
		return m_Fonts[0];
	}

	Font* FontManager::get(const std::string name)
	{
		for (Font *font : m_Fonts)
			if (font->getName() == name)
				return font;

		return m_Fonts[0];
	}

	Font* FontManager::get(const std::string name, unsigned int size)
	{
		// Try to get font
		for (Font *font : m_Fonts)
			if (font->getSize() == size && font->getName() == name)
				return font;

		// Try to generate with specifyied size
		for(Font *font : m_Fonts)
			if (font->getName() == name)
			{
				Font *f = new Font(name, font->getFileName(), size);
				FontManager::add(f);
				return f;
			}

		// Try to find font file and generate
		Font *f = new Font(name, name + ".ttf", size);
		if (f->getFTFont())
		{
			std::cout << "[FONT] Loaded " + f->getName() << " file " << f->getFileName() << std::endl;
			FontManager::add(f);
			return f;
		}

		return m_Fonts[0];
	}

	void FontManager::setScale(float x, float y)
	{
		for (Font *font : m_Fonts)
			font->setScale(x, y);

		m_ScaleX = x;
		m_ScaleY = y;
	}

	void FontManager::clean()
	{
		for (int i = 0; i < m_Fonts.size(); i++)
			delete m_Fonts[i];
	}

} }