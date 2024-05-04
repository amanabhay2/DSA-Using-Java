package recursions;

import java.util.Scanner;

public class PrintStringPermutations {

	public static void printPermutations(String str,String output)
	{
		if(str.length()==0)
		{
			System.out.println(output);
			return;
		}
		printPermutations(str.substring(1),output+str.charAt(0));
		for(int i=1;i<str.length();i++)
		{
			printPermutations(str.substring(0,i)+str.substring(i+1),output+str.charAt(i));
		}		
	}
	
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		String str=s.nextLine();
		printPermutations(str,"");
		s.close();
	}

}
