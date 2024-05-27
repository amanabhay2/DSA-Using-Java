package graph;

import java.util.Scanner;

public class ThreeVertexCycle {

	public static int countThreeCycles(int[][] edges)
	{
		int total=0;
		for(int i=0;i<edges.length;i++)
		{
			for(int j=0;j<edges.length;j++)
			{
					for(int k=0;k<edges.length;k++)
					{
						if(edges[i][j]==1&&edges[j][k]==1&&edges[k][i]==1)
						{
							total++;
						}							
					}
			}
		}
		return total/6;
	}
	
	
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int v=s.nextInt();
		int e=s.nextInt();
		int[][] edges=new int[v][v];
		for(int i=0;i<e;i++)
		{
			int a=s.nextInt();
			int b=s.nextInt();
			edges[a][b]=1;
			edges[b][a]=1;
		}
		
		System.out.println(countThreeCycles(edges));
		
		s.close();
	}

}
