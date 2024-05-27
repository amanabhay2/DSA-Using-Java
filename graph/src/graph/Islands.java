package graph;

import java.util.Scanner;

public class Islands {

	public static int numberOfIslands(int[][] edges)
	{
		boolean[] visited=new boolean[edges.length];
		int count=0;
		for(int i=0;i<edges.length;i++)
		{
			if(!visited[i])
			{
				count++;
				traverseIslands(edges,i,visited);
			}
		}		
		return count;
	}
	private static void traverseIslands(int[][] edges,int start,boolean[] visited)
	{
		visited[start]=true;
		for(int i=0;i<edges.length;i++)
		{
			if(edges[start][i]==1&&!visited[i])
			{
				traverseIslands(edges,i,visited);
			}
		}		
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter count of vertices and edges");
		int v=s.nextInt();
		int e=s.nextInt();
		int[][] edges=new int[v][v];
		System.out.println("Enter the edges");
		for(int i=0;i<e;i++)
		{
			int a=s.nextInt();
			int b=s.nextInt();
			edges[a][b]=1;
			edges[b][a]=1;			
		}
		
		int count=numberOfIslands(edges);
		System.out.println("Number of connected groups of islands are : "+count);
		s.close();
	}

}
