//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.net.URL;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Alien extends MovingThing
{
  private int speed;
  private boolean shot;
  private Image image;

  public Alien()
  {
    this(0,0,30,30,0);
  }

  public Alien(int x, int y)
  {
    super(x,y);
  }

  public Alien(int x, int y, int s)
  {
    super(x,y);
    speed = s;
  }

  public Alien(int x, int y, int w, int h, int s)
  {
    super(x, y, w,h);
    speed=s;
    try
    {
      URL url = getClass().getResource("alien.jpg");
      image = ImageIO.read(url);
    }
    catch(Exception e)
    {
    	System.out.println("Could not find image.");
    }
  }

  public void setSpeed(int s)
  {
    speed = s;
  }

  public int getSpeed()
  {
    return speed;
  }
  
  public void setShot(boolean b)
  {
	  shot = b;
  }
  
  public boolean getShot()
  {
	  return shot;
  }
  
  public boolean outOfBounds(int x, int y)
  {
	  if(getX()+getWidth() < 0  || getX() > x || getY()+getHeight() < 0 || getY() > y)
	  {
		  return true;
	  }
	  return false;
  }

  public void move(String direction)
  {
	  if(outOfBounds(800,600))
	  {
		  setY(getY() + 100);
		  setSpeed(-1*getSpeed());
	  }
	  direction.toUpperCase();
	    if(direction.equals("LEFT"))
	    {
	    	setX(getX() - speed);
	    }
	    
	    else if(direction.equals("RIGHT"))
	    {
	    	setX(getX() + speed);
	    }
  }

  public void draw( Graphics window )
  {
    window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
  }

  public String toString()
  {
    return super.toString() + getSpeed();
  }
}
