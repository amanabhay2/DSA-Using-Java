package recursions;

import java.util.Scanner;

public class ArraySum {

	public static int arrSum(int[] arr)
	{
		if(arr.length==1)
			return arr[0];
		int[] shortArr=new int[arr.length-1];
		for(int i=1;i<arr.length;i++)
		{
			shortArr[i-1]=arr[i];
		}
		
		return arr[0]+arrSum(shortArr);
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int size=s.nextInt();
		int[] arr= new int[size];
		for(int i=0;i<size;i++)
		{
			arr[i]=s.nextInt();
		}
		int sum=arrSum(arr);
		System.out.println(sum);
		
		s.close();

	}

}
