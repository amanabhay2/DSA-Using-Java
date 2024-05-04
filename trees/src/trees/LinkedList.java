package trees;

public class LinkedList <T>{
	Node <T> head;
	Node <T> tail;
	public LinkedList()
	{
		head=null;
		tail=null;
	}
	
	public void insert(T data)
	{
		Node<T> a=new Node<T>(data);
		if(head==null)
			head=tail=a;
		else
		{
			tail.next=a;
			tail=a;
		}
	}
	public void delete()
	{
		
	}
}
