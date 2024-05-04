package basics;

import java.util.Scanner;

public class pattern3 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		
		
		
		for(int i=1;i<=n/2;i++)
		{
			//char start=(char)('A'+n);
			for(int j=n/2+1;j>=i;j--)
			{
				System.out.print(" ");
			}
			for(int j=1;j<=i;j++)
			{
				System.out.print("*");
			}
			for(int j=i-1;j>=1;j--)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		for(int i=n/2+1;i>=1;i--)
		{
			//char start=(char)('A'+n);
			for(int j=n/2+1;j>=i;j--)
			{
				System.out.print(" ");
			}
			for(int j=1;j<=i;j++)
			{
				System.out.print("*");
			}
			for(int j=i-1;j>=1;j--)
			{
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
