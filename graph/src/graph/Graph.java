package graph;

import java.util.*;

public class Graph {
	//DFS -Depth First Search
	public static void printDFS(int[][] edges)
	{
		boolean[] visited=new boolean[edges.length];
		for(int i=0;i<edges.length;i++)
		{
			if(!visited[i])
				printDFSHelper(edges,i,visited);
		}
	}
	public static void printDFSHelper(int[][] edges,int start,boolean[] visited)
	{
		System.out.println(start);
		visited[start]=true;
		for(int i=0;i<edges.length;i++)
		{
			if(edges[start][i]==1&&!visited[i])
			{
				printDFSHelper(edges,i,visited);
			}
		}
	}
	//BFS-Breadth First Search
	public static  void printBFS(int[][] edges)
	{
		boolean[]  visited=new boolean[edges.length];
		for(int i=0;i<edges.length;i++)
		{
			if(!visited[i])
				printBFSHelper(edges,i,visited);
		}
	}
	public static void printBFSHelper(int[][] edges,int start,boolean[] visited) 
	{
		QueueUsingLinkedList<Integer> queue=new QueueUsingLinkedList<Integer>();
		queue.enqueue(start);
		visited[start]=true;
		while(!queue.isEmpty())
		{
			try {
				int temp=queue.dequeue();
				System.out.println(temp);
				for(int i=0;i<edges.length;i++)
				{
					if(edges[temp][i]==1&&!visited[i])
					{
						queue.enqueue(i);
						visited[i]=true;
					}
				}
			} catch (QueueEmptyException e) {}
		}
	}
	
	//has Path
	public static boolean hasPath(int[][] edges,int start,int end)
	{
		boolean[] visited=new boolean[edges.length];
		
		boolean status=hasPathHelper(edges,start,end,visited);
		if(status)
			return true;
		
		return false;
	}
	public static boolean hasPathHelper(int[][] edges,int start,int end,boolean[] visited)
	{
		if(start==end)
			return true;
		visited[start]=true;
		for(int i=0;i<edges.length;i++)
		{
			if(edges[start][i]==1&&!visited[i])
			{
				boolean status=hasPathHelper(edges,i,end,visited);
				if(status)
					return true;
			}
		}
		return false;
	}
	
	//GET pATH DFS
	public static ArrayList<Integer> getPathDFS(int[][] edges,int start,int end)
	{
		boolean[] visited=new boolean[edges.length];
		ArrayList<Integer> output=getPathDFSHelper(edges,start,end,visited);
		if(output!=null)
			return output;
		else 
			return null;
 	}
	public static ArrayList<Integer> getPathDFSHelper(int[][] edges,int start,int end,boolean[] visited)
	{
		if(start==end)
		{
			ArrayList<Integer> op=new ArrayList<Integer>();
			op.add(end);
			return op;
		}
		
		for(int i=0;i<edges.length;i++)
		{
			if(edges[start][i]==1&&!visited[i])
			{
				visited[start]=true;
				ArrayList<Integer> temp=getPathDFSHelper(edges,i,end,visited);
				if(temp!=null)
				{
					ArrayList<Integer> op=new ArrayList<Integer>();
					op.add(start);
					for(int j=0;j<temp.size();j++)
					{
						op.add(temp.get(j));
					}
					return op;
				}
			}
		}
		return null;
	}

	//get path BFS
	public static ArrayList<Integer> getPathBFS(int[][] edges,int start,int end) throws QueueEmptyException
	{
		boolean[] visited=new boolean[edges.length];
		ArrayList<Integer> op=getPathBFSHelper(edges,start,end,visited);
		if(op!=null)
			return op;
		else
			return null;
	}
	public static ArrayList<Integer> getPathBFSHelper(int[][] edges,int start,int end,boolean[] visited) throws QueueEmptyException
	{
		QueueUsingLinkedList<Integer> queue=new QueueUsingLinkedList<Integer>();
		queue.enqueue(start);
		visited[start]=true;
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		while(!queue.isEmpty())
		{
			int temp=queue.dequeue();
			if(temp==end)
				break;
			for(int i=0;i<edges.length;i++)
			{
				if(edges[temp][i]==1&&!visited[i])
				{
					queue.enqueue(i);
					visited[i]=true;
					map.put(i, temp);
				}
			}
		}
		if(map.containsKey(end))
		{
			ArrayList<Integer> op=new ArrayList<Integer>();
			while(end!=start)
			{
				op.add(end);
				end=map.get(end);
			}
			op.add(end);
			return op;
		}
		else
			return null;
	}

	//Connected or Dis-Connected Graph
	public static boolean isConnected(int[][] edges)
	{
		boolean[] visited=new boolean[edges.length];
		//dfs traversal
		isConnectedHelper(edges,0,visited);
		//checking if connected or not
		for(int i=0;i<visited.length;i++)
		{
			if(!visited[i])
				return false;
		}
		return true;
	}
	public static void isConnectedHelper(int[][] edges,int start,boolean[] visited)
	{
		visited[start]=true;
		for(int i=0;i<edges.length;i++)
		{
			if(edges[start][i]==1&&!visited[i])
			{
				isConnectedHelper(edges,i,visited);
			}
		}
	}
	
	//Connected components
	public static ArrayList<ArrayList<Integer>> getComponents(int[][] edges)
	{
		boolean [] visited=new boolean[edges.length];
		ArrayList<ArrayList<Integer>> op=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<edges.length;i++)
		{
			if(!visited[i])
			{
				ArrayList<Integer> arr=new ArrayList<Integer>();
				getComponentsHelper(edges,i,visited,arr);
				if(arr.size()!=0)
					op.add(arr);
			}
		}		
		return op;
	}
	public static void getComponentsHelper(int[][] edges,int start,boolean[] visited,ArrayList<Integer> al)
	{
		al.add(start);
		visited[start]=true;
		for(int i=0;i<edges.length;i++)
		{
			if(edges[start][i]==1&&!visited[i])
			{
				getComponentsHelper(edges,i,visited,al);
			}
		}
	}
	//MAIN
	public static void main(String[] args) throws QueueEmptyException {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter number of nodes and edges");
		int n=s.nextInt();
		int e=s.nextInt();
		int[][] edges=new int[n][n];
		for(int i=0;i<e;i++)
		{
			int from=s.nextInt();
			int to=s.nextInt();
			edges[from][to]=1;
			edges[to][from]=1;
		}
		System.out.println("Enter start and end to search path");
		int start=s.nextInt();
		int end=s.nextInt();
		System.out.println(hasPath(edges,start,end));
		
		ArrayList<Integer> output=getPathBFS(edges,start,end);
		for(int j=0;j<output.size();j++)
		{
			System.out.println("ArrayList   "+output.get(j));
		}
		
		
		System.out.println("Is graph connedted\t"+isConnected(edges));
		
		System.out.println("\n--------------------------------------------------------------------------\n\n");
		
		ArrayList<ArrayList<Integer>> al=getComponents(edges);
		for(int i=0;i<al.size();i++)
		{
			System.out.println("Connected component "+(i+1));
			ArrayList<Integer> arr=al.get(i);
			for(int j=0;j<arr.size();j++)
			{
				System.out.print("    "+arr.get(j));
			}
			System.out.println();
		}
		
		
		//printDFS(edges);
		//System.out.println("\n\n");
		
		//printBFS(edges);
		s.close();
	}

}
