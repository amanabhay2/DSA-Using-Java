package hashmaps;

import java.util.Scanner;
import java.util.HashMap;
public class PairDifferenceK {

	public static int getPairWithDifferenceK(int[] arr,int k)
	{
		if(arr.length==0)
			return 0;
		int pairs=0;
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<arr.length;i++)
		{
			if(map.get(arr[i])==null)
			{
				map.put(arr[i], 1);
			}
			else
			{
				map.put(arr[i], map.get(arr[i]+1));
			}			
		}
		
		for(int i=0;i<arr.length;i++)
		{
			if(map.containsKey(arr[i]))
			{
				
				if(map.containsKey(arr[i]-k))
				{
					int p1=map.get(arr[i]);
					int p2=map.get(arr[i]-k);
					pairs+=p1*p2;
				}
				if(map.containsKey(arr[i]+k))
				{
					int p1=map.get(arr[i]);
					int p2=map.get(arr[i]+k);
					pairs+=p1*p2;
				}
				map.remove(arr[i]);
			}
		}
		return pairs;
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int size=s.nextInt();
		int[] arr=new int[size];
		for(int i=0;i<size;i++)
		{
			arr[i]=s.nextInt();
		}
		int diff=s.nextInt();
		int pairs=getPairWithDifferenceK(arr,diff);
		System.out.println(pairs);
		s.close();
	}

}
