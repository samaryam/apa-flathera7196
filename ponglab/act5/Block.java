//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
  private int xPos;
  private int yPos;
  private int width;
  private int height;

  private Color color;

  public Block()
  {

  }

  //add other Block constructors - x , y , width, height, color
  public Block(int x)
  {
    xPos = x;
  }

  public Block(int x, int y)
  {
    xPos = x;
    yPos = y;
  }

  public Block(int x, int y, int w)
  {
    xPos = x;
    yPos = y;
    width = w;
  }

  public Block(int x, int y, int w, int h)
  {
    xPos = x;
    yPos = y;
    width = w;
    height = h;
  }

  public Block(int x, int y, int w, int h, Color c)
  {
    xPos = x;
    yPos = y;
    width = w;
    height = h;
    color = c;
  }

  //add the other set methods
  public void setX(int x)
  {
    xPos = x;
  }

  public void setY(int y)
  {
    yPos = y;
  }

  public void setWidth(int w)
  {
    width = w;
  }

  public void setPos(int x, int y)
  {
    xPos = x;
    yPos = y;
  }

  public void setHeight(int h)
  {
    height = h;
  }

  public void setColor(Color col)
  {
    color = col;
  }

  public void draw(Graphics window)
  {
    //uncomment after you write the set and get methods
    window.setColor(color);
    window.fillRect(getX(), getY(), getWidth(), getHeight());
  }

  public void draw(Graphics window, Color col)
  {
	  setColor(col);
	  draw(window);
  }
   
  public boolean equals(Object obj)
  {
	Block rere = (Block)obj;
	if(xPos == rere.xPos && yPos == rere.yPos && width == rere.width && height == rere.height && color.getRGB() == rere.color.getRGB())
	{
		return true;
	}
    return false;
  }   

  //add the other get methods
  public int getX()
  {
    return xPos;
  }

  public int getY()
  {
    return yPos;
  }

  public int getWidth()
  {
    return width;
  }

  public int getHeight()
  {
    return height;
  }

  public Color getColor()
  {
    return color;
  }

  //add a toString() method  - x , y , width, height, color
  public String toString()
  {
    return "x- " + xPos + " y - " + yPos + " w - " + width + " h - " + height + " c - " + color;
  }
}



