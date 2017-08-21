#pragma once

#include "buffers/buffer.h"
#include "buffers/indexbuffer.h"
#include "buffers/vertexarray.h"
#include "../maths/maths.h"
#include "shader.h"
#include "renderer2d.h"
#include "texture.h"

namespace badger {
	namespace graphics {

		class Layer;

		/**
			OpenGL vertex data

			@author Yan Chernikov
			@version 04/11/2015
		*/
		struct VertexData
		{
			maths::vec3 vertex;
			maths::vec2 uv;
			float tid;
			unsigned int color;
		};

		/**
			Abstract structure of a 2D renderable object

			@author Lorenzo Leonardini
			@version 08/21/2017
		*/
		class Renderable2D
		{
			friend Layer;
		public:
			maths::vec3 m_Position;
		protected:
			maths::vec2 m_Size;
			unsigned int m_Color;
			std::vector<maths::vec2> m_UV;
			Texture *m_Texture;
		protected:
			Renderable2D() : m_Texture(nullptr) { setUVDefaults(); }
		public:
			/**
				Create Renderable2D

				@param position vec3 position
				@param size vec2 size
				@param color the object color
			*/
			Renderable2D(maths::vec3 position, maths::vec2 size, unsigned int color)
				: m_Position(position), m_Size(size), m_Color(color), m_Texture(nullptr)
			{
				setUVDefaults();
			}
			
			virtual ~Renderable2D()	{}

			/**
				Submit the Renderable2D object to a Renderer2D

				@param renderer the renderer
			*/
			virtual void submit(Renderer2D *renderer) const
			{
				renderer->submit(this);
			}

			/**
				Change the color

				@param color new color
			*/
			void setColor(unsigned int color) { m_Color = color; }
			/**
				Change the color

				@param color new color (vec4)
			*/
			void setColor(const maths::vec4 &color)
			{
				int r = color.x * 255.0f;
				int g = color.y * 255.0f;
				int b = color.z * 255.0f;
				int a = color.w * 255.0f;

				m_Color = a << 24 | b << 16 | g << 8 | r;
			}

			inline const maths::vec3 &getPosition() const { return m_Position; }
			inline const maths::vec2 &getSize() const { return m_Size; }
			inline const unsigned int getColor() const { return m_Color; }
			inline const std::vector<maths::vec2> &getUV() const { return m_UV; }

			inline const GLuint getTID() const { return m_Texture ? m_Texture->getID() : 0; }
		private:
			void setUVDefaults()
			{
				m_UV.push_back(maths::vec2(0, 0));
				m_UV.push_back(maths::vec2(0, 1));
				m_UV.push_back(maths::vec2(1, 1));
				m_UV.push_back(maths::vec2(1, 0));
			}
		};

	}
}