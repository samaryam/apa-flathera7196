//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.List;

public class ListOddToEven
{
	public static int go( List<Integer> ray )
	{
		int count = 0;
		int diff = 0;
		for(int i = 0; i < ray.size(); i++)
		{
			if(ray.get(i) % 2 == 1)
			{
				for(int j = ray.size() - 1; j > i; j--)
				{
					if(diff != 0)
					{
						break;
					}
					else if(ray.get(j) % 2 == 0)
					{
						diff = j - i;
						count++;
					}
				}
			}
			count++;
		}
		if(count < 2)
		{
			return -1;
		}
		else
		{
			return diff;
		}
	}
}