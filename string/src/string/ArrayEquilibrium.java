package string;
import java.util.Scanner;
public class ArrayEquilibrium {

	public static int equlibriumIndex(int[] arr)
	{
		int index=-1;
		int size=arr.length;
		int sumL=0,sumR=0;
		for(int i=0;i<size;i++)
		{
			sumR=sumR+arr[i];
		}
		for(int i=0;i<size;i++)
		{
			sumR=sumR-arr[i];
			//System.out.println(sumR);
			if(sumL==sumR)
				return i;
			else
				sumL=sumL+arr[i];
		}
		return index;
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
			int index=equlibriumIndex(arr);
			System.out.println(index);
		}
		s.close();

	}

}
