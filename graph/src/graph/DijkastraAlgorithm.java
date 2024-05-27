package graph;

import java.util.Scanner;

public class DijkastraAlgorithm {
	
	public static int getMinIndex(int[] distance,boolean[] visited)
	{
		int index=-1;
		for(int i=0;i<distance.length;i++)
		{
			if(!visited[i]&&(index==-1||distance[i]<distance[index]))
			{
				index=i;
			}			
		}	
		return index;
	}
	
	public static void printDigkastrasShortestPaths(int[][] edges)
	{
		int v=edges.length;
		boolean[] visited=new boolean[v];
		int[] distance=new int[v];
		distance[0]=0;
		for(int i=1;i<v;i++)
		{
			distance[i]=Integer.MAX_VALUE;
		}
		
		for(int i=0;i<v;i++)
		{
			int min=getMinIndex(distance,visited);
			visited[min]=true;
			for(int j=0;j<v;j++)
			{
				if(edges[min][j]!=0&&!visited[j])
				{
					int currentWeight=distance[min]+edges[min][j];
					if(currentWeight<distance[j])
					{
						distance[j]=currentWeight;
					}
				}
			}
		}
		
		for(int i=0;i<v;i++)
		{
			System.out.println(i+"    "+distance[i]);
		}
		
	}

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter vertices and edges");
		int v=s.nextInt();
		int e=s.nextInt();
		//System.out.println("Source - Destination - Weight");
		int[][] edges=new int[v][v];
		for(int i=0;i<e;i++)
		{
			int a=s.nextInt();
			int b=s.nextInt();
			int c=s.nextInt();
			edges[a][b]=c;
			edges[b][a]=c;
		}
		
		printDigkastrasShortestPaths(edges);
		
		
		s.close();
	}

}
