
package string;

import java.util.Scanner;

public class ReverseEveryWord {

	public static String reverseAllWords(String str)
	{
		if(str.length()==0)
			return "";
		
		String rev="";
		int end=0,start;
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)==' ')
			{
				start=i-1;
				for(int j=start;j>=end;j--)
				{
					rev=rev+str.charAt(j);
				}
				rev=rev+' ';
				end=i+1;
			}
		}
		start=str.length()-1;
		for(int j=start;j>=end;j--)
		{
			rev=rev+str.charAt(j);
		}
		return rev;
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=s.nextLine();
		str=reverseAllWords(str);
		System.out.println(str);
	}

}
