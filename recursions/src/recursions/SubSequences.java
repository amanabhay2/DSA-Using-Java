package recursions;

import java.util.Scanner;

public class SubSequences {

	public static String[] allSubSequences(String str)
	{
		if(str.length()==0)
		{
			String a[]= {""};
			return a;
		}
		String b[]=allSubSequences(str.substring(1));
		String ans[]=new String[2*b.length];
		int k=0;
		for(int i=0;i<b.length;i++)
		{
			ans[k]=b[i];
			k++;
		}
		for(int i=0;i<b.length;i++)
		{
			ans[k]=str.charAt(0)+b[i];
			k++;
		}
		return ans;
	}
	public static void allSubSequences2(String str,String output)
	{
		if(str.length()==0) {
			System.out.println(output);
			return;
		}
		allSubSequences2(str.substring(1), output+str.charAt(0));
		allSubSequences2(str.substring(1), output);
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=s.nextLine();
		//String sub[]=allSubSequences(str);
		//for(int i=0;i<sub.length;i++)
		//{
		//	System.out.println(sub[i]);
		//}
		allSubSequences2(str,"");
		s.close();
	}

}
