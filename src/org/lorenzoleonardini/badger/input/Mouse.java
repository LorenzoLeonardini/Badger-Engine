package org.lorenzoleonardini.badger.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.List;

import org.lorenzoleonardini.badger.Engine;
import org.lorenzoleonardini.badger.physics.ObjectManager;
import org.lorenzoleonardini.badger.physics.PhysicsObject;

/**
 * The Mouse class manages all the input from the user's mouse
 * 
 * @author Lorenzo Leonardini
 */
public class Mouse implements MouseListener, MouseMotionListener, MouseWheelListener
{
	private boolean onScreen = false;
	private List<BUTTON> pressed = new ArrayList<BUTTON>();
	private int x, y;

	private Engine engine;

	public static enum BUTTON
	{
		LEFT, WHEEL, RIGHT
	}
	
	public static enum WHEEL
	{
		UP, DOWN
	}

	public Mouse(Engine engine)
	{
		this.engine = engine;
	}

	public void update()
	{
		List<PhysicsObject> objs = new ArrayList<PhysicsObject>(ObjectManager.getObjects());
		for (PhysicsObject o : objs)
			for (org.lorenzoleonardini.badger.input.MouseEvent evt : o.mouseEvents)
				for (BUTTON b : pressed)
					evt.onMouseDown(b, x, y);

		for (org.lorenzoleonardini.badger.input.MouseEvent evt : engine.mouseEvents)
			for (BUTTON b : pressed)
				evt.onMouseDown(b, x, y);

		if (onScreen)
		{
			for (PhysicsObject o : objs)
				for (org.lorenzoleonardini.badger.input.MouseEvent evt : o.mouseEvents)
					evt.onMouse(x, y);

			for (org.lorenzoleonardini.badger.input.MouseEvent evt : engine.mouseEvents)
				evt.onMouse(x, y);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		switch (e.getButton())
		{
		case MouseEvent.BUTTON1:
			clicked(BUTTON.LEFT, e.getX(), e.getY());
			break;
		case MouseEvent.BUTTON2:
			clicked(BUTTON.WHEEL, e.getX(), e.getY());
			break;
		case MouseEvent.BUTTON3:
			clicked(BUTTON.RIGHT, e.getX(), e.getY());
			break;
		default:
			break;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		onScreen = true;

		List<PhysicsObject> objs = new ArrayList<PhysicsObject>(ObjectManager.getObjects());
		for (PhysicsObject o : objs)
			for (org.lorenzoleonardini.badger.input.MouseEvent evt : o.mouseEvents)
				evt.onMouseEnterWindow();

		for (org.lorenzoleonardini.badger.input.MouseEvent evt : engine.mouseEvents)
			evt.onMouseEnterWindow();
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		onScreen = false;

		List<PhysicsObject> objs = new ArrayList<PhysicsObject>(ObjectManager.getObjects());
		for (PhysicsObject o : objs)
			for (org.lorenzoleonardini.badger.input.MouseEvent evt : o.mouseEvents)
				evt.onMouseLeaveWindow();

		for (org.lorenzoleonardini.badger.input.MouseEvent evt : engine.mouseEvents)
			evt.onMouseLeaveWindow();
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		switch (e.getButton())
		{
		case MouseEvent.BUTTON1:
			pressed.add(BUTTON.LEFT);
			pressed(BUTTON.LEFT, e.getX(), e.getY());
			break;
		case MouseEvent.BUTTON2:
			pressed.add(BUTTON.WHEEL);
			pressed(BUTTON.WHEEL, e.getX(), e.getY());
			break;
		case MouseEvent.BUTTON3:
			pressed.add(BUTTON.RIGHT);
			pressed(BUTTON.RIGHT, e.getX(), e.getY());
			break;
		default:
			break;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		switch (e.getButton())
		{
		case MouseEvent.BUTTON1:
			pressed.remove(BUTTON.LEFT);
			released(BUTTON.LEFT, e.getX(), e.getY());
			break;
		case MouseEvent.BUTTON2:
			pressed.remove(BUTTON.WHEEL);
			released(BUTTON.WHEEL, e.getX(), e.getY());
			break;
		case MouseEvent.BUTTON3:
			pressed.remove(BUTTON.RIGHT);
			released(BUTTON.RIGHT, e.getX(), e.getY());
			break;
		default:
			break;
		}
	}

	private void released(BUTTON btn, int x, int y)
	{
		List<PhysicsObject> objs = new ArrayList<PhysicsObject>(ObjectManager.getObjects());
		for (PhysicsObject o : objs)
			for (org.lorenzoleonardini.badger.input.MouseEvent evt : o.mouseEvents)
				evt.onMouseReleased(btn, x, y);

		for (org.lorenzoleonardini.badger.input.MouseEvent evt : engine.mouseEvents)
			evt.onMouseReleased(btn, x, y);
	}

	private void pressed(BUTTON btn, int x, int y)
	{
		List<PhysicsObject> objs = new ArrayList<PhysicsObject>(ObjectManager.getObjects());
		for (PhysicsObject o : objs)
			for (org.lorenzoleonardini.badger.input.MouseEvent evt : o.mouseEvents)
				evt.onMousePressed(btn, x, y);

		for (org.lorenzoleonardini.badger.input.MouseEvent evt : engine.mouseEvents)
			evt.onMousePressed(btn, x, y);
	}

	private void clicked(BUTTON btn, int x, int y)
	{
		List<PhysicsObject> objs = new ArrayList<PhysicsObject>(ObjectManager.getObjects());
		for (PhysicsObject o : objs)
			for (org.lorenzoleonardini.badger.input.MouseEvent evt : o.mouseEvents)
				evt.onMouseClicked(btn, x, y);

		for (org.lorenzoleonardini.badger.input.MouseEvent evt : engine.mouseEvents)
			evt.onMouseClicked(btn, x, y);
	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		List<PhysicsObject> objs = new ArrayList<PhysicsObject>(ObjectManager.getObjects());
		for (PhysicsObject o : objs)
			for (org.lorenzoleonardini.badger.input.MouseEvent evt : o.mouseEvents)
				evt.onMouseDragged(x, y);

		for (org.lorenzoleonardini.badger.input.MouseEvent evt : engine.mouseEvents)
			evt.onMouseDragged(x, y);
	}
	
	@Override
	public void mouseMoved(MouseEvent e)
	{
		x = e.getX();
		y = e.getY();
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e)
	{
		List<PhysicsObject> objs = new ArrayList<PhysicsObject>(ObjectManager.getObjects());
		for (PhysicsObject o : objs)
			for (org.lorenzoleonardini.badger.input.MouseEvent evt : o.mouseEvents)
				evt.onWheelTurn(e.getWheelRotation() == -1 ? WHEEL.UP : WHEEL.DOWN);

		for (org.lorenzoleonardini.badger.input.MouseEvent evt : engine.mouseEvents)
			evt.onWheelTurn(e.getWheelRotation() == -1 ? WHEEL.UP : WHEEL.DOWN);
	}
}
