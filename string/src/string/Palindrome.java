package string;

import java.util.Scanner;



public class Palindrome {

	public static boolean isPalindrome(String str)
	{
		boolean status=true;
		int x=str.length()-1,i=0;
		for(;i<x;i++)
		{
			if(str.charAt(i)!=str.charAt(x))
				status=false;
			x--;
		}
		return status;
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=s.nextLine();
		boolean status=isPalindrome(str);
		System.out.println(status);
		//System.out.println(str.charAt(0));
		//System.out.println(str.charAt(str.length()-1));
	}

}
