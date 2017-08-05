#include "font_manager.h"

namespace badger { namespace graphics {

	std::vector<Font*> FontManager::m_Fonts;

	void FontManager::add(Font *font)
	{
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
		//TODO: return default font
		return nullptr;
	}

	Font* FontManager::get(const std::string name, unsigned int size)
	{
		for (Font *font : m_Fonts)
			if (font->getSize() == size && font->getName() == name)
				return font;

		for(Font *font : m_Fonts)
			if (font->getName() == name)
			{
				Font *f = new Font(name, font->getFileName(), size);
				FontManager::add(f);
				return f;
			}
		//TODO: return default font
		return nullptr;
	}

	void FontManager::clean()
	{
		for (int i = 0; i < m_Fonts.size(); i++)
			delete m_Fonts[i];
	}

} }