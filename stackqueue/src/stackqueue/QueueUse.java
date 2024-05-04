package stackqueue;

public class QueueUse {

	public static void main(String[] args) throws  QueueEmptyException {
		//QueueUsingArray queue=new QueueUsingArray(3);
		QueueUsingLinkedList<Integer> queue=new QueueUsingLinkedList<>();
		for(int i=0;i<10;i++)
		{
			queue.enqueue(i);
		}
		//queue.dequeue();
		//queue.enqueue(100);
		while(!queue.isEmpty())
		{
			System.out.println(queue.dequeue());
		}
		

	}

}
