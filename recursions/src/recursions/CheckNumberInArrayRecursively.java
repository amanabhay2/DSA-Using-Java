package recursions;
import java.util.Scanner;

public class CheckNumberInArrayRecursively {

	public static boolean arrcheck(int[] arr,int x)
	{
		if(arr.length==1)
		{
			if(arr[0]==x) return true;
			else return false;
		}
		if(arr[0]==x)
			return true;
		int[] shortArr=new int[arr.length-1];
		for(int i=1;i<arr.length;i++)
		{
			shortArr[i-1]=arr[i];
		}
		boolean check=arrcheck(shortArr,x);
		return check;		
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int size=s.nextInt();
		int[] arr= new int[size];
		for(int i=0;i<size;i++)
		{
			arr[i]=s.nextInt();
		}
		int x=s.nextInt();
		boolean found=arrcheck(arr,x);
		System.out.println(found);
		
		s.close();

	}

}
