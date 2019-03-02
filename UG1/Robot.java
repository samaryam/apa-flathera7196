//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;

class Robot extends Canvas
{
  public Robot()    //constructor method - sets up the class
  {
    setSize(800,800);
    setBackground(Color.WHITE);   	
    setVisible(true);
  }
  
  public void paint( Graphics window )
  {
    window.setColor(Color.BLUE);
    
    window.drawString("Robot LAB ", 35, 35 );
    
    //call head method
    head(window);
    //call other methods
    upperBody(window);
    lowerBody(window);
  }
  
  public void head( Graphics window )
  {
    window.setColor(Color.BLACK);
    window.fillRect(300, 100, 170, 150);
    
    window.setColor(Color.GREEN);
    window.fillOval(330, 140, 30, 30);
    
    window.setColor(Color.GREEN);
    window.fillOval(410, 140, 30, 30);
    
    window.setColor(Color.ORANGE);
    window.fillRect(340, 200, 90, 20);
  }

  public void upperBody( Graphics window )
  {
	window.setColor(Color.BLACK);
	window.fillRect(270, 255, 230, 230);
	
	window.setColor(Color.MAGENTA);
	window.fillRect(70, 300, 200, 30);
	
	window.setColor(Color.MAGENTA);
	window.fillRect(500, 300, 200, 30);
  }

  public void lowerBody( Graphics window )
  {
	  window.setColor(Color.BLUE);
	  window.fillRect(320, 485, 30, 200);
	  
	  window.setColor(Color.BLUE);
	  window.fillRect(420, 485, 30, 200);
  }
}
