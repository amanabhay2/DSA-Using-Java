package string;

import java.util.Scanner;

public class TripletSumAproach1 {

	public static int tripletSumCounter(int[] arr,int key)
	{
		int counter=0;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr.length;j++)
			{
				for(int k=0;k<arr.length;k++)
				{
					if(i!=j&&i!=k&&j!=k)
					{
						if((arr[i]+arr[j]+arr[k])==key)
							counter++;
					}
				}
			}
		}
		
		return counter/6;
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
