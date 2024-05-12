package dynamicProgramming;

import java.util.Scanner;

public class ByteLandian {

	public static int countR(int n)
	{
		if(n==0)
			return 0;
		
		int sum=0;
		int a=countR(n/2);
		int b=countR(n/3);
		int c=countR(n/4);
		sum=a+b+c;
		if(n>sum)
			return n;
		else 
			return sum;
	}
	public static int countM(int n)
	{
		int[] arr=new int[n+1];
		return countM(n,arr);
	}
	public static int countM(int n,int[] arr)
	{
		if(n==0)
			return arr[0];
		if(arr[n]!=0)
			return arr[n];
		int sum=0;
		int a=countM(n/2);
		int b=countM(n/3);
		int c=countM(n/4);
		sum=a+b+c;
		if(n>sum)
			arr[n]= n;
		else 
			arr[n]= sum;
		
		
		return arr[n];
	}
	public static int countDP(int n)
	{
		int[] arr=new int[n+1];
		for(int i=1;i<=n;i++)
		{
			int sum=0;
			int a=arr[i/2];
			int b=arr[i/3];
			int c=arr[i/4];
			sum=a+b+c;
			if(i>sum)
				arr[i]= i;
			else 
				arr[i]= sum;
		}
		return arr[n];
	}
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		System.out.println("Integer on the Coin");
		int n=s.nextInt();

		System.out.println("Max Dollars $ are "+countDP(n));

		System.out.println("Max Dollars $ are "+countM(n));
		
		System.out.println("Max Dollars $ are "+countR(n));
		
		s.close();
	}

}
