package string;

import java.util.Scanner;
import java.util.Arrays;

public class PairSumInARrayAproach2 {

	public static int getPairSum(int[] arr,int key)
	{
		Arrays.sort(arr);
		int count=0;
		int Sindex=0;
		int Eindex=arr.length-1;
		while(Sindex<Eindex)
		{
			if((arr[Sindex]+arr[Eindex])<key)
				Sindex++;
			else if((arr[Sindex]+arr[Eindex])>key)
				Eindex--;
			else
			{
				if(arr[Sindex]==arr[Eindex])
				{
					int n=Eindex-Sindex+1;
					count=count+(n-1)*n/2;
					return count;
				}
				
				int tempStartIndex=Sindex+1;
				int tempEndIndex=Eindex-1;
				
				while(tempStartIndex<Eindex&&arr[tempStartIndex]==arr[Sindex])
				{
					tempStartIndex++;
				}
				while(tempEndIndex>Sindex&&arr[tempEndIndex]==arr[Eindex])
				{
					tempEndIndex++;
				}
				
				int n=(tempStartIndex-Sindex)*(tempEndIndex-Eindex);
				count=count+n;
				
				
				Sindex=tempStartIndex;
				Eindex=tempEndIndex;
			}
		}
		
		return count;
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
