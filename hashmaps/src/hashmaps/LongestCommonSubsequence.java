package hashmaps;

import java.util.HashMap;
import java.util.Scanner;

public class LongestCommonSubsequence {

	public static int[] getLongestCommonSubsequence(int[] arr)
	{
		HashMap<Integer,Boolean> map=new HashMap<Integer,Boolean>();
		for(int i=0;i<arr.length;i++)
		{
			map.put(arr[i], true);
		}
		int start=-1;
		int longestSubSequence=-1;
		for(int i=0;i<arr.length;i++)
		{
			int key=arr[i];
			int count=0;
			if(map.get(key))
			{
				int j=0;
				while(true)
				{
					if(map.get(key+j)==null)
						break;
					
					map.put(key+j, false);
					count++;
					j++;
				}
				while(true)
				{
					if(map.get(--key)==null)
						break;
					map.put(key, false);
					count++;
				}
				if(count>longestSubSequence)
				{
					start=++key;
					longestSubSequence=count;
				}
				else if(count==longestSubSequence)
				{
					start=Math.max(start,++key);
					longestSubSequence=count;
				}
				
			}
		}
		if(longestSubSequence<=1)
		{
			int[] op= {start};
			return op;
		}
		else
		{
			int[] op= {start,start+longestSubSequence-1};
			return op;
		}
	}
	
 	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int size=s.nextInt();
		int[] arr=new int[size];
		for(int i=0;i<size;i++)
		{
			arr[i]=s.nextInt();
		}
		int[] op=getLongestCommonSubsequence(arr);
		for(int i=0;i<op.length;i++)
		{
			System.out.print(op[i]+"  ");
		}
		s.close();
	}

}
