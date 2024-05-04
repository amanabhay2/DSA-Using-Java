package sortingArray;

import java.util.Scanner;

public class SumOfTwoArrays {

	public static void print(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public static void sumArray(int[] arr1,int[] arr2,int[] sum)
	{
		int num1=0,num2=0,s=0;
		for(int i=0;i<arr1.length;i++)
		{
			num1=num1*10+arr1[i];
		}
		for(int i=0;i<arr2.length;i++)
		{
			num2=num2*10+arr2[i];
		}
		s=num1+num2;
		
		for(int i=sum.length-1;i>=0;i--)
		{
			sum[i]=s%10;
			s=s/10;
		}
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		
		for(int i=1;i<=n;i++)
		{
			int size1=s.nextInt();
			int[] arr1=new int[size1];
			for(int j=0;j<size1;j++)
			{
				arr1[j]=s.nextInt();
			}
			
			int size2=s.nextInt();
			int[] arr2=new int[size2];
			for(int j=0;j<size2;j++)
			{
				arr2[j]=s.nextInt();
			}
			
			int sumSize;
			if(size1>size2)
				sumSize=size1+1;
			else
				sumSize=size2+1;
			
			int[] sum=new int[sumSize];
			
			sumArray(arr1,arr2,sum);
			
			print(sum);
			
		}
	}

}
