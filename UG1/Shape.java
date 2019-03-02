//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public class Shape
{
   //instance variables
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private Color color;

   public Shape(int x, int y, int wid, int ht, Color col)
   {
		xPos = x;
		yPos = y;
		width = wid;
		height = ht;
		color = col;
   }


   public void draw(Graphics window)
   {
	  window.setColor(color);
	  window.fillPolygon(new int[] {xPos + width + width/3, xPos + (int)(width/1.3), xPos + width + width/3}, new int[] {yPos + height + height/4, yPos + height/2, yPos - height/4}, 3);
	  
	  window.setColor(Color.BLACK);
	  window.drawPolygon(new int[] {xPos + width + width/3, xPos + (int)(width/1.3), xPos + width + width/3}, new int[] {yPos + height + height/4, yPos + height/2, yPos - height/4}, 3);
	  
      window.setColor(color);
      window.fillOval(xPos, yPos, width, height);
      
      window.setColor(Color.BLACK);
      window.drawOval(xPos, yPos, width, height);
      
      window.setColor(Color.BLACK);
      window.fillOval(xPos + (int)(width/3.5), yPos + height/4, height/5, height/5);
      
      window.setColor(Color.BLACK);
      window.fillArc(xPos + width/12, yPos + height/3, width/3, height/2, 180, 180);
   }

   //BONUS
   //add in set and get methods for all instance variables
   public void setXPos(int x)
   {
	   xPos = x;
   }
   
   public int getXPos()
   {
	   return xPos;
   }
   
   public void setYPos(int y)
   {
	   yPos = y;
   }
   
   public int getYPos()
   {
	   return yPos;
   }
   
   public void setWidth(int w)
   {
	   width = w;
   }
   
   public int getWidth()
   {
	   return width;
   }
   
   public void setHeight(int h)
   {
	   height = h;
   }
   
   public int getHeight()
   {
	   return height;
   }
   
   public void setColor(Color c)
   {
	   color = c;
   }
   
   public Color getColor()
   {
	   return color;
   }

   public String toString()
   {
   	return xPos+" "+yPos+" "+width+" "+height+" "+color;
   }
}