package basics;

import java.util.Scanner;

public class reverseOfNumber {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		long n=s.nextLong();
		long reverse=0;
		
		while(n!=0)
		{
			reverse=reverse*10+(n%10);
			n=n/10;
		}
		System.out.println(reverse);	

	}

}
