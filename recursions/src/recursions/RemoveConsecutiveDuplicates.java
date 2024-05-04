package recursions;

import java.util.Scanner;

public class RemoveConsecutiveDuplicates {

	public static String removeDuplicates(String str)
	{
		if(str.length()<=1)
			return str;
		
		String temp=removeDuplicates(str.substring(1));
		String ans="";
		if(str.charAt(0)==temp.charAt(0))
			ans=temp;
		else
			ans=str.charAt(0)+temp;
		return ans;
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=s.nextLine();
		str=removeDuplicates(str);
		System.out.println(str);
		s.close();
	}

}
