package sortingArray;

import java.util.Scanner;

public class Binary {

	public static int binarySearch(int target,int[] arr)
	{
		
		int start=0,end=arr.length-1;
		int mid=(start+end)/2;
		for(int i=0;i<=end;i++)
		{
			//System.out.println("hi there");
			mid=(start+end)/2;
			
			if(arr[mid]==target)
				return mid;
			else if(arr[mid]>target)
			{
				end=mid-1;
			}
			else if(arr[mid]<target)
			{
				start=mid+1;
			}
			
		}	
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int size=s.nextInt();
		int[] arr=new int[size];
		
		for(int i=0;i<size;i++)
		{
			arr[i]=s.nextInt();
		}
		int t=s.nextInt();
		
		for(int i=1;i<=t;i++)
		{
			int target=s.nextInt();
			int index=binarySearch(target,arr);
			System.out.println(index);
		}
		

	}

}
