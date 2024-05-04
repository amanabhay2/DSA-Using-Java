package recursions;

import java.util.Scanner;

public class RemoveX {

	public static String removeX(String str,char x)
	{
		if(str.length()==0)
			return str;
		if(str.charAt(0)==x)
			return removeX(str.substring(1),x);
			
		return str.charAt(0)+removeX(str.substring(1),x);
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=s.nextLine();
		char x=s.next().charAt(0);
		str=removeX(str,x);
		System.out.println(str);
		s.close();

	}

}
