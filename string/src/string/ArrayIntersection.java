package string;
import java.util.Scanner;
public class ArrayIntersection {

	public static void arrayIntersection(int[] arr1,int[] arr2)
	{
		for(int i=0;i<arr1.length;i++)
		{
			for(int j=0;j<arr2.length;j++)
			{
				if(arr1[i]==arr2[j])
				{
					System.out.print(arr1[i]+" ");
					arr2[j]=Integer.MIN_VALUE;
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		for(int k=1;k<=n;k++)
		{
			//first array
			int size1=s.nextInt();
			int[] arr1=new int[size1];
			for(int i=0;i<size1;i++)
			{
				arr1[i]=s.nextInt();
			}
			//second array
			int size2=s.nextInt();
			int[] arr2=new int[size2];
			for(int i=0;i<size2;i++)
			{
				arr2[i]=s.nextInt();
			}
			int resultSize;
			
			arrayIntersection(arr1,arr2);
			
		}
		
		s.close();
	}

}
