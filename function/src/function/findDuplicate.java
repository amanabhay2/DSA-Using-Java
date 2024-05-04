package function;

import java.util.Scanner;

public class findDuplicate {

	public static void printDuplicate(int[] arr)
	{
		
		for(int i=0;i<arr.length;i++)
		{
			boolean duplicate=false;
			for(int j=0;j<arr.length;j++)
			{
				if(i==j)
					continue;
				if(arr[i]==arr[j])
					duplicate=true;
			}
			if(duplicate)
			{
				System.out.println(arr[i]);break;
			}
		}
	}
	
	//
	//
	//
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		
		for(int i=1;i<=t;i++)
		{
			int size=s.nextInt();
			int[] arr=new int[size];
			
			for(int j=0;j<size;j++)
			{
				arr[j]=s.nextInt();
			}
			
			printDuplicate(arr);
			
			
		}
		s.close();
	}

}
