package function;

import java.util.Scanner;

public class tripletSum {

	public static int tripletSumCounter(int x,int[] arr)
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
						if((arr[i]+arr[j]+arr[k])==x)
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
			for(int j=0;j<size;j++)
			{
				arr[j]=s.nextInt();
			}
			int sum=s.nextInt();
			int count=tripletSumCounter(sum,arr);
			System.out.println(count);
			
			
		}

	}

}
