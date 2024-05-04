package recursions;

import java.util.Scanner;

public class PairStar {

	public static String putStar(String str)
	{
		if(str.length()==1)
			return str;
		if(str.charAt(0)==str.charAt(1))
			str=str.charAt(0)+"*"+str.substring(1);
		
		
		return str.charAt(0)+putStar(str.substring(1));
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=s.nextLine();
		str=putStar(str);
		System.out.println(str);
		s.close();

	}

}
