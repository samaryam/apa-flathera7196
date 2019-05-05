//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Bullets
{
  private List<Ammo> ammo;

  public Bullets()
  {
	  ammo = new ArrayList<Ammo>();
  }

  public void add(Ammo al)
  {
	  ammo.add(al);
  }

  //post - draw each Ammo
  public void drawEmAll( Graphics window )
  {
	  for(Ammo a: ammo)
	  {
		  a.draw(window);
	  }
  }

  public void moveEmAll()
  {
	  for(Ammo a: ammo)
	  {
		  a.move();
	  }
  }

  public void cleanEmUp()
  {
	  for(int i = ammo.size()-1; i >= 0; i--)
	  {
		  if(ammo.get(i).outOfBounds(800,600))
		  {
			  ammo.remove(i);
		  }
	  }
  }
  
  public void stop()
  {
	  for(Ammo a: ammo)
	  {
		  a.setSpeed(0);
	  }
  }
  
  public void setSpeed(int s)
  {
	  for(Ammo a: ammo)
	  {
		  a.setSpeed(s);
	  }
  }
  
  public void reset()
  {
	  for(int i = ammo.size()-1; i>=0; i--)
	  {
		  ammo.remove(i);
	  }
  }

  public List<Ammo> getList()
  {
    return ammo;
  }

  public String toString()
  {
    return "";
  }
}
