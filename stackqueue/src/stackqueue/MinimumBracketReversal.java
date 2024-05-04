package stackqueue;

import java.util.Scanner;

public class MinimumBracketReversal {

	public static int minReversal(String str) throws EmptyStackException
	{
		if(str.length()%2!=0)
			return -1;
		int count=0;
		StackUsingLinkedList<Character> stack=new StackUsingLinkedList<>();
		for(int i=0;i<str.length();i++)
		{
			char ch=str.charAt(i);
			if(ch=='{')
			{
				stack.insert(ch);
			}
			else
			{
				if(!stack.isEmpty()&&stack.Top()=='{')
					stack.pop();
				else
				{
					stack.insert(ch);
				}
			}
		}
		while(!stack.isEmpty())
		{
			char ch1=stack.pop();
			char ch2=stack.pop();
			
			if(ch1==ch2)
				count++;
			else
				count+=2;
		}
		
		return count;
	}
	
	public static void main(String[] args) throws EmptyStackException {
		Scanner s=new Scanner(System.in);
		String str=s.next();
		System.out.println(minReversal(str));	
		s.close();
	}

}
