package recursions;

import java.util.Scanner;

public class CalculatePower {

	public static int power(int x,int n)
	{
		if(n==1)
			return x;
		int val=power(x,n-1);
		return x*val;
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int x=s.nextInt();
		int n=s.nextInt();
		int result=power(x,n);
		System.out.println(result);
	}

}
