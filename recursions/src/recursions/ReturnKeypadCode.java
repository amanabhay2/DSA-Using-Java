package recursions;

import java.util.Scanner;

public class ReturnKeypadCode {

	public static String[] getString(int x)
	{
		if(x==0||x==1)
		{
			System.exit(0);
		}
		if(x==2)
		{
			String output[]= {"a","b","c"};
			return output;
		}
		else if(x==3)
		{
			String output[]= {"d","e","f"};
			return output;
		}
		else if(x==4)
		{
			String output[]= {"g","h","i"};
			return output;
		}
		else if(x==5)
		{
			String output[]= {"j","k","l"};
			return output;
		}
		else if(x==6)
		{
			String output[]= {"m","n","o"};
			return output;
		}
		else if(x==7)
		{
			String output[]= {"p","q","r","s"};
			return output;
		}
		else if(x==8)
		{
			String output[]= {"t","u","v"};
			return output;
		}
		else
		{
			String output[]= {"w","x","y","z"};
			return output;
		}
		
		
		
	}
	public static String[] getKeypadCodes(int n)
	{
		if(n==0)
		{
			String a[]= {""};
			return a;
		}
		String shortAns[]=getKeypadCodes(n/10);
		
		int k=0;
		String temp[]=getString(n%10);
		String ans[]=new String[temp.length*shortAns.length];
		for(int i=0;i<temp.length;i++)
		{
			for(int j=0;j<shortAns.length;j++)
			{
				ans[k]=shortAns[j]+temp[i];
				k++;
			}
		}
		return ans;		
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		String codes[]=getKeypadCodes(n);
		for(int i=0;i<codes.length;i++)
		{
			System.out.println(codes[i]);
		}
		
		s.close();
	}

}
