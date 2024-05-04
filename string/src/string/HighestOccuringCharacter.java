package string;

import java.util.Scanner;

public class HighestOccuringCharacter {

	public static char highestOccuringChar(String str)
	{
		int[] arr=new int[256];
		int max=Integer.MIN_VALUE;
		int maxIndex=-1;
		for(int i=0;i<str.length();i++)
		{
			arr[str.charAt(i)]++;
		}
		for(int i=0;i<256;i++)
		{
			if(arr[i]>max)
			{
				max=arr[i];
				maxIndex=i;
			}
		}
		char ch=(char)(maxIndex);
		return ch;
		
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=s.nextLine();
		
		char ch=highestOccuringChar(str);
		
		System.out.println(ch);
		s.close();

	}

}
