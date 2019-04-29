//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;

public class Pong extends Canvas implements KeyListener, Runnable
{
  private int width, height;
  private Ball ball;
  private Paddle leftPaddle, rightPaddle;
  private Wall topWall, botWall, rightWall, leftWall;
  private boolean[] keys;
  private BufferedImage back;
  private Score score;
  private int hitCount;


  public Pong(int w, int h)
  {
    //set up all variables related to the game
	width = w;
	height = h;
	ball = new Ball((int)(Math.random()* (width/2)) + width/80, (int)(Math.random()*(height/3)) + width/80, width/70, width/70);
	ball.setXSpeed(ball.getWidth()/3);
	ball.setYSpeed(ball.getHeight()/5);
	leftPaddle = new Paddle(width/80, height/2, (width/70)*2, (width/70)*9, Color.RED);
	leftPaddle.setSpeed(height/90);
	rightPaddle = new Paddle(width - (3*width)/80, height/2, (width/70)*2, (width/70)*9, Color.BLUE);
	rightPaddle.setSpeed(height/90);
	topWall = new Wall(0, 0, width, width/80);
	botWall = new Wall(0, height - (int)(width*.06), width, width/80);
	leftWall = new Wall(0, 0, height/60, height);
	rightWall = new Wall(width - ball.getWidth(), 0, width/80, height);
	
    keys = new boolean[5];

    score = new Score(width, height);
    hitCount = 0;
    
    setBackground(Color.WHITE);
    setVisible(true);
		
    new Thread(this).start();
    addKeyListener(this);		//starts the key thread to log key strokes
  }
	
  public void update(Graphics window)
  {
    paint(window);
  }

  public void paint(Graphics window)
  {
    //set up the double buffering to make the game animation nice and smooth
    Graphics2D twoDGraph = (Graphics2D)window;

    //take a snap shop of the current screen and same it as an image
    //that is the exact same width and height as the current screen
    if(back==null)
      back = (BufferedImage)(createImage(getWidth(),getHeight()));

    //create a graphics reference to the back ground image
    //we will draw all changes on the background image
    Graphics graphToBack = back.createGraphics();
    
    ball.moveAndDraw(graphToBack);
    leftPaddle.draw(graphToBack);
    rightPaddle.draw(graphToBack);
    score.erase(graphToBack);
    score.paint(graphToBack);
    topWall.paint(graphToBack);
    botWall.paint(graphToBack);
    rightWall.paint(graphToBack);
    leftWall.paint(graphToBack);

    //see if ball hits left wall or right wall
    if(ball.didCollideLeft(leftWall) && hitCount == 0)
    {
      ball.setXSpeed(0);
      ball.setYSpeed(0);
      score.rightPlus();
      hitCount++;
    }
    
    if(ball.didCollideRight(rightWall) && hitCount == 0)
    {
    	ball.setXSpeed(0);
        ball.setYSpeed(0);
        score.leftPlus();
        hitCount++;
    }

    //see if the ball hits the top or bottom wall 
    if(ball.didCollideTop(topWall))
    {
    	ball.setYSpeed(-ball.getYSpeed()+ 1);
    }

    if(ball.didCollideBottom(botWall))
    {
    	ball.setYSpeed(-ball.getYSpeed()- 1);
    }
    
    //see if the ball hits the left or right paddle
	if(ball.didCollideLeft(leftPaddle) && hitCount == 0)
	{
		ball.setXSpeed(-ball.getXSpeed()+ 1);
	}
	
	if(ball.didCollideRight(rightPaddle) && hitCount == 0)
	{
		ball.setXSpeed(-ball.getXSpeed()- 1);
	}

    //see if the paddles need to be moved
	if (keys[0])
    {
        //move left paddle up and draw it on the window
    	if(leftPaddle.getY() >= width/80)
    	{
            leftPaddle.moveUpAndDraw(graphToBack);
    	}
    }
	
    if (keys[1])
    {
        //move left paddle down and draw it on the window
    	if(leftPaddle.getY() <= height - leftPaddle.getHeight() - 3*botWall.getHeight())
    	{
            leftPaddle.moveDownAndDraw(graphToBack);
    	}
    }
    if (keys[2])
    {
    	if(rightPaddle.getY() >= width/80)
    	{
            rightPaddle.moveUpAndDraw(graphToBack); 
    	}
    }
    if (keys[3])
    {
    	if(rightPaddle.getY() <= height - leftPaddle.getHeight() - 3*botWall.getHeight())
    	{
            rightPaddle.moveDownAndDraw(graphToBack);
          
    	}
    }
    
    if(keys[4])
    {
    	ball.erase(graphToBack);
    	ball.setPos((int)(Math.random()*(width/2)) + 10, (int)(Math.random()*(height/4)) + 10);
        ball.setXSpeed(ball.getWidth()/3);
        ball.setYSpeed(ball.getHeight()/5);
        hitCount = 0;
    }
	
    twoDGraph.drawImage(back, null, 0, 0);
  }

  public void keyPressed(KeyEvent e)
  {
    switch(toUpperCase(e.getKeyChar()))
    {
    case 'W' : keys[0]=true; break;
    case 'Z' : keys[1]=true; break;
    case 'I' : keys[2]=true; break;
    case 'M' : keys[3]=true; break;
    case ' ' : keys[4]=true; break;
    }
  }

  public void keyReleased(KeyEvent e)
  {
    switch(toUpperCase(e.getKeyChar()))
    {
    case 'W' : keys[0]=false; break;
    case 'Z' : keys[1]=false; break;
    case 'I' : keys[2]=false; break;
    case 'M' : keys[3]=false; break;
    case ' ' : keys[4]=false; break;
    }
  }

  public void keyTyped(KeyEvent e){}
	
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