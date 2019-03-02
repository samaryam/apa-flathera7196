//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;

public class WordSortTwo
{
	private String[] wordRay;

	public WordSortTwo(String sentence)
	{
    wordRay = sentence.split(" ");
	}

	public void sort()
	{
    Arrays.sort(wordRay);
	}

	public String toString()
	{
		String output = "";
    for(String word: wordRay)
    {
      output = output + "\n" + word;
    }
		return output;
	}
}