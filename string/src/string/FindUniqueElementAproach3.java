package string;

import java.util.Scanner;

public class FindUniqueElementAproach3 {

	public static int uniqueElement(int[] arr)
	{
		int element=arr[0];
		for(int i=1;i<arr.length;i++)
		{
			element=element^arr[i];
		}
		return element;
	}
	public static void print(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
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
			
			
			int element=uniqueElement(arr);
			System.out.println(element);
		}
		s.close();

	}

}
