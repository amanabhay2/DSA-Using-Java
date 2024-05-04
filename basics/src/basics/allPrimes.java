package basics;

import java.util.Scanner;

public class allPrimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		
		
		for(int i=2;i<n;i++)
		{
			boolean bool=false;
			
			for(int j=2;j<i;j++)
			{
				if(i%j==0)
					bool=true;
			}
			
			if(!bool)
				System.out.println(i);
		}
		
	}

}
