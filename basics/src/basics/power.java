package basics;

import java.util.Scanner;

public class power {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n1=scan.nextInt();
		int n2=scan.nextInt();
		
		int product=1;
		for(int i=1;i<=n2;i++)
		{
			product=product*n1;
		}
		
		System.out.println(product);
		
	}

}
