#pragma once

#include "../maths/maths.h"
#include <vector>

namespace badger { namespace physics {

	class Entity;
	class Hitbox;
	class RectHitbox;

	class CircleHitbox
	{
	friend Hitbox;
	friend RectHitbox;
	private:
		static std::vector<CircleHitbox*> CIRCLE_HITBOXES;
	private:
		maths::vec2 m_Position;
		float m_Radius;
		int m_Index;
	public:
		CircleHitbox(maths::vec2 position, float radius);
		~CircleHitbox();
		
		static void circleCircleCollision();
	};

	class RectHitbox
	{
	private:
		maths::vec2 m_Position;
		maths::vec2 m_Scale;
	};

	class Hitbox
	{
	friend Entity;
	private:
		Entity *m_Entity;
		std::vector<CircleHitbox*> m_CircleHitboxes;
		std::vector<RectHitbox*> m_RectHitboxes;
	public:
		Hitbox(Entity *entity);
		~Hitbox();

		void addHitbox(CircleHitbox *hitbox);
		void addHitbox(RectHitbox *hitbox);
	};

} }