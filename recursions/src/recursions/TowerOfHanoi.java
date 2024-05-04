package recursions;

import java.util.Scanner;

public class TowerOfHanoi {

	public static void TOH(int disks,char s,char a,char d)
	{
		if(disks==0)
			return;
		TOH(disks-1,s,d,a);
		System.out.println(s+"  "+d);
		TOH(disks-1,a,s,d);
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		char source='S',auxilary='A',destination='D';
		TOH(n,source,auxilary,destination);
		s.close();
	}

}
