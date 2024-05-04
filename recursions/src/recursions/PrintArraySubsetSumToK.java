package recursions;

import java.util.Scanner;

public class PrintArraySubsetSumToK {
	
	public static void printArraySumToK(int[] arr,int start,int k,int[] output,int kOriginal)
	{
		if(start==arr.length)
		{
			int sum=0;
			for(int i=0;i<output.length;i++)
			{
				sum=sum+output[i];
			}
			if(sum==kOriginal)
			{
				for(int i=0;i<output.length;i++)
				{
					System.out.print(output[i]+" ");
				}
				System.out.println();
			}
			return;
		}
		int[] temp=new int[output.length+1];
		int i=0;
		for(;i<output.length;i++)
		{
			temp[i]=output[i];
		}
		temp[i]=arr[start];
		printArraySumToK(arr,start+1,k,output,kOriginal);
		printArraySumToK(arr,start+1,k-arr[start],temp,kOriginal);
	}

	public static void printArraySumToK(int[] arr,int k)
	{
		int[] output=new int[0];
		printArraySumToK(arr,0,k,output,k);
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
		printArraySumToK(arr,t);
		s.close();
	}

}
