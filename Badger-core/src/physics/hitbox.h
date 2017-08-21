#pragma once

#include "../maths/maths.h"
#include <vector>

namespace badger { namespace physics {

	class Entity;
	class Hitbox;
	class RectHitbox;

	/**
		Circular hitbox

		@author Lorenzo Leonardini
		@version 08/21/2017
	*/
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
		/**
			Create CircleHitbox

			@param position vec2 position relative to the Entity position (from -1 to 1 in each direction)
			@param radius circle radius
		*/
		CircleHitbox(maths::vec2 position, float radius);
		~CircleHitbox();
		
		static void circleCircleCollision();
	};

	/**
		Rectangular hitbox

		@author Lorenzo Leonardini
		@version 08/21/2017
	*/
	class RectHitbox
	{
	private:
		maths::vec2 m_Position;
		maths::vec2 m_Scale;
	};

	/**
		Hitbox for each Entity

		@author Lorenzo Leonardini
		@version 08/21/2017
	*/
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