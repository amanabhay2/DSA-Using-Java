package sortingArray;

import java.util.Scanner;

public class SelectionSort {

	public static void print(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");;
		}
	}
	public static void selectionsort(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			int min=arr[i],swap,minIndex=i;
			for(int j=i;j<arr.length;j++)
			{
				if(arr[j]<min)
				{
					minIndex=j;
					min=arr[j];
				}
			}
			swap=arr[i];
			arr[i]=arr[minIndex];
			arr[minIndex]=swap;
				
		}
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int size=s.nextInt();
		int[] arr=new int[size];
		for(int i=0;i<size;i++)
		{
			arr[i]=s.nextInt();
		}
		selectionsort(arr);
		print(arr);

	}

}
