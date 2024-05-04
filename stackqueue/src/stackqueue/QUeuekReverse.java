package stackqueue;

import java.util.Scanner;

public class QUeuekReverse {

	public static QueueUsingLinkedList<Integer> kReverse(QueueUsingLinkedList<Integer> queue,int k) throws QueueEmptyException, EmptyStackException
	{
		if(queue.isEmpty()||k>queue.Size())
			return queue;
		if(k<=0)
			return queue;
		
		StackUsingLinkedList<Integer> stack=new StackUsingLinkedList<Integer>();
		for(int i=0;i<k;i++)
		{
			stack.insert(queue.dequeue());
		}
		QueueUsingLinkedList<Integer> queue1=new QueueUsingLinkedList<>();
		for(int i=0;i<k;i++)
		{
			queue1.enqueue(stack.pop());
		}
		while(!queue.isEmpty())
		{
			queue1.enqueue(queue.dequeue());
		}
		
		return queue1;
	}
	
	public static void main(String[] args) throws QueueEmptyException, EmptyStackException {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int k=s.nextInt();
		
		QueueUsingLinkedList<Integer> queue=new QueueUsingLinkedList<>();
		for(int j=0;j<n;j++)
		{
			queue.enqueue(s.nextInt());
		}
			
		queue=kReverse(queue,k);
		while(!queue.isEmpty())
		{
			System.out.print(queue.dequeue()+"   ");
		}
		System.out.println();
			
		s.close();

	}

}
