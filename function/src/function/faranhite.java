package function;

import java.util.Scanner;

public class faranhite {
	
	public static void faran(int A,int B, int C)
	{
		for(int i=A;i<=B;i=i+C)
		{
			System.out.println(i+"\t"+(5*(i-32)/9));
		}
	}

	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		int S=s.nextInt();
		int E=s.nextInt();
		int W=s.nextInt();
		
		faran(S,E,W);
		

	}

}
