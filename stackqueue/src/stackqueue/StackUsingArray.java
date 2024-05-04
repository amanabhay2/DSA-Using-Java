package stackqueue;

public class StackUsingArray {
	private int data[];
	private int top;
	
	public StackUsingArray() 
	{
		data=new int[10];
		top=-1;
	}
	public StackUsingArray(int size) 
	{
		data=new int[size];
		top=-1;
	}
	
	
	public boolean isEmpty()
	{
		return (top==-1);
	}
	public int size()
	{
		return top+1;
	}
	public int Top() throws EmptyStackException
	{
		if(top==-1)
		{
			EmptyStackException e=new EmptyStackException();
			throw e;
		}
		return data[top];
	}
	public void insert(int x) throws StackFullException
	{
		top++;
		if(top==data.length)
		{
			StackFullException e=new StackFullException();
			throw e;
		}
		data[top]=x;
	}
	public int pop() throws EmptyStackException
	{
		if(top==-1)
		{
			EmptyStackException e=new EmptyStackException();
			throw e;
		}
		int temp=data[top];
		top--;
		return temp;
	}
}
