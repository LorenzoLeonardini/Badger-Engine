#include "hitbox.h"

namespace badger { namespace physics {

	std::vector<CircleHitbox*> CircleHitbox::CIRCLE_HITBOXES;

	CircleHitbox::CircleHitbox(maths::vec2 position, float radius)
		: m_Position(position), m_Radius(radius)
	{

	}
	
	CircleHitbox::~CircleHitbox()
	{
		CIRCLE_HITBOXES.erase(CIRCLE_HITBOXES.begin() + m_Index);
	}


	Hitbox::Hitbox(Entity *entity)
		: m_Entity(entity)
	{

	}

	Hitbox::~Hitbox()
	{
		for (int i = 0; i < m_CircleHitboxes.size(); i++)
			delete m_CircleHitboxes[i];
		for (int i = 0; i < m_RectHitboxes.size(); i++)
			delete m_RectHitboxes[i];
		m_CircleHitboxes.clear();
		m_RectHitboxes.clear();
	}

	void Hitbox::addHitbox(CircleHitbox *hitbox)
	{
		m_CircleHitboxes.push_back(hitbox);
		hitbox->m_Index = CircleHitbox::CIRCLE_HITBOXES.size();
		CircleHitbox::CIRCLE_HITBOXES.push_back(hitbox);
	}

	void Hitbox::addHitbox(RectHitbox *hitbox)
	{
		m_RectHitboxes.push_back(hitbox);
	}

	void CircleHitbox::circleCircleCollision()
	{
		std::cout << "HITBOXES:" << std::endl;

		for (int i = 0; i < CIRCLE_HITBOXES.size(); i++)
			std::cout << "\t" << CIRCLE_HITBOXES[i]->m_Position << std::endl;
	}

} }