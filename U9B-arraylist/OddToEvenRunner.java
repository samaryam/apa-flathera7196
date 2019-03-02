import java.util.ArrayList;
import java.util.Arrays;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class OddToEvenRunner
{
  public static void main( String args[] )
  {
	  ArrayList<Integer> a = new ArrayList<Integer>();
	   a.addAll(Arrays.asList(7,1,5,3,11,5,6,7,8,9,10,12345,11));
	   
	  System.out.println(ListOddToEven.go(a));

	  ArrayList<Integer> b = new ArrayList<Integer>();
	  b.addAll(Arrays.asList(11,9,8,7,6,5,4,3,2,1,-99,7));

	  System.out.println(ListOddToEven.go(b));

	  ArrayList<Integer> c = new ArrayList<Integer>();
	  c.addAll(Arrays.asList(10,20,30,40,5,41,31,20,11,7));

	  System.out.println(ListOddToEven.go(c));
  }
}