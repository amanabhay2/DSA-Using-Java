package basics;

import java.util.Scanner;

public class sumOrProduct {

	public static void main(String[] args) {
		
		System.out.println("Enter a number     Further for sum of digits enter 1 and for product of digits enter 2");
		
		
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int choice=s.nextInt();
		
		if(choice==1)
		{
			//SUM
			int sum=0;
			for(int i=1;i<=n;i++)
				sum=sum+i;
			System.out.println(sum);
		}
		else if(choice==2)
		{
			//PRODUCT
			int product=1;
			for(int i=1;i<=n;i++)
				product=product*i;
			System.out.println(product);
		}
		else
		{
			System.out.println("-1");
		}

	}

}
