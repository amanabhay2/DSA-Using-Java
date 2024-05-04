package recursions;

import java.util.Scanner;

public class ReturnSubsetSumToK {

	
	
	public static int[][] getSubsetsWhichSumToK(int[] arr,int k,int start)
	{
		if(start==arr.length)
		{
			if(k==0)
			{
				int [][] output=new int [1][0];
				return output;
			}
			else
			{
				int [][] output=new int [0][0];
				return output;
			}
		}
		
		
		int[][] temp1=getSubsetsWhichSumToK(arr,k-arr[start],start+1);
		int[][] temp3=new int[temp1.length][];
		for(int i=0;i<temp1.length;i++)
		{
			temp3[i]=new int[temp1[i].length+1];
			temp3[i][0]=arr[start];
			for(int j=1;j<temp1[i].length;j++)
			{
				temp3[i][j]=temp1[i][j-1];
			}
		}
		int[][] temp2=getSubsetsWhichSumToK(arr,k,start+1);
		int[][] output=new int[temp3.length+temp2.length][];
		int t=0;
		
		for(int i=0;i<temp3.length;i++)
		{
			output[t]=temp3[i];
			t++;
		}
		for(int i=0;i<temp2.length;i++)
		{
			output[t]=temp2[i];
			t++;
		}
		
		return output;
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int size=s.nextInt();
		int[] arr=new int[size];
		for(int i=0;i<size;i++)
		{
			arr[i]=s.nextInt();
		}
		int k=s.nextInt();
		
		int[][] subsets=getSubsetsWhichSumToK(arr,k,0);
		
		for(int i=0;i<subsets.length;i++)
		{
			int b=subsets[i].length;
			for(int j=0;j<b;j++)
			{
				System.out.print(subsets[i][j]+" ");
			}
			System.out.println();
		}
		s.close();
	}

}
