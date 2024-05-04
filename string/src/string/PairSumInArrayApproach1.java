package string;

import java.util.Scanner;

public class PairSumInArrayApproach1 {

	public static int getPairSum(int[] arr,int key)
	{
		int count=0;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr.length;j++)
			{
				if(i==j)
					continue;
				if((arr[i]+arr[j])==key)
					count++;
			}
		}
		
		return count/2;
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
			int key=s.nextInt();
			
			int pairSum=getPairSum(arr,key);
			System.out.println(pairSum);
		}
	}

}
