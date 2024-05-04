package basics;

import java.util.Scanner;

public class fibnocci {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		
		int prev=0,curr=1,Nth=1;
		
		//System.out.println("1st -- 1");
		for(int i=2;i<=n;i++)
		{
			Nth=prev+curr;
			
			prev=curr;
			curr=Nth;
			
		}
		System.out.println(Nth);

	}

}
