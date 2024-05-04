package basics;

import java.util.Scanner;

public class decimalToBinary {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int decimal=s.nextInt();
		
		int binary=0,placeValue=1;
		
		for(int i=1;decimal!=0;i++)
		{
			
			if(decimal%2!=0)
				binary=binary+placeValue;
			
			placeValue=placeValue*10;
			decimal=decimal/2;
		}
		System.out.println(binary);

	}

}
