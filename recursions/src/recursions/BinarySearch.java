package recursions;
import java.util.Scanner;
public class BinarySearch {

	public static int binarySearch(int[] arr,int x,int start,int end)
	{
		if(start>end)
			return -1;
		
		int mid=(start+end)/2;
		if(arr[mid]>x)
			return binarySearch(arr,x,start,mid-1);
		else if(arr[mid]<x)
			return binarySearch(arr,x,mid+1,end);
		
		
		return mid;	
		
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int size=s.nextInt();
		int[] arr=new int[size];
		for(int i=0;i<size;i++)
		{
			arr[i]=s.nextInt();
		}
		int search=s.nextInt();
		int index=binarySearch(arr,search,0,size-1);
		System.out.println(index);
		s.close();
	}

}
