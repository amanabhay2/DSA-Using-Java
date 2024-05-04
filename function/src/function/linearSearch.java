package function;

import java.util.Scanner;

public class linearSearch {

	
	public static int search(int key,int[] x)
	{
		for(int i=0;i<x.length;i++)
		{
			if(x[i]==key)
				return i;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		
		for(int i=1;i<=n;i++)
		{
			int size=s.nextInt();
			int arr[]=new int[size];
			for(int j=0;j<size;j++)
			{
				arr[j]=s.nextInt();
			}
			
			
			
			int key=s.nextInt();
			int index=search(key,arr);
			System.out.println(index);
		}

	}

}
