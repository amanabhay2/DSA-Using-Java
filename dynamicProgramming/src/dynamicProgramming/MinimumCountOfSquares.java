package dynamicProgramming;

import java.util.Scanner;

public class MinimumCountOfSquares {

	public static int minCountR(int n)
	{
		if(n==0)
			return 0;
		
		int min=n;
		for(int i=1;i*i<=n;i++)
		{
			int b=minCountR(n-i*i);
			min=Math.min(min, b);
		}
		return 1+min;
	}
	public static int minCountM(int n)
	{
		int[] arr=new int[n+1];
		return minCountM(n,arr);
	}
	public static int minCountM(int n,int[] arr)
	{
		if(n==0)
			return arr[0];
		if(arr[n]!=0)
			return arr[n];
		int min=n;
		for(int i=1;i*i<=n;i++)
		{
			int b=minCountM(n-i*i,arr);
			min=Math.min(min, b);
		}
		arr[n]= 1+min;
		
		return arr[n];
	}
	public static int minCountDP(int n)
	{
		int[] arr=new int[n+1];
		for(int i=1;i<=n;i++)
		{
			int min=n;
			for(int j=1;j*j<=i;j++)
			{
				min=Math.min(min, arr[i-j*j]);
			}
			arr[i]= 1+min;
		}		
		return arr[n];
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		
		System.out.println(minCountDP(n));
		
		System.out.println(minCountM(n));
		
		System.out.println(minCountR(n));
		
		s.close();
	}

}
