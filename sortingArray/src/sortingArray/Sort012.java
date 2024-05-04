package sortingArray;

import java.util.Scanner;

public class Sort012 {

	public static void print(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}
	public static void sort(int index0,int[] arr)
	{
		for(int i=index0;i<arr.length;i++)
		{
			if(arr[i]==1)
			{
				int swap=arr[i];
				arr[i]=arr[index0];
				arr[index0]=swap;
				index0++;
			}
		}
		
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		for(int i=1;i<=n;i++)
		{
			int size=s.nextInt();
			int[] arr=new int[size];
			int place=size-1,index0=0;
			for(int j=0;j<size;j++)
			{
				int x=s.nextInt();
				if(x!=0)
				{
					arr[place]=x;
					place--;
				}
				else
				{
					arr[index0]=x;
					index0++;
				}
			}
			
			sort(index0,arr);
			print(arr);
			System.out.println();
		}

	}

}
