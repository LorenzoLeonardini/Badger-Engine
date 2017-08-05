#pragma once

#include <vector>

#ifdef BADGER_EMSCRIPTEN
	#define GLFW_INCLUDE_ES3
	#include <GLFW/glfw3.h>
#else
	#include <GL/glew.h>
#endif

#include "buffer.h"

namespace badger {
	namespace graphics {

		class VertexArray
		{
		private:
			GLuint m_ArrayID;
			std::vector<Buffer*> m_Buffers;
		public:
			VertexArray();
			~VertexArray();

			void addBuffer(Buffer *buffer, GLuint index);
			void bind() const;
			void unbind() const;
		};

	}
}