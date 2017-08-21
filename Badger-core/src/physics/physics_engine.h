#pragma once

#include <vector>
#include "entity.h"

namespace badger { namespace physics {

	class PhysicsEngine
	{
		friend Entity;
	private:
		static std::vector<Entity*> ENTITY_LIST;
		std::vector<Entity*> m_ToRemove;

	private:
		vec2 m_Gravity = vec2(0, -40);
	public:
		/**
			Update the PhysicsEngine:

			- update each entity
			- check collisions
			- call collision callbacks
		*/
		void update(double delta);
	};

} }