package function;
import java.util.Scanner;
public class unique {

	public static int unique(int[] arr)
	{
		
		
		for(int i=0;i<arr.length;i++)
		{
			boolean check=false;
			for(int j=0;j<arr.length;j++)
			{
				if(i==j)
					continue;
				if(arr[i]==arr[j])
					check=true;
			}
			if(check==false)
				return arr[i];
		}
		return 0;
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
			
			int x=unique(arr);
			System.out.println(x);
		}

	}

}
