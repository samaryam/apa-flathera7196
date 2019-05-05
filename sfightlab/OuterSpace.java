//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class OuterSpace extends Canvas implements KeyListener, Runnable
{
  private Ship ship;
  private AlienHorde horde1, horde2, horde3, horde4;
  private Bullets shots;
  private boolean[] keys;
  private BufferedImage back;
  private int frameDelay;
  private boolean hit;

  public OuterSpace()
  {
    setBackground(Color.black);

    keys = new boolean[6];
    horde1 = new AlienHorde(5);
    horde2 = new AlienHorde(5);
    horde3 = new AlienHorde(5);
    horde4 = new AlienHorde(5);
    frameDelay = 0;
    
    for(int i = 0; i < 6; i++)
    {
    	horde1.add(new Alien(i*50 + 10,10,50,50,1));
    }
    
    for(int i = 0; i < 6; i++)
    {
    	horde2.add(new Alien(i*50 + 350,60,50,50,1));
    }
    
    for(int i = 0; i < 6; i++)
    {
    	horde3.add(new Alien(i*50 + 10,110,50,50,1));
    }
    
    for(int i = 0; i < 6; i++)
    {
    	horde4.add(new Alien(i*50 + 350,160,50,50,1));
    }
    
    shots = new Bullets();
    ship = new Ship(350,500,60,60,3);

    this.addKeyListener(this);
    new Thread(this).start();

    setVisible(true);
  }

  public void update(Graphics window)
  {
    paint(window);
  }

  public void paint( Graphics window )
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

	    graphToBack.setColor(Color.BLUE);
	    graphToBack.drawString("StarFighter ", 25, 50 );
	    graphToBack.setColor(Color.BLACK);
	    graphToBack.fillRect(0,0,800,600);
	    if(!hit)
	    {
		    hit = ship.hit(shots.getList());
	    }

	    if(hit)
	    {
	    	horde1.stop();
	    	horde2.stop();
	    	horde3.stop();
	    	horde4.stop();
	    	shots.stop();
	    	ship.stop();
	    }
	    
	    ship.draw(graphToBack);
	    
	    for(Ammo a: shots.getList())
	    {
	    	a.move();
	    	a.draw(graphToBack);
	    }
	    
	    shots.cleanEmUp();
	    
		horde1.removeDeadOnes(shots.getList());
	    horde1.moveEmAll("LEFT");
	    horde1.drawEmAll(graphToBack);
	    horde1.whoShoots();

		horde2.removeDeadOnes(shots.getList());
	    horde2.moveEmAll("RIGHT");
	    horde2.drawEmAll(graphToBack);
	    horde2.whoShoots();
	    
		horde3.removeDeadOnes(shots.getList());
	    horde3.moveEmAll("RIGHT");
	    horde3.drawEmAll(graphToBack);
	    horde3.whoShoots();
	    
		horde4.removeDeadOnes(shots.getList());
	    horde4.moveEmAll("LEFT");
	    horde4.drawEmAll(graphToBack);
	    horde4.whoShoots();

	    if(frameDelay == 20)
	    {
	    	frameDelay = 0;
	    }
	    
	    for(Alien a: horde1.getList())
	    {
	    	if(a.getShot())
	    	{
	    		shots.add(new Ammo(a.getX()+(a.getWidth()/2),a.getY(), 2, Color.RED));
	    		a.setShot(false);
	    	}
	    }
	    
	    for(Alien a: horde2.getList())
	    {
	    	if(a.getShot())
	    	{
	    		shots.add(new Ammo(a.getX()+(a.getWidth()/2),a.getY(), 2, Color.RED));
	    		a.setShot(false);
	    	}
	    }
	    
	    for(Alien a: horde3.getList())
	    {
	    	if(a.getShot())
	    	{
	    		shots.add(new Ammo(a.getX()+(a.getWidth()/2),a.getY(), 2, Color.RED));
	    		a.setShot(false);
	    	}
	    }
	    
	    for(Alien a: horde4.getList())
	    {
	    	if(a.getShot())
	    	{
	    		shots.add(new Ammo(a.getX()+(a.getWidth()/2),a.getY(), 2, Color.RED));
	    		a.setShot(false);
	    	}
	    }

	    if(keys[0])
	    {
	    	if(ship.getX() > 0)
	    	{
	    		ship.move("LEFT");
	    	    ship.draw(graphToBack);
	    	}
	    }

	    if(keys[1])
	    {
	    	if(ship.getX() < 800 - ship.getWidth())
	    	{
	    	    ship.move("RIGHT");
	    	    ship.draw(graphToBack);
	    	}
	    }
	    
	    if(keys[2])
	    {
	    	if(ship.getY() > 0)
	    	{
	    		ship.move("UP");
	    	    ship.draw(graphToBack);
	    	}
	    }
	    
	    if(keys[3])
	    {
	    	if(ship.getY() < 600 - (ship.getHeight()+20))
	    	{
	    		ship.move("DOWN");
	    	    ship.draw(graphToBack);
	    	}
	    }
	    
	    if(keys[4] && frameDelay == 0)
	    {
	    	shots.add(new Ammo(ship.getX()+(ship.getWidth()/2),ship.getY(), -3, Color.GREEN));
	    }
	    
	    if(keys[5])
	    {
	    	horde1.reset(1);
	    	horde2.reset(2);
	    	horde3.reset(3);
	    	horde4.reset(4);
	    	shots.reset();
	    	ship.setPos(350,500);
	    	ship.setSpeed(3);
	    	hit = false;
	    }
	    
	    frameDelay++;

	    twoDGraph.drawImage(back, null, 0, 0);
  }


  public void keyPressed(KeyEvent e)
  {
	    if (e.getKeyCode() == KeyEvent.VK_A)
	    {
	      keys[0] = true;
	    }
	    if (e.getKeyCode() == KeyEvent.VK_D)
	    {
	      keys[1] = true;
	    }
	    if (e.getKeyCode() == KeyEvent.VK_W)
	    {
	      keys[2] = true;
	    }
	    if (e.getKeyCode() == KeyEvent.VK_S)
	    {
	      keys[3] = true;
	    }
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
        {
          keys[4] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_U)
        {
          keys[5] = true;
        }
        repaint();
        
  }

  public void keyReleased(KeyEvent e)
  {
	  if (e.getKeyCode() == KeyEvent.VK_A)
	    {
	      keys[0] = false;
	    }
	  if (e.getKeyCode() == KeyEvent.VK_D)
	    {
	      keys[1] = false;
	    }
	  if (e.getKeyCode() == KeyEvent.VK_W)
	    {
	      keys[2] = false;
	    }
	  if (e.getKeyCode() == KeyEvent.VK_S)
	    {
	      keys[3] = false;
	    }
    if (e.getKeyCode() == KeyEvent.VK_SPACE)
    {
      keys[4] = false;
    }
    if(e.getKeyCode() == KeyEvent.VK_U)
    {
    	keys[5] = false;
    }
    repaint();
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
        Thread.currentThread().sleep(5);
        repaint();
      }
    }catch(Exception e)
    {
    }
  }
}

