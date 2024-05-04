package sortingArray;

import java.util.Scanner;

public class CheckArrayRotation {

	public static void print(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}
	
	public static int checkRotation(int[] arr)
	{
		
		int k=0;
		int temp=arr[0];
		for(int i=1;i<arr.length;i++)
		{
			if(temp>arr[i])
			{
				return i;
			}
		}
		
		
		return k;
	}
	
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		
		for(int i=1;i<=n;i++)
		{
			int size=s.nextInt();
			int[] arr= new int[size];
			for(int j=0;j<size;j++)
			{
				arr[j]=s.nextInt();
			}
			
			int k=checkRotation(arr);
			System.out.println(k);
			
			
		}
	}

}
