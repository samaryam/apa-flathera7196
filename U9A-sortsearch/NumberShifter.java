//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberShifter
{
	public static int[] makeLucky7Array( int size)
	{
 	  int[] ray = new int[size];
          for(int i = 0; i < size; i++)
          {
            ray[i] = (int)( Math.random()*10);
	  }
	  return ray;
	}
	public static void shiftEm(int[] array)
	{
	  int index = 0;
	  for(int i = 0; i < array.length; i++)
	  {
	    int temp;
	    if(array[i] == 7)
	    {
	      temp = array[index];
	      array[index] = 7;
	      array[i] = temp;
	      index++;
	    }
	  }
	}	
}
