package sortingArray;

import java.util.Scanner;

public class allZerosToEnd {
	
	public static void print(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int i=1;i<=t;i++)
		{
			int size=s.nextInt();
			int[] arr=new int[size];
			int place=size-1,counter=0;
			for(int j=0;j<size;j++)
			{
				int x=s.nextInt();
				if(x==0)
				{
					arr[place]=x;
					place--;
				}
				else
				{
					arr[counter]=x;
					counter++;
				}
			}
		
		
		
			print(arr);
		}

	}

}
