package graph;

import java.util.Scanner;

public class Codingninjass {

	public static boolean isPossible(int n,int m,char[][] ip)
	{
		boolean[][] visited=new boolean[n][m];
		String str="CODINGNINJA";
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(ip[i][j]=='C')
				{
					visited[i][j]=true;
					boolean b=isPossible(i,j,ip,visited,str.substring(1));
					visited[i][j]=false;
					if(b)	return true;
				}
			}
		}
		return false;
	}
	private static boolean isPossible(int i,int j,char[][] ip,boolean[][] visited,String str)
	{
		if(str.length()==0)
			return true;
		int[] x= {0,1,1,1,0,-1,-1,-1};
		int[] y= {1,1,0,-1,-1,-1,0,1};
		for(int a=0;a<8;a++)
		{
			int i1=i+x[a];
			int j1=j+y[a];
			if(i1>=0&&i1<ip.length&&j1>=0&&j1<ip[0].length&&!visited[i1][j1])
			{
				if(ip[i1][j1]==str.charAt(0))
				{
					visited[i1][j1]=true;
					boolean b=isPossible(i1,j1,ip,visited,str.substring(1));
					visited[i1][j1]=false;
					if(b)	return true;
				}
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter n and m for matrix");
		int n=s.nextInt();	
		int m=s.nextInt();
		char[][] ip=new char[n][m];
		for(int i=0;i<n;i++)
		{
			String str=s.next();
			for(int j=0;j<m;j++)
			{
				ip[i][j]=str.charAt(j);
			}
		}
		
		boolean status=isPossible(n,m,ip);
		
		if(status)
			System.out.println(1);
		else
			System.out.println(0);
		
		s.close();
	}

}
