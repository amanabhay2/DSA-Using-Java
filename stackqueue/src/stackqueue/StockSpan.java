package stackqueue;

import java.util.Scanner;

public class StockSpan {

	public static int[] stockSpan(int[] arr) throws EmptyStackException
	{
		int[] span=new int[arr.length];
		for(int i=0;i<arr.length;i++)
		{
			int count=1,same=0;
			int temp=arr[i];
			StackUsingLinkedList<Integer> stack=new StackUsingLinkedList<>();
			for(int j=0;j<=i;j++)
			{
				stack.insert(arr[j]);
			}
			while(!stack.isEmpty())
			{
				if(stack.Top()<=arr[i])
				{
					if(stack.Top()==temp)
						same++;
					count++;
					stack.pop();
				}
				else
					break;
			}
			span[i]=count-same;			
		}
		
		return span;
	}
	public static void main(String[] args) throws EmptyStackException {
		Scanner s=new Scanner(System.in);
		int size=s.nextInt();
		int[] arr=new int[size];
		for(int i=0;i<size;i++)
		{
			arr[i]=s.nextInt();
		}
		int[] span=new int[size];
		span=stockSpan(arr);
		for(int i=0;i<size;i++)
		{
			System.out.print(span[i]+"  ");
		}
		s.close();
	}

}
