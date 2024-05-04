package string;

import java.util.Scanner;

public class RemoveAllOccurences {

	public static String removeOccurence(String str,char x)
	{
		boolean found=false;
		String result="";
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)==x)
			{
				found=true;
				continue;
			}
			result=result+str.charAt(i);
		}
		if(found)
			return result;
		return str;
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=s.nextLine();
		char x=s.next().charAt(0);
		
		str=removeOccurence(str,x);
		System.out.println(str);		
		s.close();
	}

}
