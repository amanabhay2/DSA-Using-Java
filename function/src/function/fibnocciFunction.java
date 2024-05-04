package function;

import java.util.Scanner;

public class fibnocciFunction {

	public static boolean fibnocci(int a)
	{
		int prev=0,current=0;
		for(int i=1;i<=a;i++)
		{
			int term=0;
			if(i==1)
				current=1;
			
			term=current+prev;
			prev=current;
			current=term;
			
			if(term==a)
				return true;
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		
		
		
		
		boolean b=fibnocci(n);
		System.out.println(b);
	}

}
