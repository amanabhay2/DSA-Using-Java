package linkedlist;

import java.util.Scanner;

public class EvenAfterOdd {

	public static Node<Integer> oddEven(Node<Integer> head)
	{
		if(head==null)
			return head;
		Node<Integer> ptr=null,prev=head,h1=head,head2=null,tail2=null;
		while(h1!=null)
		{
			if(h1==head&&h1.data%2==0)
			{
				ptr=h1;
				head=head.next;
				h1=h1.next;
				ptr.next=null;
				//-----------
				if(head2==null)
					head2=tail2=ptr;
				else {
					tail2.next=ptr;
					tail2=ptr;
				}
			}
			else if(h1.data%2==0)
			{
				ptr=h1;
				prev.next=h1.next;
				h1=h1.next;
				ptr.next=null;
				//-----------
				if(head2==null)
					head2=tail2=ptr;
				else {
					tail2.next=ptr;
					tail2=ptr;
				}
			}
			else
			{	
				prev=h1;
				h1=h1.next;
			}
		}
		prev.next=head2;
		
		return head;
	}
	public static void print(Node<Integer> head)
	{
		while(head!=null)
		{
			System.out.print(head.data+"  ");
			head=head.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int i=0;i<t;i++)
		{
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
			
			head=oddEven(head);
			print(head);
		}		
		s.close();

	}

}
