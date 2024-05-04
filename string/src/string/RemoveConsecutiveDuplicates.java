package string;

import java.util.Scanner;

public class RemoveConsecutiveDuplicates {

	public static String removeConseDupli(String str)
	{
		String temp="";
		int lastUpdateIndex=-1;
		char ch=str.charAt(0);
		
		if(str.length()!=0)
		{
			for(int i=1;i<str.length();i++)
			{
				if(str.charAt(i)!=ch)
				{
					temp=temp+ch;
					ch=str.charAt(i);
					lastUpdateIndex=i;
				}
			}
			if(lastUpdateIndex<str.length())
				temp=temp+ch;
		}
		return temp;
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=s.nextLine();
		str=removeConseDupli(str);
		System.out.println(str);
	}

}
