#pragma once

#include "../renderable2d.h"

namespace badger { namespace graphics {

	/**
		Group Renderable2D to push and pop matrix

		@author Yan Chernikov
		@version 04/11/2015
	*/
	class Group : public Renderable2D
	{
	private:
		std::vector<Renderable2D*> m_Renderables;
		maths::mat4 m_TransformationMatrix;
	public:
		/**
			Create a group with a transformation matrix

			@param transform the matrix
		*/
		Group(const maths::mat4 &transform);
		~Group();
		/**
			Add a Renderable2D to the group

			@param renderable
		*/
		void add(Renderable2D *renderable);
		/**
			Submit the group to a renderer

			@param renderer
		*/
		void submit(Renderer2D *renderer) const override;
	};

} }