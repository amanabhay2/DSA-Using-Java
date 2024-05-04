package recursions;
import java.util.Scanner;
public class RatInAMaze {

	public static void checkPath(int[][] maze,int i,int j,int[][] path)
	{
		int n=maze.length;
		if(i<0||i>=n||j<0||j>=n||maze[i][j]==0||path[i][j]==1)
			return ;
		
		path[i][j]=1;
		if(i==n-1&&j==n-1)
		{
			for(int p=0;p<n;p++)
			{
				for(int q=0;q<n;q++)
				{
					System.out.print(path[p][q]);
				}
				System.out.println();
			}
			System.out.println();System.out.println();System.out.println();
			path[i][j]=0;
			return;
		}
			
		
		
		
		checkPath(maze,i,j+1,path);
		
			
		checkPath(maze,i+1,j,path);
		
		checkPath(maze,i,j-1,path);
		
		checkPath(maze,i-1,j,path);
		
		path[i][j]=0;
		
		
		
	}
	public static void Path(int[][] maze)
	{
		int n=maze.length;
		int[][] path=new int[n][n];
		checkPath(maze,0,0,path);
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int size=s.nextInt();
		int[][] maze=new int[size][size];
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<size;j++)
			{
				maze[i][j]=s.nextInt();
			}
		}
		//boolean isPath=
		Path(maze);
		//System.out.println(isPath);		
		s.close();
	}

}
