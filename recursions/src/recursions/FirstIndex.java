package recursions;

import java.util.Scanner;

public class FirstIndex {

	public static int firstIndex(int[] arr,int x,int start)
	{
		if(start==arr.length)
			return -1;
		int n=-1;
		 n=firstIndex(arr,x,start+1);		
		 if(n!=-1)
			 return n;
		if(arr[start]==x)
			return start;
		
		return n;
	}
	public static void allIndices(int[] arr,int x,int start)
	{
		if(start==arr.length)
			return;
			
		
		if(arr[start]==x)
			System.out.print(start+" ");
		
		allIndices(arr,x,start+1);	
		
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int size=s.nextInt();
		int[] arr= new int[size];
		for(int i=0;i<size;i++)
		{
			arr[i]=s.nextInt();
		}
		int x=s.nextInt();
		int index=firstIndex(arr,x,0);
		System.out.println(index);
		allIndices(arr,x,0);
		s.close();

	}

}
