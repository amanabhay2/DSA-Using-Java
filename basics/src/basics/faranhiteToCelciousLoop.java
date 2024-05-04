package basics;

import java.util.Scanner;

public class faranhiteToCelciousLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int S=scan.nextInt();
		int E=scan.nextInt();
		int W=scan.nextInt();
		
		for(int i=S;i<=E;i=i+W)
		{
			System.out.println(i+" "+5*(i-32)/9);
		}

	}

}
