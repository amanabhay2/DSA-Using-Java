package recursions;

import java.util.Scanner;

public class Multiplication {

	public static int multiply(int x,int y)
	{
		if(y==0)
			return 0;
		
		return x+multiply(x,y-1);
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int x=s.nextInt();
		int y=s.nextInt();
		int result=multiply(x,y);
		System.out.println(result);		
		s.close();
	}

}
