//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.net.URL;
import java.util.List;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Ship extends MovingThing
{
  private int speed;
  private Image image;

  public Ship()
  {
    this(10,10,10,10,10);
  }

  public Ship(int x, int y)
  {
    this(x,y,10,10,10);
  }

  public Ship(int x, int y, int s)
  {
	  this(x,y,10,10,s);
  }

  public Ship(int x, int y, int w, int h, int s)
  {
    super(x, y, w, h);
    speed=s;
    try
    {
      URL url = getClass().getResource("ship.jpg");
      image = ImageIO.read(url);
    }
    catch(Exception e)
    {
    	System.out.println("Could not find image.");
    }
  }

  public void stop()
  {
	  setSpeed(0);
  }

  public void setSpeed(int s)
  {
    speed = s;
  }

  public int getSpeed()
  {
    return speed;
  }

  public void move(String direction)
  {
    direction.toUpperCase();
    if(direction.equals("LEFT"))
    {
    	setX(getX() - speed);
    }
    
    else if(direction.equals("RIGHT"))
    {
    	setX(getX() + speed);
    }
    
    else if(direction.equals("UP"))
    {
    	setY(getY() - speed);
    }
    
    else if(direction.equals("DOWN"))
    {
    	setY(getY() + speed);
    }
  }
  
  public boolean hit(List<Ammo> shots)
  {
	  for(int j = shots.size() - 1; j >= 0; j--)
	  {
		  if(shots.get(j).didCollideDown(this) && shots.get(j).getSpeed()>0)
		  {
			  shots.remove(j);
			  return true;
		  }
	  }  
	  return false;
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
