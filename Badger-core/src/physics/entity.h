#pragma once

#include "../graphics/renderable2d.h"
#include "../maths/maths.h"
#include "hitbox.h"

namespace badger { namespace physics {

	using namespace maths;
	using namespace graphics;

	class PhysicsEngine;
	class Hitbox;

	class Entity
	{
	friend PhysicsEngine;
	public:
		vec3 &position;
		Hitbox *hitbox;
	private:
		Renderable2D *m_Renderable;
		bool m_Unmovable = false;
		bool m_AffectedByGravity = true;
		bool m_IsOnGround = false;

#ifdef _DEBUG_ENGINE
		bool m_KillWhenOutOfBounds = true;
#endif

		bool m_Flip = false;
		vec2 m_Velocity = vec2(0, 0);
		vec2 m_Acceleration = vec2(0, 0);

		double m_Lifespan = -1;
		double m_Life = 0;

	public:
		Entity(float x, float y, Renderable2D *renderable);
		~Entity();

		void update(double delta);
		void applyForce(const vec2 &force);
		void applyForce(const vec3 &force);

		inline void flip() { m_Flip = !m_Flip; }
		void setPosition(vec2 &pos);

		inline void setUnmovable(bool unmovable) { m_Unmovable = unmovable; }
		inline bool isUnmovable() const { return m_Unmovable; }
		inline void setAffectedByGravity(bool affectedByGravity) { m_AffectedByGravity = affectedByGravity; }
		inline bool isAffectedByGravity() const { return m_AffectedByGravity; }

#ifdef _DEBUG_ENGINE
		inline void setKillWhenOutOfBounds(bool killWhenOutOfBounds) { m_KillWhenOutOfBounds = killWhenOutOfBounds; }
		inline bool killWhenOutOfBounds() const { return m_KillWhenOutOfBounds; }
#endif

		inline void kill() { m_Life = -1; }
		inline void setLifespan(double lifespan) { m_Lifespan = lifespan; }
		inline bool toBeKilled() const { return m_Life == -1 || (m_Lifespan != -1 && m_Life >= m_Lifespan); }

		inline Renderable2D *getSprite() const { return m_Renderable; }
	};

} }