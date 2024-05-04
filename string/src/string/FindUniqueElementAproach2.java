package string;

import java.util.Scanner;

public class FindUniqueElementAproach2 {

	public static int[] sort(int[] arr)
	{
		int size=arr.length;
		for(int i=1;i<size;i++)
		{
			for(int j=i;j>0;j--)
			{
				if(arr[j-1]>arr[j])
				{
					int swap=arr[j-1];
					arr[j-1]=arr[j];
					arr[j]=swap;
				}
			}
		}
		return arr;
	}
	
	public static void print(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	
	public static int uniqueElement(int[] arr)
	{
		int i=0;
		for(;i<arr.length-1;i=i+2)
		{
			if(arr[i]!=arr[i+1])
				return i;
		}
		if(i==arr.length-1)
			return i;
		
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
			arr=sort(arr);
			print(arr);
			int unique=uniqueElement(arr);
			System.out.println(unique);
		}
		s.close();

	}

}
