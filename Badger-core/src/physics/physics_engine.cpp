#include "physics_engine.h"

namespace badger { namespace physics {

	std::vector<Entity*> PhysicsEngine::ENTITY_LIST;

	void PhysicsEngine::update(double delta)
	{
		if (ENTITY_LIST.size() == 0)
			return;
		
		for (int i = 0; i < ENTITY_LIST.size(); i++)
		{
			Entity *e = ENTITY_LIST[i];

			if (e->isAffectedByGravity() && !e->isUnmovable())
				e->applyForce(m_Gravity);

			e->update(delta);

			if (e->toBeKilled() || (e->killWhenOutOfBounds() && e->m_Renderable->getPosition().y < -260 - e->m_Renderable->getSize().y))
			{
				//TODO : DELETE
				//delete ENTITY_LIST[i];
				delete e;
				ENTITY_LIST.erase(ENTITY_LIST.begin() + i);
			}
		}

		CircleHitbox::circleCircleCollision();

		//TODO: collision
		//for (int i = 0; i < ENTITY_LIST.size(); i++)
		//{
		//	Entity *e = ENTITY_LIST[i];
		//}
	}

} }