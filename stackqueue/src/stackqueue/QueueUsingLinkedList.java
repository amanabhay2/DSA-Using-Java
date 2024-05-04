package stackqueue;

public class QueueUsingLinkedList<T> {
	Node<T> front;
	Node<T> rare;
	int size;
	
	public QueueUsingLinkedList()
	{
		front=null;
		rare=null;
		size=0;
	}
	
	public boolean isEmpty()
	{
		return size==0;
	}
	public int Size()
	{
		return size;
	}
	public T peek() throws QueueEmptyException
	{
		if(front==null)
			throw new QueueEmptyException();
		return front.data;
	}
	
	public T dequeue() throws QueueEmptyException
	{
		if(front==null)
			throw new QueueEmptyException();;
		T temp=front.data;
		front=front.next;
		size--;
		if(size==0)
			front=rare=null;
		return temp;
	}
	public void enqueue(T x)
	{
		Node<T> newNode=new Node<T>(x);
		if(rare==null)
		{
			front=rare=newNode;
			size++;
			return;
		}
		rare.next=newNode;
		size++;
		rare=newNode;
	}
}
