package org.lorenzoleonardini.badger.assets;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * The Loader class is responsible of loading and handling all the assets used
 * in the game engine
 * 
 * @author Lorenzo Leonardini
 * 
 */

public class Loader
{
	private BufferedImage in;

	public Loader()
	{
		in = null;
	}

	public Texture loadTexture(File file)
	{
		try
		{
			in = ImageIO.read(file);
		}
		catch (IOException e)
		{
			System.err.println("ERROR > Error while loading texture " + file.getAbsolutePath());
			e.printStackTrace();
			System.exit(1);
		}

		return new Texture(in);
	}

	public Texture loadTexture(String path)
	{
		return loadTexture(new File(path));
	}
}
