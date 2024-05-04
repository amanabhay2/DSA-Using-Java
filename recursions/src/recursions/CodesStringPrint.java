package recursions;

import java.util.Scanner;

public class CodesStringPrint {

	public static void printCodes(String str,String output)
	{
		if(str.length()==0)
		{
			System.out.println(output);
			return;
		}
		int a1=str.charAt(0)-'0';
		char ch1=(char)('a'+a1-1);
		printCodes(str.substring(1),output+ch1);
		
		if(str.length()>1)
		{
			int a2=(str.charAt(0)-'0')*10+(str.charAt(1)-'0');
			if(a2>26)
				return;
			char ch2=(char)('a'+a2-1);
			printCodes(str.substring(2),output+ch2);
		}		
	}
	
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		String str=s.nextLine();
		printCodes(str,"");
		s.close();
	}

}
