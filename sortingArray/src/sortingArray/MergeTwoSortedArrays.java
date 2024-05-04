package sortingArray;

import java.util.Scanner;

public class MergeTwoSortedArrays {

	public static void print(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}
	
	public static int[] mergeTwoSortedArrays(int[] arr1,int[] arr2)
	{
		int newArraySize=arr1.length+arr2.length;
		int counter1=0,counter2=0;
		int[] newArray=new int[newArraySize];
		
		for(int i=0;i<newArraySize;i++)
		{
			if(counter1==arr1.length)
			{
				newArray[i]=arr2[counter2];
				counter2++;
			}
			else if(counter2==arr2.length)
			{
				newArray[i]=arr1[counter1];
				counter1++;
			}
			else if(arr1[counter1]<=arr2[counter2])
			{
				newArray[i]=arr1[counter1];
				counter1++;
			}
			else
			{
				newArray[i]=arr2[counter2];
				counter2++;
			}
		}
		
		
		return newArray;
	}
	
	
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		for(int k=1;k<=n;k++)
		{
		
		//System.out.println("Enter first sorted Array");
		int size1=s.nextInt();
		int[] arr1=new int[size1];
		for(int i=0;i<size1;i++)
		{
			arr1[i]=s.nextInt();
		}

		//System.out.println("Enter Second sorted Array");
		int size2=s.nextInt();
		int[] arr2=new int[size2];
		for(int i=0;i<size2;i++)
		{
			arr2[i]=s.nextInt();
		}
		//new array
		
		int[] result=mergeTwoSortedArrays(arr1,arr2);
		
		print(result);
		
		}

	}

}
