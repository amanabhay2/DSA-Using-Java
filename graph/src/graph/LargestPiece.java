package graph;

import java.util.Scanner;

public class LargestPiece {
	static int x[]= {0,-1,0,1};
	static int y[]= {1,0,-1,0};
	
	public static int countOnLargestPiece(int[][] cake)
	{
		//largest,i,j
		int largest= Integer.MIN_VALUE;
		for(int i=0;i<cake.length;i++)
		{
			for(int j=0;j<cake.length;j++)
			{
				if(cake[i][j]==1)
				{
					boolean[][] visited=new boolean[cake.length][cake.length];
					int temp=countHelper(cake,i,j,visited);
					if(temp>largest)
					{
						largest=temp;
					}
				}
			}
		}
		return largest;		
	}
	private static int countHelper(int[][] cake,int i,int j,boolean[][] visited)
	{
		if(cake[i][j]==0)
			return 0;
		int sum=0;
		visited[i][j]=true;
		for(int a=0;a<4;a++)
		{
			int p1=i+x[a];
			int p2=j+y[a];
			if(p1>=0&&p1<cake.length&&p2>=0&&p2<cake.length&&!visited[p1][p2])
			{
				sum+=countHelper(cake,p1,p2,visited);
			}
		}		
		return 1+sum;
	}
	
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int[][] cake=new int[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				cake[i][j]=s.nextInt();
			}
		}
		
		System.out.println(countOnLargestPiece(cake));
		
		s.close();
	}

}
