#include "entity.h"

#include "physicsengine.h"

namespace badger { namespace physics {

	Entity::Entity(float x, float y, Renderable2D *renderable)
		: m_Renderable(renderable), position(renderable->m_Position)
	{
		m_Renderable->m_Position = vec3(x, y, 0);
		PhysicsEngine::ENTITY_LIST.push_back(this);
		hitbox = new Hitbox(this);
	}

	Entity::~Entity()
	{
		std::cout << "DELETED ENTITY" << std::endl;
		delete hitbox;
		//delete m_Renderable;
	}

	void Entity::update(double delta)
	{
		m_Velocity.x += m_Acceleration.x * delta;
		m_Velocity.y += m_Acceleration.y * delta;

		position += vec3(m_Velocity.x, m_Velocity.y, 0);

		m_Acceleration.x = 0;
		m_Acceleration.y = 0;

		m_Life += delta;
	}

	void Entity::applyForce(const vec2 &force)
	{
		m_Acceleration.x += force.x;
		m_Acceleration.y += force.y;
	}

	void Entity::applyForce(const vec3 &force)
	{
		m_Acceleration.x += force.x;
		m_Acceleration.y += force.y;
	}

	void Entity::setPosition(vec2 &pos)
	{
		m_Renderable->m_Position = vec3(pos.x, pos.y, 0);
	}

} }