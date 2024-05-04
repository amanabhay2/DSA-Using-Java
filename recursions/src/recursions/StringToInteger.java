package recursions;

import java.util.Scanner;
import java.lang.Math;

public class StringToInteger {

	public static int stringToInteger(String str)
	{
		if(str.length()==0)
			return 0;
		int a=stringToInteger(str.substring(1));
		int num=(int)(str.charAt(0))-48;
		num=num*((int)Math.pow(10, str.length()-1))+a;
		
		return num;
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=s.nextLine();
		int a=stringToInteger(str);
		System.out.println(a);
		s.close();
	}

}
