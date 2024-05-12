package dynamicProgramming;

import java.util.Scanner;

public class LootHouses {

	public static int maxLootR(int[] arr)
	{
		return maxLootR(arr,0);
	}
	private static int maxLootR(int[] arr,int start)
	{
		if(start>=arr.length)
			return 0;
		int loot1=arr[start]+maxLootR(arr,start+2);
		int loot2=maxLootR(arr,start+1);
		return Math.max(loot1, loot2);
	}
	
	public static int maxLootM(int[] arr)
	{
		int max[]=new int[arr.length];
		return maxLootM(arr,max,0);
	}
	private static int maxLootM(int[] arr,int[] max,int start)
	{
		if(start>=arr.length)
			return 0;
		if(max[start]!=0)
			return max[start];
		int loot1=arr[start]+maxLootR(arr,start+2);
		int loot2=maxLootR(arr,start+1);
		max[start]= Math.max(loot1, loot2);
		return max[start];
	}
	public static int maxLootDP(int[] arr)
	{
		int max[]=new int[arr.length];
		max[arr.length-1]=arr[arr.length-1];
		max[arr.length-2]=Math.max(arr[arr.length-1], arr[arr.length-2]);
		for(int i=arr.length-3;i>=0;i--)
		{
			int loot1=arr[i]+max[i+2];
			int loot2=max[i+1];
			max[i]= Math.max(loot1, loot2);
		}
		return max[0];
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=s.nextInt();
		}
		
		System.out.println(maxLootDP(arr));
		
		System.out.println(maxLootM(arr));
		
		System.out.println(maxLootR(arr));
		
		s.close();
	}

}
