//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BallTestTwo extends Canvas implements Runnable
{
  private Ball ball;

  public BallTestTwo()
  {
    setBackground(Color.WHITE);
    setVisible(true);

    //instantiate a new Ball
    Ball ball = new Ball();

    //test the Ball thoroughly
	ball.setX(20);
	ball.setY(30);
	ball.setWidth(10);
	ball.setHeight(10);
	ball.setXSpeed(5);
	ball.setYSpeed(5);

    //test all constructors
	Ball a = new Ball(10, 10);
	Ball b = new Ball(10, 10, 10, 10);
	Ball c = new Ball(10, 10, 10, 10, Color.GREEN);
	Ball d = new Ball(10, 10, 10, 10, Color.PINK, 10, 10);

    new Thread(this).start();
  }
	
  public void update(Graphics window)
  {
    paint(window);
  }

  public void paint(Graphics window)
  {
    ball.moveAndDraw(window);

    if(!(ball.getX()>=10 && ball.getX()<=550))
    {
      ball.setXSpeed(-ball.getXSpeed());
    }

    if(!(ball.getY()>=10 && ball.getY()<=450))
    {
      ball.setYSpeed(-ball.getYSpeed());
    }
  }
	
  public void run()
  {
    try
    {
      while(true)
      {
	Thread.currentThread().sleep(19);
	repaint();
      }
    }catch(Exception e)
    {
    }
  }	
}