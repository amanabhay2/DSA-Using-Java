package recursions;

import java.util.Scanner;

public class CheckSortedArray {

	public static boolean checkSorted(int[] arr)
	{
		if(arr.length<=1) return true;
		if(arr[0]>arr[1])
			return false;
		int[] shortArr=new int[arr.length-1];
		for(int i=1;i<arr.length;i++)
		{
			shortArr[i-1]=arr[i];
		}
		boolean check=checkSorted(shortArr);
		return check;		
		//if(check)
		//	return true;
		//else
		//	return false;
		
		
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int size=s.nextInt();
		int[] arr= new int[size];
		for(int i=0;i<size;i++)
		{
			arr[i]=s.nextInt();
		}
		boolean check=checkSorted(arr);
		System.out.println(check);
		
		s.close();
	}

}
