import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;


public class Score
{
	private int leftScore, rightScore, width, height;	
	
	public Score(int w, int h)
	{
		width = w;
		height = h;
	}
	
	public void paint(Graphics window)
	{
		window.setColor(Color.BLUE);
		window.setFont(new Font("TimesRoman", Font.PLAIN, width/40)); 
		window.drawString("RIGHT " + rightScore, (int)(width/2.5) + width/8, height - height/7);
		window.setColor(Color.RED);
		window.drawString("LEFT  " + leftScore, (int)(width/2.5) + width/40, height - height/7);
		window.setColor(Color.BLACK);
		window.drawRect((int)(width/2.5), height - height/5, (int)(width/3.5), width/12);
	}
	
	public void erase(Graphics window)
	{
		window.setColor(Color.WHITE);
		window.fillRect((int)(width/2.5), height - height/5, (int)(width/3.5), width/12);
	}
	
	public void leftPlus()
	{
		leftScore++;
	}
	
	public void rightPlus()
	{
		rightScore++;
	}
	
	public int getLeft()
	{
		return leftScore;
	}
	
	public int getRight()
	{
		return rightScore;
	}
}
