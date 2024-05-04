package basics;

import java.util.Scanner;

public class firstNTermsOfAp {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		
		for(int i=1;true;i++)
		{
			if(n<1)
				break;
			int value=3*i+2;
			if(value%4!=0)
			{
				System.out.print(value+" ");
				n--;
			}
		}
		
		

	}

}
