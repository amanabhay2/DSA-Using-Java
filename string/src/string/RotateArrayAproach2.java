package string;

import java.util.Scanner;

public class RotateArrayAproach2 {

	public static void reverse(int[] arr,int start,int end)
	{
		while(start<end)
		{
			int temp=arr[start];
			arr[start]=arr[end];
			arr[end]=arr[start];
			start++;
			end--;
		}
	}
	public static void print(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public static void rotate(int[] arr,int R)
	{
		int size=arr.length;
		reverse(arr,0,size-1);
		reverse(arr,0,size-1-R);
		reverse(arr,size-R,size-1);
		
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		for(int i=1;i<=n;i++)
		{
			int size=s.nextInt();
			int[] arr=new int[size];
			for(int k=0;k<size;k++)
			{
				arr[k]=s.nextInt();
			}
			int R=s.nextInt();
			rotate(arr,R);
			print(arr);
		}
	}

}
