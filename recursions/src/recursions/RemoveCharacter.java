package recursions;

import java.util.Scanner;


public class RemoveCharacter {

	public static String removeCharacter(String str,char x)
	{
		if(str.length()==0)
			return str;
		
		String ans="";
		if(str.charAt(0)!=x)
		{
			ans=ans+str.charAt(0);
		}
		
		return ans+removeCharacter(str.substring(1),x);
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=s.nextLine();
		char x=s.next().charAt(0);
		str=removeCharacter(str,x);
		System.out.println(str);
		s.close();
	}

}
