package linkedlist;

import java.util.Scanner;

public class BubbleSortIterative {

	public static Node<Integer> swapAdjacent(Node<Integer> head,Node<Integer> prev)
	{
		if(prev==null)
		{
			Node<Integer> ptr1=head;
			head=head.next;
			ptr1.next=head.next;
			head.next=ptr1;
		}
		else
		{
			Node<Integer> ptr1=prev.next;Node<Integer> ptr2=ptr1.next;
			prev.next=ptr2;
			ptr1.next=ptr2.next;
			ptr2.next=ptr1;
		}
		return head;
	}
	public static Node<Integer> bubbleSortIterative(Node<Integer> head)
	{
		Node<Integer> head1=head;
		while(head1!=null&&head1.next!=null)
		{
			Node<Integer> head2=head,prev=null;
			while(head2!=null&&head2.next!=null)
			{
				if(head2.data>head2.next.data)
				{
					head=swapAdjacent(head,prev);
					
				}
				prev=head2;
				head2=head2.next;
			}
			head1=head1.next;
		}
		
		return head;
	}
	
	
	public static void print(Node<Integer> head)
	{
		while(head!=null)
		{
			System.out.print(head.data+" ");
			head=head.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int i=0;i<t;i++)
		{
			//LL Input
			int data=s.nextInt();
			Node<Integer> head=null,tail=null;
			while(data!=-1)
			{
				Node<Integer> newNode=new Node<Integer>(data);
				if(head==null)
					head=tail=newNode;
				else
				{
					tail.next=newNode;
					tail=newNode;
				}
				data=s.nextInt();
			}
			head=bubbleSortIterative(head);
			//head=bubbleSortRecursive(head);
			print(head);
		}	
		s.close();
	}

}
