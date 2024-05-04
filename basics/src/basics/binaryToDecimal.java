package basics;

import java.util.Scanner;

public class binaryToDecimal {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int decimal=0;
		for(int i=1;n!=0;i++)
		{
			int temp=n%10;
			if(temp==1)
			{
				
				
				for(int j=2;j<=i;j++)
				{
					temp=temp*2;
				}
			}
			decimal=decimal+temp;
			//loop termination condition
			n=n/10;
		}
		
		System.out.println(decimal);
		

	}

}
