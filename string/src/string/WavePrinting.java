package string;

import java.util.Scanner;

public class WavePrinting {

	public static void wavePrinting(int[][] arr)
	{
		for(int i=0;i<arr[0].length;i++)
		{
			if(i%2!=0)
			{
				for(int j=arr.length-1;j>=0;j--)
				{
					System.out.print(arr[j][i]+" ");
				}
			}
			else
			{
				for(int j=0;j<arr.length;j++)
				{
					System.out.print(arr[j][i]+" ");
				}
			}
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		for(int i=1;i<=n;i++)
		{
			int rows=s.nextInt();
			int cols=s.nextInt();
			int[][] arr=new int[rows][cols];
			for(int k=0;k<rows;k++)
			{
				for(int j=0;j<cols;j++)
				{
					arr[k][j]=s.nextInt();
				}
			}
			wavePrinting(arr);
			
		}

	}

}
