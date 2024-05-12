package dynamicProgramming;

import java.util.Scanner;

public class MinimumStepsToOne {

	public static int minStepsTo1(int n)
	{
		if(n<=1)
			return 0;
		int a=minStepsTo1(n-1);
		int ans=a;
		if(n%3==0)
		{
			int b=minStepsTo1(n/3);
			ans=Math.min(ans, b);
		}
		if(n%2==0)
		{
			int c=minStepsTo1(n/2);
			ans=Math.min(ans, c);
		}
		return 1+ ans;
	}
	public static int minStepsMemory(int n)
	{
		int[] arr=new int[n+1];
		return minStepsMemory(n,arr);
	}
	public static int minStepsMemory(int n,int[] arr)
	{
		if(n==1)
		{
			arr[n]=0;
			return arr[n];
		}
		if(arr[n]!=0)
			return arr[n];
		int min=minStepsMemory(n-1,arr);
		if(n%3==0)
		{
			int b=minStepsMemory(n/3,arr);
			min=Math.min(min, b);
		}
		if(n%2==0)
		{
			int b=minStepsMemory(n/2,arr);
			min=Math.min(min, b);
		}
		arr[n]=1+min;
		return arr[n];
	}
	public static int minDP(int n)
	{
		int[] arr=new int[n+1];
		arr[1]=0;
		for(int i=2;i<=n;i++)
		{
			int a=arr[i-1];
			int min=a;
			if(i%3==0)
			{
				int b=arr[i/3];
				min=Math.min(min, b);
			}
			if(i%2==0)
			{
				int b=arr[i/2];
				min=Math.min(min, b);
			}
			arr[i]=min+1;
		}	
		return arr[n];
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		System.out.println(minDP(n));
		
		System.out.println(minStepsMemory(n));
		
		System.out.println(minStepsTo1(n));
		
		s.close();
	}

}
