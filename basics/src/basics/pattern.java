package basics;

import java.util.Scanner;

public class pattern {

	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		//int counter=1;
		for(int i=1;i<=n;i++)
		{
			
			for(int j=1;j<=i;j++)
			{
				System.out.print("*");
			}
			
			for(int j=1;j<=2*n-2*i;j++)
			{
				System.out.print(" ");
			}
			
			for(int j=1;j<=i;j++)
			{
				System.out.print("*");
				//System.out.print(counter);
				//counter++;
			}
			System.out.println();
		}

	}

}
