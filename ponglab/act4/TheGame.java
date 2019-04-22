//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import javax.swing.JFrame;
import java.awt.Component;

public class TheGame extends JFrame
{
  private static final int WIDTH = 400;
  private static final int HEIGHT = 300;

  public TheGame()
  {
    super("PONG");
    setSize(WIDTH,HEIGHT);

    Pong game = new Pong(WIDTH, HEIGHT);

    ((Component)game).setFocusable(true);
    getContentPane().add(game);

    setVisible(true);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static void main( String args[] )
  {
    TheGame run = new TheGame();
  }
}