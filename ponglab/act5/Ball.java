//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable
{
  private int xSpeed;
  private int ySpeed;

  public Ball()
  {
    super(200,200);
    xSpeed = 3;
    ySpeed = 1;
  }

  //add the other Ball constructors
  public Ball(int x, int y)
  {
	  super(x, y);
	  xSpeed = 3;
	  ySpeed = 1;
  }
  
  public Ball(int x, int y, int w, int h)
  {
	  super(x, y, w, h);
	  xSpeed = 3;
	  ySpeed = 1;
  }
  
  public Ball(int x, int y, int w, int h, Color c)
  {
	  super(x, y, w, h, c);
	  xSpeed = 3;
	  ySpeed = 1;
  }
  
  public Ball(int x, int y, int w, int h, Color c, int xS, int yS)
  {
	  super(x, y, w, h, c);
	  xSpeed = xS;
	  ySpeed = yS;
  }
  
  public Ball(int x, int y, int w, int h, int xS, int yS)
  {
	  super(x, y, w, h);
	  xSpeed = xS;
	  ySpeed = yS;
  }
	   
  //add the set methods
  public void setXSpeed(int x)
  {
	  xSpeed = x;
  }
  
  public void setYSpeed(int y)
  {
	  ySpeed = y;
  }

  public void moveAndDraw(Graphics window)
  {
    //draw a white ball at old ball location
	setColor(Color.WHITE);
	draw(window);

    setX(getX()+xSpeed);
    //setY
    setY(getY() + ySpeed);
    //draw the ball at its new location
    setColor(Color.BLACK);
    draw(window);
  }
  
  public void erase(Graphics window)
  {
	  setColor(Color.WHITE);
	  draw(window);
  }
   
  public boolean equals(Object obj)
  {
	Ball rere = (Ball)obj;
	if(super.equals(rere))
	{
		if(xSpeed == rere.xSpeed && ySpeed == rere.ySpeed)
		{
			return true;
		}
	}
    return false;
  }   

  //add the get methods
  public int getXSpeed()
  {
	  return xSpeed;
  }

  public int getYSpeed()
  {
	  return ySpeed;
  }
  
  //add a toString() method
  public String toString()
  {
	  return super.toString() + " xS - " + xSpeed + " yS - " + ySpeed;
  }

  public boolean didCollideLeft(Object obj) 
  {
	  Block block = (Block)obj;
	  if(getX() <= block.getX() + block.getWidth() && getY() + getHeight() >= block.getY() && getY() <= block.getY() + block.getHeight())
	  {
		  return true;
	  }
	  return false;
  }


  public boolean didCollideRight(Object obj) 
  {
	  Block block = (Block)obj;
	  if(getX() + getWidth() >= block.getX() && getY() + getHeight() >= block.getY() && getY() + getWidth()/200 <= block.getY() + block.getHeight())
	  {
		  return true;
	  }
	  return false;
  }


  public boolean didCollideTop(Object obj) 
  {
	  Block block = (Block)obj;
	  if(getY() <= block.getY() + block.getHeight())
	  {
		  return true;
	  }
	  return false;
  }

  public boolean didCollideBottom(Object obj) 
  {
	  Block block = (Block)obj;
	  if(getY() >= block.getY() - block.getHeight())
	  {
		  return true;
	  }
	  return false;
  }
}








