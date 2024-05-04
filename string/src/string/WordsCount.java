package string;

import java.util.Scanner;

public class WordsCount {
	
	public static int wordCount(String str)
	{
		int words=0;
		if(str.length()==0)
			return words;
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)==' ')
				words++;
		}
		return words+1;
	}

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=s.nextLine();
		int count=wordCount(str);		
		System.out.println(count);
		s.close();
	}

}
