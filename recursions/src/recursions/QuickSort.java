package recursions;

import java.util.Scanner;

public class QuickSort {
	public static void swap(int[] arr,int p1,int p2)
	{
		int temp=arr[p1];
		arr[p1]=arr[p2];
		arr[p2]=temp;
	}

	public static int partition(int[] arr,int start,int end)
	{
		int pos=start;
		int count=0;
		for(int i=start;i<=end;i++)
		{
			if(arr[i]<arr[pos])
				count++;
		}
		pos=start+count;
		swap(arr,start,pos);
		
		//By now pivot is at the right position (pos)
		
		int i=start;   int j=end;
		
		while((i<pos-1)&&(j>pos+1))
		{
			if(arr[i]<arr[pos])
			{
				i++;
			}
			else
			{
				if(arr[j]>arr[pos])
				{
					j--;
				}
				else
				{
					swap(arr,i,j);
					i++;
					j--;
				}
			}
		}
		
		
		
		
		
		
		
		
		return pos;
	}
	
	
	public static void quickSort(int[] arr,int start,int end)
	{
		if(start==end)
			return;
		int pivotPos=partition(arr,start,end);
		
		quickSort(arr,start,pivotPos-1);
		quickSort(arr,pivotPos+1,end);
	}
	
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int size=s.nextInt();
		int[] arr=new int[size];
		for(int i=0;i<size;i++)
		{
			arr[i]=s.nextInt();
		}
		
		quickSort(arr,0,size-1);
		
		for(int i=0;i<size;i++)
		{
			System.out.print(arr[i]+" ");
		}
		s.close();

	}

}
