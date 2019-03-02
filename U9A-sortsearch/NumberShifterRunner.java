//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.IOException;

public class NumberShifterRunner
{
	public static void main( String args[] ) throws IOException
	{
	  //add test cases 	
	  int[] array1 = NumberShifter.makeLucky7Array(10);
	  for( int num: array1)
	  {
		System.out.print(num + " ");
	  }
	  System.out.println();
	  NumberShifter.shiftEm(array1);
	  for(int num: array1)
	  {
		System.out.print(num + " ");
	  }
	  System.out.println();
	}
}



