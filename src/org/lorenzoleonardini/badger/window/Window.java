package org.lorenzoleonardini.badger.window;

import static org.lwjgl.glfw.GLFW.GLFW_CONTEXT_VERSION_MAJOR;
import static org.lwjgl.glfw.GLFW.GLFW_CONTEXT_VERSION_MINOR;
import static org.lwjgl.glfw.GLFW.GLFW_OPENGL_CORE_PROFILE;
import static org.lwjgl.glfw.GLFW.GLFW_OPENGL_FORWARD_COMPAT;
import static org.lwjgl.glfw.GLFW.GLFW_OPENGL_PROFILE;
import static org.lwjgl.glfw.GLFW.GLFW_SAMPLES;
import static org.lwjgl.glfw.GLFW.GLFW_TRUE;
import static org.lwjgl.glfw.GLFW.glfwCreateWindow;
import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.glfw.GLFW.glfwMakeContextCurrent;
import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.glfw.GLFW.glfwTerminate;
import static org.lwjgl.glfw.GLFW.glfwWindowHint;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;
import static org.lwjgl.opengl.GL.createCapabilities;
import static org.lwjgl.system.MemoryUtil.NULL;

import java.awt.Image;
import java.util.List;

import org.lorenzoleonardini.badger.Camera;
import org.lorenzoleonardini.badger.renderer.Screen;

/**
 * @author Lorenzo Leonardini
 */
public class Window
{
	public final int WIDTH, HEIGHT;

	private Screen screen;

	public Window(int width, int height, String title)
	{
		WIDTH = width;
		HEIGHT = height;
		
		if(!glfwInit())
		{
			System.err.println("Unable to initialize GLFW");
			System.exit(-1);
		}
		
		// Set 4x antialiasing
		glfwWindowHint(GLFW_SAMPLES, 4);
		// Set OpenGL 3.3
		glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
		glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 3);
		// "To make MacOS happy, should not be needed"
		glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GLFW_TRUE);
		// Don't want old OpenGL
		glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
		
		// Open a window and create its OpenGL context
		long window = glfwCreateWindow(width, height, title, NULL, NULL);
		if(window == NULL)
		{
			System.err.println("Failed to open GLFW window");
			glfwTerminate();
			System.exit(-1);
		}
		glfwMakeContextCurrent(window);
		
		// Seems to be needed to let OpenGL and GLFW interact
		createCapabilities();
		
		while(!glfwWindowShouldClose(window))
		{
			glfwSwapBuffers(window);
			glfwPollEvents();
		}
	}
	
	public void setIconImages(List<Image> imgs)
	{
	}

	public void render(Camera camera)
	{
//		screen.render(camera);
	}
}
