package string;

import java.util.Scanner;

public class RowSum {

	public static void printRowWiseSum(int arr[][])
	{
		for(int i=0;i<arr.length;i++)
		{
			int sum=0;
			for(int j=0;j<arr[i].length;j++)
			{
				sum=sum+arr[i][j];
			}
			System.out.print(sum+" ");
		}
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		for(int i=1;i<=n;i++)
		{
			int rows=s.nextInt();
			int cols=s.nextInt();
			int arr[][]=new int[rows][cols];
			for(int j=0;j<rows;j++)
			{
				for(int k=0;k<cols;k++)
				{
					arr[j][k]=s.nextInt();
				}
			}
			printRowWiseSum(arr);
			
		}
		
	}

}
