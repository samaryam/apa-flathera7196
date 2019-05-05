//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Ammo extends MovingThing
{
  private int speed;
  private Color color;

  public Ammo()
  {
    this(0,0,0, Color.GREEN);
    speed = 3;
  }

  public Ammo(int x, int y, int s, Color c)
  {
    super(x,y);
    speed = s;
    color = c;
  }
  
  public void setSpeed(int s)
  {
    speed = s;
  }

  public int getSpeed()
  {
    return speed;
  }

  public void draw( Graphics window )
  {
	  window.setColor(color);
	  window.fillRect(getX(),getY(),getWidth(),getHeight());
  }
  
  public void move()
  {
	  setY(getY() + getSpeed());
  }
  
  public boolean outOfBounds(int x, int y)
  {
	  if(getX()+getWidth() < 0  || getX() > x || getY()+getHeight() < 0 || getY() > y)
	  {
		  return true;
	  }
	  return false;
  }
  
  public boolean didCollideUp(Object o)
  {
	  MovingThing obj = (MovingThing)o;
	  if(getY() >= obj.getY()+obj.getHeight() - 10 && getY() <= obj.getY()+obj.getHeight() && getX() - getWidth() >= obj.getX() && getX() <= obj.getX()+obj.getWidth())
	  {
		  return true;
	  }
	  return false;
  }
  
  public boolean didCollideDown(Object o)
  {
	  MovingThing obj = (MovingThing)o;
	  if(getY()+getHeight()>= obj.getY() - 10 && getY() + getHeight() <= obj.getY() && getX() - getWidth() >= obj.getX() && getX() <= obj.getX()+obj.getWidth())
	  {
		  return true;
	  }
	  return false;
  }

  public String toString()
  {
    return super.toString() + " " + speed;
  }

@Override
public void move(String direction) {
	// TODO Auto-generated method stub
	
}
}
