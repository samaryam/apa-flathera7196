//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class AlienHorde
{
  private List<Alien> aliens;

  public AlienHorde(int size)
  {
	  aliens = new ArrayList<Alien>(size);
  }

  public void add(Alien al)
  {
	  aliens.add(al);
  }
  
  public List<Alien> getList()
  {
	  return aliens;
  }

  public void drawEmAll( Graphics window )
  {
	  for(Alien a : aliens)
	  {
		  a.draw(window);
	  }
  }

  public void moveEmAll(String direction)
  {
	  for(Alien a: aliens)
	  {
		  a.move(direction);
	  }
  }
  
  public void stop()
  {
	  for(Alien a: aliens)
	  {
		  a.setSpeed(0);
	  }
  }
  
  public void reset(int n)
  {
	  for(int i = aliens.size() - 1; i >=0; i--)
	  {
		  aliens.remove(i);
	  }
	  if(n ==1)
	  for(int i = 0; i < 6; i++)
	    {
	    	aliens.add(new Alien(i*50 + 10,10,50,50,1));
	    }
	  if(n==2)  
	    for(int i = 0; i < 6; i++)
	    {
	    	aliens.add(new Alien(i*50 + 350,60,50,50,1));
	    }
	  if(n==3)
	    for(int i = 0; i < 6; i++)
	    {
	    	aliens.add(new Alien(i*50 + 10,110,50,50,1));
	    }
	  if(n==4)
	    for(int i = 0; i < 6; i++)
	    {
	    	aliens.add(new Alien(i*50 + 350,160,50,50,1));
	    }
  }
  

  public void removeDeadOnes(List<Ammo> shots)
  {
	  for(int i = aliens.size() - 1; i >= 0; i--)
	  {
		  for(int j = shots.size() - 1; j >= 0; j--)
		  {
			  //System.out.println(i + " " + j + " " + aliens.size());
			  if(aliens.size() > 0 && shots.get(j).didCollideUp(aliens.get(i)) && shots.get(j).getSpeed()<0)
			  {
				  aliens.remove(i);
				  shots.remove(j);
				  break;
			  }
		  }  
	  }
  }
  
  public void whoShoots()
  {
	  for(Alien a: aliens)
	  {
		  int shot = (int)(Math.random()*400);
		  if(shot > 398)
		  {
			  a.setShot(true);
		  }
	  }
  }

  public String toString()
  {
    return "";
  }
}
