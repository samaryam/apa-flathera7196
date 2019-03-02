//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class WordSortTwoRunner
{
	private static Scanner file;

	public static void main( String args[] ) throws IOException
	{
		file = new Scanner(new File("wordsorttwo.dat"));
		int size = file.nextInt();
		file.nextLine();
		
		for(int i = 0; i<size; i++)
		{
			String sentence = file.nextLine();
			WordSortTwo word = new WordSortTwo(sentence);
			word.sort();
			System.out.println(word);
		}
	}
}