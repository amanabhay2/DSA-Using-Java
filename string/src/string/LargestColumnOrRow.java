package string;

import java.util.Scanner;

public class LargestColumnOrRow {

	public static void largestColOrRow(int arr[][])
	{
		int largest=Integer.MIN_VALUE,sumIndex=-1;
		String in="";
		
		for(int i=0;i<arr.length;i++)
		{
			int sum=0;
			for(int j=0;j<arr[0].length;j++)
			{
				sum=sum+arr[i][j];
			}
			if(sum>largest)
			{
				largest=sum;
				sumIndex=i;
				in="Row";
			}
		}
		for(int i=0;i<arr[0].length;i++)
		{
			int sum=0;
			for(int j=0;j<arr.length;j++)
			{
				sum=sum+arr[j][i];
			}
			if(sum>largest)
			{
				largest=sum;
				sumIndex=i;
				in="Column";
			}
		}
		System.out.println(in+" "+sumIndex+" "+largest);
		
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
			largestColOrRow(arr);
			
		}

	}

}
