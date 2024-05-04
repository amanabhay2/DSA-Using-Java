package string;
import java.util.Scanner;
public class AllSubstrings {

	public static void allSubString2(String str)
	{
		int end=0;
		for(int i=0;i<=str.length();i++)
		{
			for(int j=0;j<=str.length()-i;j++)
			{
				end=j+i;
				System.out.println(str.substring(j, end));
			}
		}
	}
	
	public static void allSubString(String str)
	{
		for(int i=0;i<str.length();i++)
		{
			for(int j=i;j<str.length();j++)
			{
				System.out.println(str.substring(i, j+1));
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=s.nextLine();
		allSubString2(str);
		

	}

}
