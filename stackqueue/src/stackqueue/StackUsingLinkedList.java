package stackqueue;

public class StackUsingLinkedList <T>{
	private Node<T> top;
	
	public StackUsingLinkedList()
	{
		top=null;
	}
	public boolean isEmpty()
	{
		if(top==null)
			return true;
		else
			return false;
	}
	public int size()
	{
		int count =0;
		Node<T> temp=top;
		while(temp!=null)
		{
			count++;
			temp=temp.next;
		}
		return count;
	}
	public T Top() throws EmptyStackException
	{
		if(top==null)
		{
			EmptyStackException e=new EmptyStackException();
			throw e;
		}
		return top.data;
	}
	public void insert(T x)
	{
		Node<T> newNode=new Node<T>(x);
		newNode.next=top;
		top=newNode;
	}
	public T pop() throws EmptyStackException
	{
		if(top==null)
		{
			EmptyStackException e= new EmptyStackException();
			throw e;
		}
		T temp=top.data;
		top=top.next;
		return temp;
	}
	
	
}
