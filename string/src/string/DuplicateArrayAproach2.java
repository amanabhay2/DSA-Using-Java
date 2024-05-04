package string;

import java.util.Scanner;

public class DuplicateArrayAproach2 {
	
	public static void print(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public static void sort(int[] arr)
	{
		int size=arr.length;
		for(int i=1;i<size;i++)
		{
			for(int j=i;j>0;j--)
			{
				if(arr[j-1]>arr[j])
				{
					int temp=arr[j-1];
					arr[j-1]=arr[j];
					arr[j]=temp;
				}
			}
		}
	}
	public static int findDuplicate(int[] arr)
	{
		for(int i=0;i<arr.length-1;i++)
		{
			if(arr[i]==arr[i+1])
				return arr[i];
		}
		return -1;
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
			sort(arr);
			print(arr);
			int duplicate=findDuplicate(arr);
			System.out.println(duplicate);
		}

	}

}
