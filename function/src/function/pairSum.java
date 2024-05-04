package function;

import java.util.Scanner;

public class pairSum {
	
	public static int pairCounter(int x,int[] arr)
	{
		int counter=0;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr.length;j++)
			{
				if(i==j)
					continue;
				if((arr[i]+arr[j])==x)
					counter++;
			}
		}
		
		
		
		return counter/2;
	}

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		for(int i=1;i<=n;i++)
		{
			int size=s.nextInt();
			int[] arr=new int[size];
			for(int j=0;j<size;j++)
			{
				arr[j]=s.nextInt();
			}
			int sum=s.nextInt();
			int pair=pairCounter(sum,arr);
			System.out.println(pair);
		}

	}

}
