package basics;

import java.util.Scanner;

public class salaryCalculator {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int basic=scan.nextInt();
		char grade=scan.next().charAt(0);
		
		float hra=0.20f*basic;
		float da=0.50f*basic;
		float pf=0.11f*basic;
		float extra=hra+da-pf;
		
		int allow=1300;
		if(grade=='A')
			allow=1700;
		if(grade=='B')
			allow=1500;
						
		
		float totalSalary=extra+basic+allow;

		System.out.println(totalSalary);

	}

}
