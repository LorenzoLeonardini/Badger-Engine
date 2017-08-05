#include "label.h"

namespace badger { namespace graphics {

	Label::Label(std::string text, float x, float y, Font *font, unsigned int color)
		: Renderable2D(), text(text), m_Font(font), position(m_Position)
	{
		m_Position = maths::vec3(x, y, 0);
		m_Color = color;
	}

	Label::Label(std::string text, float x, float y, const std::string &font, unsigned int color)
		: Renderable2D(), text(text), m_Font(FontManager::get(font)), position(m_Position)
	{
		m_Position = maths::vec3(x, y, 0);
		m_Color = color;

		validateFont(font);
	}

	Label::Label(std::string text, float x, float y, const std::string &font, unsigned int size, unsigned int color)
		: Renderable2D(), text(text), m_Font(FontManager::get(font, size)), position(m_Position)
	{
		m_Position = maths::vec3(x, y, 0);
		m_Color = color;

		validateFont(font, size);
	}

	void Label::submit(Renderer2D *renderer) const
	{
		renderer->drawString(text, position, *m_Font, m_Color);
	}

	void Label::validateFont(const std::string &name, unsigned int size)
	{
		if (m_Font)
			return;

		std::cout << "NULL FONT! Font=" << name;
		if (size > 0)
			std::cout << ", Size=" << size;
		std::cout << std::endl;

		m_Font = FontManager::get("arial");
	}

} }