package recursions;

import java.util.Scanner;

public class CheckPalindrome {

	public static boolean checkPalindrome(String str,int start,int end)
	{
		if(str.length()<=1)
			return true;
		if(str.charAt(start)!=str.charAt(end))
			return false;
		boolean status=true;
		if(start+1<end-1)
		{
			status=checkPalindrome(str,start+1,end-1);
		}
		
		return status;
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=s.nextLine();
		boolean check=checkPalindrome(str,0,str.length()-1);
		System.out.println(check);
		s.close();
	}

}
