package string;

import java.util.Scanner;

public class PermutationString {

	public static boolean permutationString(String str1,String str2)
	{
		int[] arr=new int[256];
		for(int i=0;i<str1.length();i++)
		{
			arr[str1.charAt(i)]++;
		}
		for(int i=0;i<str2.length();i++)
		{
			arr[str2.charAt(i)]--;
		}
		for(int i=0;i<256;i++)
		{
			if(arr[i]!=0)
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str1=s.nextLine();
		String str2=s.nextLine();
		boolean permutable=permutationString(str1,str2);
		System.out.println(permutable);		
		s.close();
	}

}
