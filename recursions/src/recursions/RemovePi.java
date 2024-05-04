package recursions;

import java.util.Scanner;

public class RemovePi {
	public static int piPos(String str)
	{
		int P=-1;
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)=='p')
			{
				if(str.charAt(i+1)=='i')
					return i;
			}
		}
		return P;
	}

	public static String removePi(String str)
	{
		int P=piPos(str);
		if(P==-1)
			return str;
		else
			str= str.substring(0,P)+3.14+str.substring(P+2,str.length());
		
		return removePi(str);
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=s.nextLine();
		str=removePi(str);
		System.out.println(str);
		s.close();
	}

}
