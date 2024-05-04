package sortingArray;
import java.util.Scanner;
public class SecondLargest {

	public static void printSecondLargest(int[] arr)
	{
		int secondMax=-2147483648;
		int max=-2147483648;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]>max)
			{
				secondMax=max;
				max=arr[i];
			}
			else if(arr[i]==max)
				continue;
			else if(arr[i]>secondMax)
				secondMax=arr[i];
		}
		System.out.println(secondMax);
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
			printSecondLargest(arr);
		}		

	}

}
