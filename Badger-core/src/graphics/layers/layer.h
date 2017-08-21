#pragma once

#include "../renderer2d.h"
#include "../renderable2d.h"

namespace badger { namespace graphics {

	/**
		The layer class has its own renderer and shader program.

		Use different layers to render different things: 3D scene, 2D scene, UI, text...

		@author Yan Chernikov
		@version 03/11/2015
	*/
	class Layer
	{
	protected:
		Renderer2D* m_Renderer;
		std::vector<Renderable2D*> m_Renderables;
		Shader *m_Shader;
		maths::mat4 m_ProjectionMatrix;
	public:
		/**
			Create a layer

			@param renderer the renderer its going to use
			@param shader the shader object containing the OpenGL shader program the renderer will use
			@param projectionMatrix the projection matrix used in the rendering process
		*/
		Layer(Renderer2D *renderer, Shader *shader, maths::mat4 projectionMatrix);
		virtual ~Layer();
		/**
			Add a Renderable2D to this layer. When a renderable is added it will be rendered during the rendering process

			@param renderable
		*/
		virtual void add(Renderable2D *renderable);
		/**
			Render all the renderables in this layer
		*/
		virtual void render();

		inline const std::vector<Renderable2D*> &getRenderables() const { return m_Renderables; }
	};

} }