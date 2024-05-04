package stackqueue;

import java.util.Scanner;

public class QueueReverse {

	
	public static QueueUsingLinkedList<Integer> reverse(QueueUsingLinkedList<Integer> queue) throws QueueEmptyException
	{
		if(queue.Size()<=1)
			return queue;
		
		int temp=queue.dequeue();
		queue=reverse(queue);
		queue.enqueue(temp);
		return queue;
	}
	public static void main(String[] args) throws QueueEmptyException {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int i=0;i<t;i++)
		{
			int size=s.nextInt();
			QueueUsingLinkedList<Integer> queue=new QueueUsingLinkedList<>();
			for(int j=0;j<size;j++)
			{
				queue.enqueue(s.nextInt());
			}
			queue=reverse(queue);
			while(!queue.isEmpty())
			{
				System.out.print(queue.dequeue()+"   ");
			}
			System.out.println();
		}		
		s.close();
	}

}
