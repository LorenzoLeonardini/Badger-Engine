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
		void update(double delta);
	};

} }