//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.awt.Font;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class ShapePanel extends JPanel
{
	public ShapePanel()
	{
		setBackground(Color.WHITE);
		setVisible(true);
	}

	public void update(Graphics window)
	{
		paint(window);
	}

	/*
	 *All of your test code should be placed in paint.
	 */
	public void paint(Graphics window)
	{
		window.setColor(Color.WHITE);
		window.fillRect(0,0,getWidth(), getHeight());
		window.setColor(Color.BLUE);
		window.drawRect(20,20,getWidth()-40,getHeight()-40);
		window.setFont(new Font("TAHOMA",Font.BOLD,18));
		window.drawString("CREATE YOUR OWN SHAPE!",40,40);


		//instantiate a Shape
		//tell your shape to draw
		Shape one = new Shape(100, 100, 50, 50, Color.YELLOW);
		one.draw(window);
		//instantiate a Shape
		//tell your shape to draw
		Shape two = new Shape(100, 200, 200, 100, Color.BLUE);
		two.draw(window);
		//instantiate a Shape
		//tell your shape to draw
		Shape three = new Shape(350, 250, 300, 400, Color.MAGENTA);
		three.draw(window);
	}
}