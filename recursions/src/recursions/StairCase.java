package recursions;

import java.util.Scanner;

public class StairCase {
	
	public static int getWays(int n)
	{
		if(n==0)
			return 1;
		int a=0,b=0,c=0;
		if(n-1>=0)
			a=getWays(n-1);
		if(n-2>=0)
			b=getWays(n-2);
		if(n-3>=0)
			c=getWays(n-3);
		
		return a+b+c;
	}

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int ways=getWays(n);
		System.out.println(ways);
		s.close();
	}

}
