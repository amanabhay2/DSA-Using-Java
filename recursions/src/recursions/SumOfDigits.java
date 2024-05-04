package recursions;

import java.util.Scanner;

public class SumOfDigits {

	public static int getDigitsSum(int n)
	{
		if(n==0)
			return 0;
		return n%10+getDigitsSum(n/10);
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int sum=getDigitsSum(n);
		System.out.println(sum);
		s.close();
	}

}
