package stackqueue;

import java.util.Scanner;

public class CheckRedundant {

	public static boolean checkRedundant(String str) throws EmptyStackException
	{
		StackUsingLinkedList <Character> stack=new StackUsingLinkedList <Character>();
		
		for(int i=0;i<str.length();i++)
		{
			char ch=str.charAt(i);
			if(ch!=')')
				stack.insert(ch);
			else
			{
				if(stack.Top()=='(')
					return true;
				stack.pop();
				if(stack.Top()=='(')
					return true;
				while(stack.Top()!='(')
				{
					stack.pop();
				}
				stack.pop();
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws EmptyStackException {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int i=0;i<t;i++)
		{
			String str=s.next();
			System.out.println("Redundancy :"+checkRedundant(str));
		}		
		s.close();
	}

}
