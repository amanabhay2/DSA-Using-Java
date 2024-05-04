package string;

import java.util.Scanner;

public class TotalSumOnBoundariesAndDiagonals {

	public static int sumSpecial(int[][] arr)
	{
		int size=arr.length;
		int sum=0;
		
		int rS=0,rE=size-1;
		int cS=0,cE=size-1;
		
		for(int i=cS;i<=cE;i++)
		{
			sum=sum+arr[rS][i];
		}
		
		rS++;
		for(int i=rS;i<=rE;i++)
		{
			sum=sum+arr[i][cE];
		}
		cE--;
		for(int i=cE;i>=cS;i--)
		{
			sum=sum+arr[rE][i];
		}
		rE--;
		for(int i=rE;i>=rS;i--)
		{
			sum=sum+arr[i][cS];
		}
		cS++;
		//System.out.println("FIne");
		for(int i=1;i<size-1;i++)
		{
			for(int j=1;j<size-1;j++)
			{
				if(i==j)
				{
					sum=sum+arr[i][j];
				}
				
				
				if((i+j)==(size-1))
				{
					if(i==j)
						continue;
					else
						sum=sum+arr[i][j];
				}
			}
		}
		return sum;
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		for(int i=1;i<=n;i++)
		{
			int size=s.nextInt();
			int[][] arr2d=new int[size][size];
			for(int j=0;j<size;j++)
			{
				for(int k=0;k<size;k++)
				{
					arr2d[j][k]=s.nextInt();
				}
			}
			
			int sum=sumSpecial(arr2d);
			System.out.println(sum);
		}
	}

}
