package basics;

import java.util.Scanner;

public class checkNumberSequence {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int prev=s.nextInt();
		boolean isdec=true;
		
		for(int i=1;i<n;i++)
		{
			int curr=s.nextInt();
			
			if(prev==curr)
			{
				System.out.println("false");
				return;
			}
			else if(prev<curr)
			{
				isdec=false;
			}
			else if(prev>curr&&!isdec)
			{
				System.out.println("false");
				return;
			}
			
			prev=curr;
		}
		System.out.println("true");
		
		
		
		
		
		
		
		s.close();
	}

}
