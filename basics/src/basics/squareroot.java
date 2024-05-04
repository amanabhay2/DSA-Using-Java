package basics;

import java.util.Scanner;

public class squareroot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int number=0;
		for(int i=1;i<=n;i++)
		{
			
			if(i*i>n)
				break;
			number=i;
		}
		System.out.println(number);
	}

}
