package dynamicProgramming;

import java.util.Scanner;

public class CoinTower {
	
	public static String whoWinsR(String Whis,String Beerus,int n,int x,int y)
	{
		if(whoWinsR(n,x,y))
			return Beerus;
		else 
			return Whis;	
	}
	private static boolean whoWinsR(int n,int x,int y)
	{
		if(n==1||n==x||n==y)
			return true;
		else if(n<x)
		{
			boolean a=whoWinsR(n-1,x,y);
			return !a;
		}
		else if(n<y)
		{
			boolean a=whoWinsR(n-1,x,y);
			boolean b=whoWinsR(n-x,x,y);
			return !(a&&b);
		}
		else
		{
			boolean a=whoWinsR(n-1,x,y);
			boolean b=whoWinsR(n-x,x,y);
			boolean c=whoWinsR(n-y,x,y);
			return !(a&&b&&c);
		}
	}
	public static String whoWinsM(String Whis,String Beerus,int n,int x,int y)
	{
		boolean[][] output=new boolean[n+1][2];
		for(int i=0;i<n+1;i++)
		{
			output[i][1]=false;
		}
		if(whoWinsM(output,n,x,y))
			return Beerus;
		else 
			return Whis;	
	}
	private static boolean whoWinsM(boolean[][] output,int n,int x,int y)
	{
		if(x>y)
		{
			int swap=x;
			x=y;
			y=swap;
		}
		if(output[n][1]==true)
			return output[n][0];
		if(n==1||n==x||n==y)
			output[n][1]=output[n][0]= true;
		else if(n<x)
		{
			boolean a=whoWinsR(n-1,x,y);
			output[n][0]= !a;
			output[n][1]=true;
		}
		else if(n<y)
		{
			boolean a=whoWinsR(n-1,x,y);
			boolean b=whoWinsR(n-x,x,y);
			output[n][0]= !(a&&b);
			output[n][1]=true;
		}
		else
		{
			boolean a=whoWinsR(n-1,x,y);
			boolean b=whoWinsR(n-x,x,y);
			boolean c=whoWinsR(n-y,x,y);
			output[n][0]= !(a&&b&&c);
			output[n][1]=true;
		}
		return output[n][0];
	}
	public static String whoWinsDP(String Whis,String Beerus,int n,int x,int y)
	{
		if(x>y)
		{
			int swap=x;
			x=y;
			y=swap;
		}
		boolean[] output=new boolean[n+1];
		for(int i=1;i<n+1;i++)
		{
			if(i==1||i==x||i==y)
				output[i]= true;
			else if(i<x)
			{
				output[i]= !output[i-1];
			}
			else if(i<y)
			{
				boolean a=output[i-1];
				boolean b=output[i-x];
				if(i-x>=0)
					output[i]= !(a&&b);
			}
			else
			{
				boolean a=output[i-1];
				boolean b=output[i-x];
				boolean c=output[i-y];
				if(i-y>=0)
					output[i]= !(a&&b&&c);
			}
		}
		
		if(output[n])
			return Beerus;
		else 
			return Whis;	
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("    N   X    Y   ");
		int n=s.nextInt();
		int x=s.nextInt();
		int y=s.nextInt();
		String Whis="Whis";
		String Beerus="Beerus";
		
		System.out.println(whoWinsDP(Whis,Beerus,n,x,y));
		
		System.out.println(whoWinsM(Whis,Beerus,n,x,y));
		
		System.out.println(whoWinsR(Whis,Beerus,n,x,y));
		
		s.close();
	}

}
