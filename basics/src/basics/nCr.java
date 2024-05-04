package basics;

import java.util.Scanner;

public class nCr {
	
	public static int factorial(int a)
	{
		int x=1;
		for(int i=1;i<=a;i++)
		{
			x=x*i;
		}
		return x;
	}

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int r=s.nextInt();
		
		int nfact=factorial(n);
		int rfact=factorial(r);
		int nrfact=factorial(n-r);
		
		System.out.println(nfact/(rfact*nrfact));

	}

}
