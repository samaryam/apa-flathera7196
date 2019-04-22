//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Canvas;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;

public class PaddleTestTwo extends Canvas implements KeyListener, Runnable
{
  private static final long serialVersionUID = 1L;
  private Ball ball;
  private Paddle leftPaddle, rightPaddle;
  private boolean[] keys;		//keeps track of what keys are pressed

  public PaddleTestTwo()
  {
    //set up all game variables

    //instantiate a Ball
	ball = new Ball(100, 100, 10, 10, Color.BLACK);
		
    //instantiate a left Paddle
	leftPaddle = new Paddle(20, 200, 10, 60, Color.RED);

    //instantiate a right Paddle
	rightPaddle = new Paddle(770, 200, 10, 60, Color.RED);

    keys = new boolean[5];
    //set up the Canvas
    setBackground(Color.WHITE);
    setVisible(true);

    this.addKeyListener(this);
    new Thread(this).start();
  }
	
  public void update(Graphics window)
  {
    paint(window);
  }

  public void paint(Graphics window)
  {
    ball.moveAndDraw(window);
    leftPaddle.draw(window);
    rightPaddle.draw(window);

    if (!(ball.getX()>= 0 && ball.getX()<= 790))
    {
      ball.setXSpeed(-ball.getXSpeed());
    }

    if (!(ball.getY()>= 0 && ball.getY()<=570))
    {
      ball.setYSpeed(-ball.getYSpeed());
    }

    if (keys[0])
    {
        //move left paddle up and draw it on the window
    	if(leftPaddle.getY() >= 10)
    	{
            leftPaddle.moveUpAndDraw(window);
            //System.out.println(leftPaddle.getY());
    	}
    }
    if (keys[1])
    {
        //move left paddle down and draw it on the window
    	if(leftPaddle.getY() <= 510)
    	{
            leftPaddle.moveDownAndDraw(window);
            //System.out.println(leftPaddle.getY());
    	}
    }
    if (keys[2])
    {
    	if(rightPaddle.getY() >= 10)
    	{
            rightPaddle.moveUpAndDraw(window); 
            //System.out.println(rightPaddle.getY());
    	}
    }
    if (keys[3])
    {
    	if(rightPaddle.getY() <= 510)
    	{
            rightPaddle.moveDownAndDraw(window);
            //System.out.println(rightPaddle.getY());
    	}
    }
  }

  public void keyPressed(KeyEvent e)
  {
    switch (toUpperCase(e.getKeyChar()))
    {
    case 'W' : keys[0]=true; break;
    case 'S' : keys[1]=true; break;
    case 'I' : keys[2]=true; break;
    case 'K' : keys[3]=true; break;
    }
  }

  public void keyReleased(KeyEvent e)
  {
    switch(toUpperCase(e.getKeyChar()))
    {
    case 'W' : keys[0]=false; break;
    case 'S' : keys[1]=false; break;
    case 'I' : keys[2]=false; break;
    case 'K' : keys[3]=false; break;
    }
  }

  public void keyTyped(KeyEvent e)
  {
    //no code needed here
  }
	
  public void run()
  {
    try
    {
      while(true)
      {
	    Thread.currentThread().sleep(8);
	    repaint();
      }
    }catch(Exception e)
    {
    }
  }		
}