import java.awt.Color;
import java.awt.Graphics;

public class Wall extends Block
{
	
	public Wall(int x, int y, int h, int w)
	{
		super(x, y, h, w);
	}
	
	public void paint(Graphics window)
	{
		window.setColor(new Color(255, 255, 255, 0));
		window.drawRect(getX(), getY(), getWidth(), getHeight());
	}
}
