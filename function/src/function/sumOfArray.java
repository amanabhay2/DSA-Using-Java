package function;

import java.util.Scanner;

public class sumOfArray {

	public static int sum(int[] x)
	{
		int sum=0;
		for(int i=0;i<x.length;i++)
			sum=sum+x[i];
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		
		for(int i=1;i<=n;i++)
		{
			int size=s.nextInt();
			int arr[]=new int[size];
			for(int j=0;j<size;j++)
			{
				arr[j]=s.nextInt();
			}
			
			int sum=sum(arr);
			System.out.println(sum);
		}

	}

}
