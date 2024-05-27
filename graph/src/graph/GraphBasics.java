package graph;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class GraphBasics {
	public static void printBFS(int[][] edges)
	{
		boolean[] visited=new boolean[edges.length];
		for(int i=0;i<edges.length;i++)
		{
			if(!visited[i])
			{
				printBFSHelper(edges,i,visited);
			}
		}
	}
	private static void printBFSHelper(int[][] edges,int start,boolean[] visited)
	{
		QueueUsingLinkedList<Integer> queue=new QueueUsingLinkedList<Integer>();
		queue.enqueue(start);
		visited[start]=true;
		while(!queue.isEmpty())
		{
			try {
				int front=queue.dequeue();
				System.out.println(front);
				for(int i=0;i<edges.length;i++)
				{
					if(edges[front][i]==1&&!visited[i])
					{
						queue.enqueue(i);
						visited[i]=true;
					}
				}
			} catch (QueueEmptyException e) {}
		}
	}
	
	public static void printDFS(int[][] edges)
	{
		boolean[] visited=new boolean[edges.length];
		for(int i=0;i<edges.length;i++)
		{
			if(!visited[i])
			{
				printDFSHelper(edges,i,visited);
			}
		}
	}
	private static void printDFSHelper(int[][] edges,int start,boolean[] visited)
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
	
	public static boolean hasPath(int[][] edges,int a,int b)
	{
		boolean[] visited=new boolean[edges.length];
		return hasPathHelper(edges,a,b,visited);
	}
	private static boolean hasPathHelper(int[][] edges,int a,int b,boolean[] visited)
	{
		if(a==b)
			return true;
		visited[a]=true;
		for(int i=0;i<edges.length;i++)
		{
			if(edges[a][i]==1&&!visited[i])
			{
				if(hasPathHelper(edges,i,b,visited))
					return true;
			}
		}
		return false;
	}
	
	public static ArrayList<Integer> getPathBFS(int[][] edges,int a,int b)
	{
		boolean[] visited=new boolean[edges.length];
		return getPathBFSHelper(edges,a,b,visited);
	}
	private static ArrayList<Integer> getPathBFSHelper(int[][] edges,int a,int b,boolean[] visited)
	{
		if(!hasPath(edges,a,b))
			return null;
		QueueUsingLinkedList<Integer> queue=new QueueUsingLinkedList<Integer>();
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		queue.enqueue(a);
		visited[a]=true;
		while(!queue.isEmpty())
		{
			try {
				int first=queue.dequeue();
				if(first==b)
					break;
				for(int i=0;i<edges.length;i++)
				{
					if(edges[first][i]==1&&!visited[i])
					{
						queue.enqueue(i);
						visited[i]=true;
						map.put(i,first);
					}
				}
			} catch (QueueEmptyException e) {}		
		}
		ArrayList<Integer> op=new ArrayList<Integer>();
		op.add(b);
		while(map.containsKey(b))
		{
			b=map.get(b);
			op.add(b);
		}
		ArrayList<Integer> output=new ArrayList<Integer>();
		for(int i=0;i<op.size();i++)
		{
			output.add(op.get(op.size()-1-i));
		}
		return output;
	}
	
	public static ArrayList<Integer> getPathDFS(int[][] edges,int a,int b)
	{
		boolean[] visited=new boolean[edges.length];
		return getPathDFSHelper(edges,a,b,visited);
	}
	private static ArrayList<Integer> getPathDFSHelper(int[][] edges,int a,int b,boolean[] visited)
	{
		if(a==b)
		{
			ArrayList<Integer> al=new ArrayList<Integer>();
			al.add(a);
			return al;
		}
		visited[a]=true;
		for(int i=0;i<edges.length;i++)
		{
			if(edges[a][i]==1&&!visited[i])
			{
				ArrayList<Integer> temp=getPathDFSHelper(edges,i,b,visited);
				ArrayList<Integer> op=new ArrayList<Integer>();
				op.add(a);
				for(int j=0;j<temp.size();j++)
				{
					op.add(temp.get(j));
				}
				return op;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the number of vertices and the number of edges");
		
		int v=s.nextInt();int e=s.nextInt();	
		int[] vertices=new int[v];
		int[][] edges=new  int[v][v];
		System.out.println("Enter values for vertices");
		for(int i=0;i<v;i++)
		{
			vertices[i]=s.nextInt();
		}
		System.out.println("Enter values for edges");
		for(int i=0;i<e;i++)
		{
			int a=s.nextInt();
			int b=s.nextInt();
			edges[a][b]=1;
			edges[b][a]=1;
		}
		int i=0;
		while(i!=-1)
		{
			System.out.println("Choose one Option:-\nBFS : 1\nDFS : 2\nHas Path : 3\nGet Path BFS : 4\nGet Path DFS : 5");
			System.out.println("To end the process enter -1");
			i=s.nextInt();
			if(i==1)
			{
				System.out.println("BFS Traversal");
				printBFS(edges);
			}
			else if(i==2)
			{
				System.out.println("DFS Traversal");
				printDFS(edges);
			}
			else if(i==3)
			{
				System.out.println("Has Path ");
				System.out.println("Enter start and end element");
				int a=s.nextInt();
				int b=s.nextInt();
				System.out.println(hasPath(edges,a,b));
			}
			else if(i==4)
			{
				System.out.println("BFS Get Path");
				System.out.println("Enter start and end element");
				int a=s.nextInt();
				int b=s.nextInt();
				ArrayList<Integer> path=getPathBFS(edges,a,b);
				if(path!=null)
				{
					for(int j=0;j<path.size();j++)
					{
						System.out.print("   "+path.get(j));
					}
				}
			}
			else if(i==5)
			{
				System.out.println("Dfs Get Path");
				System.out.println("Enter start and end element");
				int a=s.nextInt();
				int b=s.nextInt();
				ArrayList<Integer> path=getPathDFS(edges,a,b);
				if(path!=null)
				{
					for(int j=0;j<path.size();j++)
					{
						System.out.print("   "+path.get(j));
					}
				}
			}
			else if(i==-1)
			{
				System.out.println("Terminating.......\nDone");
			}
			else
				System.out.println("Invalid Input\n");
		}
		s.close();
	}

}
