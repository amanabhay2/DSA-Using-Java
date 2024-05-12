package dynamicProgramming;

import java.util.Scanner;

public class Fibonacci {

	public static int fib(int n)
	{
		if(n==0||n==1)
			return n;
		return fib(n-1)+fib(n-2);
	}
	public static int fibBetter(int n)
	{
		int[] array=new int[n+1];
		for(int i=0;i<=n;i++)
		{
			array[i]=-1;
		}
		return fibBetter(n,array);
	}
	public static int fibBetter(int n,int[] arr)
	{
		if(n==0||n==1)
		{
			arr[n]=n;
			return arr[n];
		}
		if(arr[n]!=-1)
			return arr[n];
		arr[n]=fibBetter(n-1,arr)+fibBetter(n-2,arr);
		return arr[n];
	}
	//fibnacci dp
	public static int fibDP(int n)
	{
		int[] arr=new int[n+1];
		arr[0]=0;
		arr[1]=1;
		for(int i=2;i<=n;i++)
		{
			arr[i]=arr[i-1]+arr[i-2];
		}
		return arr[n];
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter which fibonacci you want");
		int n=s.nextInt();
		System.out.println(fibBetter(n));
		System.out.println(fib(n));
		
		
		s.close();
	}

}
