package recursions;

import java.util.Scanner;

public class CheckAB {

	public static boolean checkAB(String str)
	{
		if(str.length()==0)
			return true;
		if(str.charAt(0)=='a'&&str.length()!=1)
		{
			if(str.charAt(1)!='a')
			{
				if(str.length()==2)
					return false;
				else
				{
					if(str.charAt(1)!='b')
						return false;
					else if(str.charAt(2)!='b')
						return false;
					else 
					{
						if(str.length()!=3)
						{
							if(str.charAt(3)!='a')
								return false;
						}
					}
				}
			}
		}
		return checkAB(str.substring(1));
	}
	
	public static boolean checkAB2(String str)
	{
		if(str.length()==0)
			return true;
		if(str.charAt(0)=='a')
		{
			if(str.length()>2&&str.substring(1,3).equals("bb"))
				return checkAB2(str.substring(3));
			else
				return checkAB2(str.substring(1));
		}
		
		
		
		return false;
	}
	
	
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=s.nextLine();
		
		boolean good=checkAB2(str);
		System.out.println(good);
		
		
		
		s.close();
	}

}
