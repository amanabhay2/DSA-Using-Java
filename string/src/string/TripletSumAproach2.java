package string;

import java.util.Scanner;
import java.util.Arrays;
public class TripletSumAproach2 {

	public static int pairSum(int [] arr,int start,int end,int key)
	{
		int pairCount=0;
		while(start<end)
		{
			if((arr[start]+arr[end])>key)
				end--;
			else if((arr[start]+arr[end])<key)
				start++;
			else
			{
				if(arr[start]==arr[end])
				{
					int temp=end-start+1;
					pairCount=pairCount+temp*(temp-1)/2;
					return pairCount;
				}
				
				int tempStart=start+1;
				int tempEnd=end-1;
				while(tempStart>end&&arr[tempStart]==arr[start])
				{
					tempStart++;
				}
				while(tempEnd<start&&arr[tempEnd]==arr[end])
				{
					tempEnd--;
				}
				pairCount=pairCount+(tempStart-start)*(end-tempEnd);
				start=tempStart;
				end=tempEnd;
			}			
		}		
		return pairCount;				
	}
	public static int tripletSumCounter(int[] arr,int key)
	{
		int counter=0;
		Arrays.sort(arr);
		int n=arr.length;
		for(int i=0;i<n;i++)
		{
			int pairSum=key-arr[i];
			int pairCount=pairSum(arr,i+1,n-1,pairSum);
			counter=counter+pairCount;
		}
		
		return counter;
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
			
			int tripletCount=tripletSumCounter(arr,key);
			System.out.println(tripletCount);
		}
	}

}
