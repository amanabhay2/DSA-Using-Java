package basics;

import java.util.Scanner;

public class sumOfEvenAndOdd {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int sumEven=0,sumOdd=0;
		
		for(int i=n;i>0;i=i/10)
		{
			int temp=i%10;
			if(temp%2==0)
				sumEven=sumEven+temp;
			else
				sumOdd=sumOdd+temp;
			
		}
		
		
		
		System.out.println(sumEven+" "+sumOdd);

	}

}
