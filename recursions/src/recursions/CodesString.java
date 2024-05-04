package recursions;

import java.util.Scanner;

public class CodesString {

	public static char getCharacter(int n)
	{
		return (char)('a'+n-1);
	}
	public static String[] getAllCodes(String str)
	{
		if(str.length()==0)
		{
			String[] out= {""};
			return out;
		}
		String[] temp1=getAllCodes(str.substring(1));
		char ch=getCharacter((int)(str.charAt(0)-'0'));
		for(int i=0;i<temp1.length;i++)
		{
			temp1[i]=ch+temp1[i];
		}
		if(str.length()>1)
		{
			String[] temp2=getAllCodes(str.substring(2));
			int a=(int)(str.charAt(0)-'0')*10+(int)(str.charAt(1)-'0');
			if(a>26)
				return temp1;
			char ch2=getCharacter(a);
			for(int i=0;i<temp2.length;i++)
			{
				temp2[i]=ch2+temp2[i];
			}
			String[] Output=new String[temp1.length+temp2.length]; 
			int k=0;
			for(int i=0;i<temp1.length;i++)
			{
				Output[k]=temp1[i];
				k++;
			}
			for(int i=0;i<temp2.length;i++)
			{
				Output[k]=temp2[i];
				k++;
			}
			return Output;
		}
		else 
			return temp1;
		
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String str=s.nextLine();
		String[] codes=getAllCodes(str);
		for(int i=0;i<codes.length;i++)
		{
			System.out.println(codes[i]);
		}
		s.close();
	}

}
