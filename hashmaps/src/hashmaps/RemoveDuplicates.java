package hashmaps;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
public class RemoveDuplicates {

	public static ArrayList<Integer> removeDuplicates(int[] arr)
	{
		ArrayList<Integer> op=new ArrayList<Integer>();
		HashMap<Integer,Boolean> map=new HashMap<>();
		for(int i=0;i<arr.length;i++)
		{
			if(map.containsKey(arr[i]))
				continue;
			else
			{
				op.add(arr[i]);
				map.put(arr[i], true);
			}			
		}		
		return op;
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter size of array");
		int size=s.nextInt();
		int[] arr=new int[size];
		for(int i=0;i<size;i++)
		{
			arr[i]=s.nextInt();
		}
		ArrayList<Integer> keys=removeDuplicates(arr);
		System.out.println("Non- Duplicate Elements are..");
		for(int i=0;i<keys.size();i++)
		{
			System.out.println(keys.get(i));
		}		
		s.close();
	}

}
