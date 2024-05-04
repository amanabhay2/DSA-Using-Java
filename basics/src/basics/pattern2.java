package basics;

import java.util.Scanner;

public class pattern2 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int var;
		for(int i=1;i<=n;i++)
		{
			var=i;
			
			for(int j=3*n-2*i;j>=1;j--)
			{
				System.out.print(" ");
			}
			
			for(int j=1;j<=i;j++)
			{
				System.out.print(var);
				var++;
			}
			System.out.println();
		}

	}

}
