package stackqueue;

public class QueueUsingArray {
	private int[] data;
	private int front;
	private int rear;
	private int s;
	
	public QueueUsingArray()
	{
		data=new int[10];
		front=-1;
		rear=-1;
		s=0;
	}
	public QueueUsingArray(int cap)
	{
		data=new int[cap];
		front=-1;
		rear=-1;
		s=0;
	}
	
	public int size()
	{
		return s;
	}
	public boolean isEmpty()
	{
		return (s==0);
	}
	public int peek() throws QueueEmptyException
	{
		if(front==-1)
			throw new QueueEmptyException();
		return data[front];
	}
	public void doubleQueue()
	{
		int[] temp=data;
		data=new int[2*temp.length];
		int j=0;
		for(int i=front;i<temp.length;i++)
		{
			data[j]=temp[i];
			j++;
		}
		for(int i=0;i<front;i++)
		{
			data[j]=temp[i];
			j++;
		}
		front=0;
		rear=temp.length-1;
	}
	
	public void enqueue(int x)
	{
		if (s==data.length)
		{	//throw new QueueFullException();
			doubleQueue();
		}
		if(rear==-1)
			front=0;
		
		rear=(rear+1)%data.length;
		data[rear]=x;
		s++;
		
	}
	
	public int dequeue() throws QueueEmptyException
	{
		if(front==-1)
			throw new QueueEmptyException();
		
		int temp=data[front];
		front=(front+1)%data.length;
		s--;
		if(s==0)
		{
			front=rear=-1;
		}
		return temp;
	}
	
}
