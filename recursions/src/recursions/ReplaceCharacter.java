package recursions;

import java.util.Scanner;

public class ReplaceCharacter {

	public static String replacec1withc2(String str,char c1,char c2)
	{
		if(str.length()==0)
			return str;
		String ans="";
		if(str.charAt(0)==c1)
			ans=ans+c2;
		else
			ans=ans+str.charAt(0);
		return ans+	replacec1withc2(str.substring(1),c1,c2);	
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=s.nextLine();
		char c1=s.next().charAt(0);
		char c2=s.next().charAt(0);
		str=replacec1withc2(str,c1,c2);
		System.out.println(str);
		s.close();
	}

}
