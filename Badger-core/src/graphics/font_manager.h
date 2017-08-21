#pragma once

#include <vector>
#include "font.h"

namespace badger { namespace graphics {

	class FontManager
	{
	private:
		static std::vector<Font*> m_Fonts;
		static float m_ScaleX, m_ScaleY;
	public:
		static void add(Font *font);
		static Font* get();
		static Font* get(const std::string name);
		static Font* get(const std::string name, unsigned int size);
		static void setScale(float x, float y);
		static void clean();
	private:
		FontManager() {}
	};

} }