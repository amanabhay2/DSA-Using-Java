package string;

import java.util.Scanner;

public class FindUniqueElement {

	public static int uniqueElement(int[] arr)
	{
		
		int ele=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==-1)
				continue;
			boolean found=false;
			for(int j=i+1;j<arr.length;j++)
			{
				
				if(i!=j)
				{
					if(arr[i]==arr[j])
					{
						found=true;
						arr[j]=-1;
					}
				}
				
			}
			if(!found)
				return arr[i];
		}
		
		
		return ele;
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
			int unique=uniqueElement(arr);
			System.out.println(unique);
		}
		s.close();

	}

}
