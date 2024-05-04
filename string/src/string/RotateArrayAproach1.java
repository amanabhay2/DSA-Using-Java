package string;

import java.util.Scanner;

public class RotateArrayAproach1 {

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
		for(int i=0;i<R;i++)
		{
			int shift=arr[0];
			for(int j=1;j<arr.length;j++)
			{
				arr[j-1]=arr[j];
			}
			arr[arr.length-1]=shift;
		}
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
