package function;

import java.util.Scanner;

public class arrayIntersection {

	
	public static void printIntersection(int[] arr1,int[] arr2)
	{
		for(int i=0;i<arr1.length;i++)
		{
			for(int j=0;j<arr2.length;j++)
			{
				if(arr1[i]==arr2[j])
				{
					System.out.print(arr1[i]+" ");
					arr2[j]=-1000;
					
					break;
				}
			}
			
		}
		
		
	
	}
	
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		
		for(int i=1;i<=n;i++)
		{
			//input first array
			int size1=s.nextInt();
			int[] arr1=new int[size1];
			for(int j=0;j<size1;j++)
			{
				arr1[j]=s.nextInt();
			}
			
			//input second array
			int size2=s.nextInt();
			int[] arr2=new int[size2];
			for(int j=0;j<size2;j++)
			{
				arr2[j]=s.nextInt();
			}
			System.out.println();
			printIntersection(arr1,arr2);
			
		}

	}

}
