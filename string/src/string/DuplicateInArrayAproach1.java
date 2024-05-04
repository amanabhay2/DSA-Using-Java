package string;

import java.util.Scanner;

public class DuplicateInArrayAproach1 {

	public static int findDuplicate(int[] arr)
	{
		int dupli=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr.length;j++)
			{
				if(i==j)
					continue;
					
				if(arr[i]==arr[j])
						dupli=arr[i];
				
			}
		}
		
		return dupli;
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		for(int i=1;i<=n;i++)
		{
			int size=s.nextInt();
			int[] arr=new int[size];
			for(int j=0;j<size;j++)
			{
				arr[j]=s.nextInt();
			}
			int duplicate=findDuplicate(arr);
			System.out.println(duplicate);
		}

	}

}
