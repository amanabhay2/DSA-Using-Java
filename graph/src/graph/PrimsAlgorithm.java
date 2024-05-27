package graph;

import java.util.Scanner;

public class PrimsAlgorithm {

	
	public static int getMinIndex(int[] weight,boolean[] visited)
	{
		int index=-1;
		for(int i=0;i<weight.length;i++)
		{
			if(!visited[i]&&(index==-1||weight[i]<weight[index]))
				index=i;
		}		
		return index;
	}
	
	public static void printPrimsMST(int[][] edges)
	{
		int v=edges.length;
		//parent visited weight
		int[] parent=new int[v];
		parent[0]=-1;
		boolean[] visited=new boolean[v];
		int[] weight=new int[v];
		weight[0]=0;
		for(int i=1;i<weight.length;i++)
		{
			weight[i]=Integer.MAX_VALUE;
		}
		//--------------------
		for(int i=0;i<v;i++)
		{
			int min=getMinIndex(weight,visited);
			visited[min]=true;
			for(int j=0;j<v;j++)
			{
				if(edges[min][j]!=0&&(!visited[j]))
				{
					if(edges[min][j]<weight[j])
					{
						parent[j]=min;
						weight[j]=edges[min][j];
					}
				}
			}
			
			
			
			
		}
		
		
		
		for(int i=1;i<v;i++)
		{
			System.out.println(parent[i]+"   "+i+"   "+weight[i]);
		}		
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter vertices and edges");
		int v=s.nextInt();
		int e=s.nextInt();
		int[][] edges=new int[v][v];
		for(int i=0;i<e;i++)
		{
			int a=s.nextInt(),b=s.nextInt(),c=s.nextInt();	
			edges[a][b]=c;
			edges[b][a]=c;
		}
		
		printPrimsMST(edges);
		
		s.close();
	}

}
