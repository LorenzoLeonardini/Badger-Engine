#pragma once

#ifdef BADGER_EMSCRIPTEN
	#define GLFW_INCLUDE_ES3
	#include <GLFW/glfw3.h>
#else
	#include <GL/glew.h>
#endif

#include "../utils/imageload.h"

namespace badger { namespace graphics {

	/**
		Texture element of a Sprite

		@author Yan Chernikov
		@version 04/16/2015
	*/
	class Texture
	{
	private:
		std::string m_FileName;
		GLuint m_TID;
		GLsizei m_Width, m_Height;
	public:
		/**
			Create a Texture

			@param filename path to the image file
		*/
		Texture(const std::string &filename);
		~Texture();
		void bind() const;
		void unbind() const;

		inline const unsigned int getID() const { return m_TID; }
		inline const unsigned int getWidth() const { return m_Width; }
		inline const unsigned int getHeight() const { return m_Height; }
	private:
		GLuint load();
	};

} }