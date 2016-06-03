package AnimalGame;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Pie extends MovingThing
{
	private int speed;
	private Image image;

	public Pie()
	{
		this(0,0,0);
	}

	public Pie(int x, int y)
	{
		this(x,y,0);
	}

	public Pie(int x, int y, int s)
	{
		super(x, y);
		speed=s;
		try
		{
			image = ImageIO.read(new File("src/AnimalGame/pie.png"));
		}
		catch(Exception e)
		{
			//feel free to do something here
		}
	}

	public void setSpeed(int s)
	{
		speed=s;
	}

	public int getSpeed()
	{
	   return speed;
	}

	public void draw( Graphics window )
	{
   	window.drawImage(image,getX(),getY(),80,80,null);
	}

	public String toString()
	{
		return "";
	}
}
