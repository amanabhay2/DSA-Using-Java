package stackqueue;

public class StackUse {

	public static void main(String[] args) throws StackFullException, EmptyStackException {
		StackUsingLinkedList stack=new StackUsingLinkedList();
		for(int i=1;i<11;i++)
		{
			stack.insert(i);
		}
		
		System.out.println(stack.Top());
		System.out.println(stack.size());
		System.out.println(stack.isEmpty());
		
		while(!stack.isEmpty())
		{
			System.out.println(stack.pop());
		}
		System.out.println(stack.isEmpty());
	}

}
