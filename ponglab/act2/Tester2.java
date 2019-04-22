//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
 
import javax.swing.JFrame;
import java.awt.Component;

public class Tester2 extends JFrame
{
  private static final int WIDTH = 800;
  private static final int HEIGHT = 600;

  public Tester2()
  {
    super("PONG TESTER");
    setSize(WIDTH,HEIGHT);

    getContentPane().add(new BlockTestTwo());

    //uncomment when you are ready to test the Ball
    getContentPane().add(new BallTestTwo());

    PaddleTestTwo padTest = new PaddleTestTwo();
    ((Component)padTest).setFocusable(true);
    getContentPane().add(padTest);

    setVisible(true);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static void main( String args[] )
  {
    Tester2 run = new Tester2();
  }
}