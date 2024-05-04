package basics;

import java.util.Scanner;

public class isPrime {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int x=s.nextInt();
		
		for(int i=2;i<x;i++)
		{
			if(x%i==0)
			{
				System.out.println("Not Prime");
				return;
			}
			
		}
		System.out.println("Is Prime");
	}

}
