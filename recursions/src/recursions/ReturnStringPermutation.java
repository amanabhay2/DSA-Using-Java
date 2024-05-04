package recursions;

import java.util.Scanner;

public class ReturnStringPermutation {

	public static int fact(int n)
	{
		if(n==1)
			return 1;
		return n*fact(n-1);
	}
	public static String[] getAllPermutations(String str)
	{
		if(str.length()==0)
		{
			String[] o= {""};
			return o;
		}
		String[] output=new String[fact(str.length())];
		int k=0;
		String[] temp1= {""};
		temp1=getAllPermutations(str.substring(1));
		for(int i=0;i<temp1.length;i++)
		{
			output[k]=str.charAt(0)+temp1[i];
			k++;
		}
		
		for(int i=1;i<str.length();i++)
		{
			String[] temp2=getAllPermutations(str.substring(0,i)+str.substring(i+1));
			for(int j=0;j<temp2.length;j++)
			{
				output[k]=str.charAt(i)+temp2[j];
				k++;
			}
		}
		
		
		
		return output;
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=s.nextLine();
		String[] permutations=getAllPermutations(str);
		for(int i=0;i<permutations.length;i++)
		{
			System.out.println(permutations[i]);
		}
		s.close();
	}

}
