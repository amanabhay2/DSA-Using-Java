package recursions;

import java.util.Scanner;

public class ArraySubsetPrint {

	public static void printSubset(int[] arr,int[] output,int start)
	{
		if(start==arr.length)
		{
			for(int i=0;i<output.length;i++)
			{
				System.out.print(output[i]+" ");
			}
			System.out.println();
			return;
		}
		int[] O=new int[output.length+1];
		for(int i=0;i<O.length-1;i++)
		{
			O[i]=output[i];
		}
		O[O.length-1]=arr[start];
		
		printSubset(arr,output,start+1);
		printSubset(arr,O,start+1);
		
		
	}
	public static void printSubset(int[] arr)
	{
		int[] output=new int[0];
		printSubset(arr,output,0);
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int size=s.nextInt();
		int[] arr=new int[size];
		for(int i=0;i<size;i++)
		{
			arr[i]=s.nextInt();
		}
		printSubset(arr);
		s.close();
	}

}
