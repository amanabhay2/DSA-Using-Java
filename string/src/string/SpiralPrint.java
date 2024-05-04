package string;

import java.util.Scanner;

public class SpiralPrint {

	public static void spiralPrinting(int[][] arr)
	{
		
		int row=arr.length;
		if(row==0)
			return;
		int col=arr[0].length;
		
		int rowS=0;		int rowE=row-1;
		int colS=0;		int colE=col-1;
		
		
		for(int i=1;i<=col*row;)
		{
			
			
			for(int j=colS;j<=colE;j++)
			{
				System.out.print(arr[rowS][j]+" ");
				i++;
			}
			rowS++;
			
			for(int j=rowS;j<=rowE;j++)
			{
				System.out.print(arr[j][colE]+" ");
				i++;
			}
			colE--;
			
			for(int j=colE;j>=colS;j--)
			{
				System.out.print(arr[rowE][j]+" ");
				i++;
			}
			rowE--;
			if((i<=col*row)==false)
				break;
			for(int j=rowE;j>=rowS;j--)
			{
				System.out.print(arr[j][colS]+" ");
				i++;
			}
			colS++;
			
		}
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		for(int i=1;i<=n;i++)
		{
			int rows=s.nextInt();
			int cols=s.nextInt();
			int[][] arr=new int[rows][cols];
			for(int k=0;k<rows;k++)
			{
				for(int j=0;j<cols;j++)
				{
					arr[k][j]=s.nextInt();
				}
			}
			spiralPrinting(arr);
			System.out.println();
		}
	}

}
