package basics;

import java.util.Scanner;

public class starPattern {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		
		for(int i=1;i<=n;i++)
		{
			for(int j=n-i+2;j>=1;j--)
			{
				System.out.print(" ");
			}
			for(int j=1;j<2*i;j++)
			{
				System.out.print("*");
			}
			System.out.println();
			
		}

	}

}
