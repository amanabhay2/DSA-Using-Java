package basics;

import java.util.Scanner;

public class sumAllEven {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int x=s.nextInt();
		int sum =0;
		
		
		for(int i=2;i<=x;i=i+2)
		{
			sum=sum+i;
		}

		System.out.println(sum);
	}

}
