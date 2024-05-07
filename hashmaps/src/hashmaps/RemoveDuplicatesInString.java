package hashmaps;

import java.util.Scanner;
import java.util.HashMap;
public class RemoveDuplicatesInString {

	public static String removeDuplicates(String str)
	{
		HashMap<Character,Boolean> map=new HashMap<Character,Boolean>();
		String output="";
		for(int i=0;i<str.length();i++)
		{
			if(!map.containsKey(str.charAt(i)))
			{
				map.put(str.charAt(i), true);
				output+=str.charAt(i);
			}
		}
		
		return output;
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		HashMap<Character,Boolean> map=new HashMap<Character,Boolean>();
		String str=s.nextLine();
		str=removeDuplicates(str);
		System.out.println(str);
		s.close();
	}

}
