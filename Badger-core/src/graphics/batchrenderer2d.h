#pragma once

#include <cstddef>
#include "renderer2d.h"
#include "renderable2d.h"
#include "buffers/indexbuffer.h"

namespace badger { namespace graphics {

#define RENDERER_MAX_SPRITES	60000
#define RENDERER_VERTEX_SIZE	sizeof(VertexData)
#define RENDERER_SPRITE_SIZE	RENDERER_VERTEX_SIZE * 4
#define RENDERER_BUFFER_SIZE	RENDERER_SPRITE_SIZE * RENDERER_MAX_SPRITES
#define RENDERER_INDICES_SIZE	RENDERER_MAX_SPRITES * 6
#define RENDERER_MAX_TEXTURES	32

#define SHADER_VERTEX_INDEX		0
#define SHADER_UV_INDEX			1
#define SHADER_TID_INDEX		2
#define SHADER_COLOR_INDEX		3

	/**
		Optimized 2D renderer

		This 2D renderer uses optimizations to reduce the amount of draw callbacks

		@author Yan Chernikov
		@version 03/12/2015
	*/
	class BatchRenderer2D : public Renderer2D
	{
	private:
		GLuint m_VAO;
		GLuint m_VBO;
		IndexBuffer *m_IBO;
		GLsizei m_IndexCount;
		VertexData *m_Buffer;
#ifdef BADGER_EMSCRIPTEN
		VertexData *m_BufferBase;
#endif

		std::vector<GLuint> m_TextureSlots;
	public:
		BatchRenderer2D();
		~BatchRenderer2D();
		void begin() override;
		/**
			Add a renderable to the drawing list

			@param renderable
		*/
		void submit(const Renderable2D *renderable) override;
		/**
			Draw a string

			@param text the content of the string
			@param position the position of the string
			@param font the Font object used for the string
			@param color the color
		*/
		void drawString(const std::string &text, const maths::vec3 &position, const Font &font, unsigned int color) override;
		void end() override;
		/**
			Render everything
		*/
		void flush() override;
	private:
		void init();
	};

} }