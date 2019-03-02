//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;

public class BigHouse extends Canvas
{
   public BigHouse()  //constructor - sets up the class
   {
      setSize(800,600);
      setBackground(Color.WHITE);
      setVisible(true);
   }

   public void paint( Graphics window )
   {
      //call bigHouse
	   bigHouse(window);
   }

   public void bigHouse( Graphics window )
   {
      window.setColor(Color.BLUE);
      window.drawString( "BIG HOUSE ", 50, 50 );
      window.setColor(Color.YELLOW);
      window.fillRect( 200, 200, 400, 400 );

      window.setColor(Color.darkGray);
      window.fillRect(270, 300, 70, 70);
      window.setColor(Color.darkGray);
      window.fillRect(450, 300, 70, 70);
      window.fillPolygon(new int[] {170, 400, 630}, new int[] {200, 30, 200}, 3);
      
      window.setColor(Color.PINK);
      window.fillRect(345, 450, 95, 150);
   }
}