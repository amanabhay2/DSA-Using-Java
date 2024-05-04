package function;

import java.util.Scanner;


public class sortedArray {

	public static void printSortedArray(int[] arr)
	{
		int position=0;
		int swap;
		for(int i=0;i<arr.length;i++)
		{
			if(i==0)
				continue;
			if(arr[i]==0)
			{
				swap=arr[i];
				arr[i]=arr[position];
				arr[position]=swap;
				position++;
			}
			
		}
		for(int j=0;j<arr.length;j++)
		{
			System.out.print(arr[j]+" ");
		}
		System.out.println();
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
			
			printSortedArray(arr);
		}

	}

}
