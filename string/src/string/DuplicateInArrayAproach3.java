package string;

import java.util.Scanner;

public class DuplicateInArrayAproach3 {

	public static int findDuplicate(int[] arr)
	{
		int n=arr.length;
		int sum=0;
		for(int i=0;i<n;i++)
		{
			sum=sum+arr[i];
		}
		for(int i=0;i<n-1;i++)
		{
			sum=sum-i;
		}
		return sum;	
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
			
			int duplicate=findDuplicate(arr);
			System.out.println(duplicate);
		}

	}

}
