package graph;

import java.util.Scanner;

public class ConnectingDots {
	static int[] x= {0,-1,0,1};
	static int[] y= {1,0,-1,0};

	public static boolean isConnected(int n,int m,char[][] input)
	{
		boolean[][] visited=new boolean[n][m];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(isConnectedHelper(0,i,j,i,j,input[i][j],input,visited))
					return true;
			}
		}
		return false;		
	}
	private static boolean isConnectedHelper(int k,int i1,int j1,int i,int j,char ch,char[][] input,boolean[][] visited)
	{
		k++;
		visited[i1][j1]=true;
		for(int a=0;a<4;a++)
		{
			int i2=i1+x[a];
			int j2=j1+y[a];
			if(i2==i&&j2==j&&k>3)
				return true;
			if(i2>=0&&i2<input.length&&j2>=0&&j2<input[0].length)
			{
				if(input[i2][j2]==ch&&!visited[i2][j2])
				{
					boolean b=isConnectedHelper(k,i2,j2,i,j,ch,input,visited);
					if(b)	return true;
				}
			}
			
		}
		visited[i1][j1]=false;
		return false;
	}
	
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter n and m ");
		int n=s.nextInt();
		int m=s.nextInt();
		char[][] input=new char[n][m];
		for(int i=0;i<n;i++)
		{
			String str=s.next();
			for(int j=0;j<m;j++)
			{
				input[i][j]=str.charAt(j);
			}
		}
		
		System.out.println(isConnected(n,m,input));
		
		s.close();
	}

}
