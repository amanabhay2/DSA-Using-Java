package dynamicProgramming;

import java.util.Scanner;

public class BalancedTreePossible {

	public static int countR(int h)
	{
		int mod=(int)Math.pow(10, 7)+7;
		return countR(h,mod);
	}
	public static int countR(int h,int mod)
	{
		if(h==0||h==1)
			return 1;
		int x=countR(h-1);
		int y=countR(h-2);
		
		return (int)((long)x*x)%mod+(int)(2*(long)x*y)%mod;
	}
	
	public static int countM(int h)
	{
		int[] arr=new int[h+1];
		int mod=(int)Math.pow(10, 7)+7;
		return countM(h,mod,arr);
	}
	public static int countM(int h,int mod,int[] arr)
	{
		if(h==0||h==1)
			return 1;
		if(arr[h]!=0)
			return arr[h];
		int x=countM(h-1,mod,arr);
		int y=countM(h-2,mod,arr);
		
		return (int)((long)x*x)%mod+(int)((long)2*x*y)%mod;
	}
	
	public static int countDP(int h)
	{
		int mod=(int)Math.pow(10, 7)+7;
		int[] arr=new int[h+1];
		arr[0]=1;	arr[1]=1;
		for(int i=2;i<=h;i++)
		{
			int x=arr[i-1];
			int y=arr[i-2];
			arr[i]=(int)((long)x*x)%mod+(int)((long)2*x*y)%mod;
		}		
		return arr[h];
	}
	
	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		System.out.println("Enter height of the tree");
		int h=s.nextInt();
		
		System.out.println(countDP(h));
		
		System.out.println(countM(h));
		
		System.out.println(countR(h));
		
		s.close();
	}

}
