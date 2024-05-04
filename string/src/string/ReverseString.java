package string;

import java.util.Scanner;

public class ReverseString {
	
	public static String reverseString(String str)
	{
		int end=str.length();
		String ans=""; 
		int i=str.length()-1;
		for(;i>=0;i--)
		{
			if(str.charAt(i)==' ')
			{
				ans=ans+str.substring(i+1, end)+" ";
				end=i;
			}
		}
		ans=ans+str.substring(0, end);
		
		return ans;
	}

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=s.nextLine();
		
		str=reverseString(str);
		System.out.println(str);

	}

}
