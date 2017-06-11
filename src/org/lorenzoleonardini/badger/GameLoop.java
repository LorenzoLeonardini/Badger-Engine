package org.lorenzoleonardini.badger;

/**
 * This interface is used to set what the engine must do every loop cycle
 * @author Lorenzo Leonardini
 *
 */
public interface GameLoop
{
	public void start();
	
	public void run();
	
	public void stop();
}
