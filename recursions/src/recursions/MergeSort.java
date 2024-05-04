package recursions;

import java.util.Scanner;

public class MergeSort {

	public static void merge(int[] arr,int start,int end)
	{
		int mid=(start+end)/2;
		int[] arr2=new int[end-start+1];
		int i1=start; int i2=mid+1;
		for(int i=0;i<arr2.length;i++)
		{
			if(i1==mid+1)
			{
				arr2[i]=arr[i2];
				i2++;
				continue;
			}
			if(i2==end+1)
			{
				arr2[i]=arr[i1];
				i1++;
				continue;
			}
			if(arr[i1]<=arr[i2])
			{
				arr2[i]=arr[i1];
				i1++;
			}
			else
			{
				arr2[i]=arr[i2];
				i2++;
			}
		}
		
		int copy=0;
		for(int i=start;i<=end;i++)
		{
			arr[i]=arr2[copy];
			copy++;
		}
	}
	
	public static void mergeSort(int[] arr,int start,int end)
	{
		if(start==end)
			return;
		int mid=(start+end)/2;
		mergeSort(arr,start,mid);
		mergeSort(arr,mid+1,end);
		merge(arr,start,end);
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int size=s.nextInt();
		int[] arr=new int[size];
		for(int i=0;i<size;i++)
		{
			arr[i]=s.nextInt();
		}
		mergeSort(arr,0,size-1);
		for(int i=0;i<size;i++)
		{
			System.out.printf(arr[i]+" ");
		}
		s.close();
	}

}
