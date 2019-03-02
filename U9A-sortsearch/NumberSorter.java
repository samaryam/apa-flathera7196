//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;

public class NumberSorter
{
	//instance variables and other methods not shown

	private static int getNumDigits(int number)
	{
		int count = 0;
		while(number > 0)
		{
			number /= 10;
			count++;
		}
		return count;
	}

	public static int[] getSortedDigitArray(int num)
	{
		int[] sorted = new int[getNumDigits(num)];
		for(int i = 0; i < sorted.length; i++)
		{
			sorted[i] = num % 10;
			num /= 10;
		}
		Arrays.sort(sorted);
		return sorted;
	}
}