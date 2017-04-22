package org.lorenzoleonardini.badger.assets;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

/**
 * The Texture class contains all the data and the information about a texture in the game
 * 
 * @author Lorenzo Leonardini
 *
 */
public class Texture
{
	private int width, height;
	protected BufferedImage img;
	public int[] pixels;
	
	public Texture(BufferedImage in)
	{
		img = new BufferedImage(in.getWidth(), in.getHeight(), BufferedImage.TYPE_INT_RGB);
		
		Graphics2D g = img.createGraphics();
		g.drawImage(in, 0, 0, in.getWidth(), in.getHeight(), null);
		g.dispose();
		pixels = ((DataBufferInt) img.getRaster().getDataBuffer()).getData();
		
		width = in.getWidth();
		height = in.getHeight();
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
}
