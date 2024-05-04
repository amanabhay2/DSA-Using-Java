package string;

import java.util.Scanner;

public class CompressTheString {

	public static String compress(String str)
	{
		if(str.length()==0)
			return "";
		
		char ch=str.charAt(0);
		int count=1;
		String result="";
		for(int i=1;i<str.length();i++)
		{
			if(str.charAt(i)!=ch)
			{
				result=result+ch;
				if(count>1)
					result=result+count;
				ch=str.charAt(i);
				count=1;
			}
			else
			{
				count++;
			}
		}
		result=result+ch;
		if(count>1)
			result=result+count;
		return result;
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=s.nextLine();
		str=compress(str);
		System.out.println(str);
		s.close();
	}

}
