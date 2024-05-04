package function;
import java.util.Scanner;

public class swapAlternate {
	
	public static void print(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public static int[] swapAlter(int[] arr)
	{
		
		for(int i=1;i<arr.length;i=i+2)
		{
			int swap=arr[i-1];
			arr[i-1]=arr[i];
			arr[i]=swap;
		}
		return arr;
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
			arr=swapAlter(arr);
			print(arr);
			
		}

	}

}
