package recursions;
import java.util.Scanner;
public class NQueen {

	public static boolean boardSafe(int[][] arr,int row,int col)
	{
		int n=arr.length;
		for(int i=row+1, j=col+1;i<n&&j<n;i++,j++)
		{
			if(arr[i][j]==1)
				return false;
		}
		for(int i=row-1, j=col-1;i>=0&&j>=0;i--,j--)
		{
			if(arr[i][j]==1)
				return false;
		}
		for(int i=row-1, j=col+1;i>=0&&j<n;i--,j++)
		{
			if(arr[i][j]==1)
				return false;
		}
		for(int i=row+1, j=col-1;i<n&&j>=0;i++,j--)
		{
			if(arr[i][j]==1)
				return false;
		}
		for(int i=row, j=col-1;j>=0;j--)
		{
			if(arr[i][j]==1)
				return false;
		}
		for(int i=row, j=col+1;j<n;j++)
		{
			if(arr[i][j]==1)
				return false;
		}
		for(int i=row-1, j=col;i>=0;i--)
		{
			if(arr[i][j]==1)
				return false;
		}
		for(int i=row+1, j=col;i<n;i++)
		{
			if(arr[i][j]==1)
				return false;
		}
		
		
		return true;
	}
	public static void printNQueen(int[][] arr,int row,int n)
	{
		if(row==n)
		{
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println();
			return;
		}
		int col=0;
		while(col<n)
		{
			if(boardSafe(arr,row,col))
			{
				arr[row][col]=1;
				printNQueen(arr,row+1,n);
				arr[row][col]=0;
			}
			col++;
		}
		
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int[][] arr=new int[n][n];
		printNQueen(arr,0,n);
		s.close();
	}

}
