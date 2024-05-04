package linkedlist;

import java.util.Scanner;

public class ReverseLL {

	public static void print(Node<Integer> head)
	{
		while(head!=null)
		{
			System.out.print(head.data+"  ");
			head=head.next;
		}
		System.out.println();
	}
	public static Node<Integer> reverseLL(Node<Integer> head)
	{
		Node<Integer> head2=null,ptr=null;
		while(head!=null)
		{
			ptr=head;
			head=head.next;
			if(head2==null)
			{
				head2=ptr;
				head2.next=null;
			}
			else
			{
				ptr.next=head2;
				head2=ptr;
			}
		}
		return head2;
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int i=0;i<t;i++)
		{
			//Input LL
			int data=s.nextInt();
			Node <Integer> head=null,tail=null;
			while(data!=-1)
			{
				Node<Integer> newNode=new Node<Integer>(data);
				if(head==null)
					head=tail=newNode;
				else {
					tail.next=newNode;
					tail=newNode;
				}
				data=s.nextInt();
			}
			//------------
			Node<Integer> reverse=reverseLL(head);
			print(reverse);			
		}
		s.close();
	}

}
