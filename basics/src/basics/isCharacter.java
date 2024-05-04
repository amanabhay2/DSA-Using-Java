package basics;

import java.util.Scanner;

public class isCharacter {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		char ch=s.next().charAt(0);
		int x=ch;
		
		if(x>=65&&x<=81)
			System.out.println("1");
		else if(x>=97&&x<=123)
			System.out.println("0");
		else
			System.out.println("-1");
		
		
		

	}

}
