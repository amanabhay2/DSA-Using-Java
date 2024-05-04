package function;

import java.util.Scanner;

public class arrangeArray {

	public static int[] arrange(int x)
	{
		int arr[]=new int[x];
		int j=x-1,number=1;
		int i=0;
		for(;i<j;i++)
		{
			arr[i]=number;
			number++;
			arr[j]=number;
			number++;
			j--;
		}
		if(i==j)
			arr[i]=number;
		
		return arr;
	}
	
	public static void print(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		
		for(int i=1;i<=n;i++)
		{
			int size=s.nextInt();
			int arr[]=arrange(size);
			print(arr);
		}

	}

}
