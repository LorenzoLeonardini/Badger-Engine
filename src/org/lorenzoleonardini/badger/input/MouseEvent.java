package org.lorenzoleonardini.badger.input;

import org.lorenzoleonardini.badger.input.Mouse.BUTTON;

/**
 * @author Lorenzo Leonardini
 */
public class MouseEvent
{
	/**
	 * This code will be executed when the mouse enters the window
	 */
	public void onMouseEnter()
	{
		
	}
	
	/**
	 * This code will be executed when the mouse leaves the window
	 */
	public void onMouseLeave()
	{
		
	}
	
	/**
	 * This code will be executed when one of the mouseButton is pressed
	 * @param button
	 *            the button pressed
	 * @param x
	 *            the cursor x position
	 * @param y
	 *            the cursor y position
	 */
	public void onMousePressed(BUTTON button, int x, int y)
	{

	}
	
	/**
	 * This code will be executed when one of the mouseButton is down
	 * @param button
	 *            the button down
	 * @param x
	 *            the cursor x position
	 * @param y
	 *            the cursor y position
	 */
	public void onMouseDown(BUTTON button, int x, int y)
	{

	}

	/**
	 * This code will be executed when one of the mouseButton is released
	 * @param button
	 *            the button released
	 * @param x
	 *            the cursor x position
	 * @param y
	 *            the cursor y position
	 */
	public void onMouseReleased(BUTTON button, int x, int y)
	{

	}

	/**
	 * This code will be executed when one of the mouseButton is clicked
	 * @param button
	 *            the button clicked
	 * @param x
	 *            the cursor x position
	 * @param y
	 *            the cursor y position
	 */
	public void onMouseClicked(BUTTON button, int x, int y)
	{

	}
	
	/**
	 * This code will be executed EVERY frame the mouse is in the screen
	 * @param x
	 * @param y
	 */
	public void onMouse(int x, int y)
	{
		
	}
}
