
package sortingArray;

import java.util.Scanner;

public class BubbleSort {
	public static void print(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");;
		}
	}
	public static void bubblesort(int[] arr)
	{
		for(int i=(arr.length-1);i>0;i--)
		{
			for(int j=1;j<=i;j++)
			{
				if(arr[j-1]>arr[j])
				{
					int swap=arr[j-1];
					arr[j-1]=arr[j];
					arr[j]=swap;
				}
			}
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
		bubblesort(arr);
		print(arr);
	}

}
