package recursions;

import java.util.Scanner;

public class ZeroesCountInInteger {

	public static int countZeroes(int x)
	{
		if(x==0)
			return 0;
		int count=countZeroes(x/10);
		if(x%10==0)
			count++;
		return count;
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int x=s.nextInt();
		
		int count=countZeroes(x);
		System.out.println(count);		
		s.close();
	}

}
