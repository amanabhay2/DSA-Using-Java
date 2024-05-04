package linkedlist;

import java.util.Scanner;

public class ReverseLinkedList {

	public static void print(Node head)
	{
		while(head!=null)
		{
			System.out.print(head.data+"  ");
			head=head.next;
		}
		System.out.println();
	}
	public static HeadTail reverse3(Node<Integer> head)
	{
		if(head==null||head.next==null)
		{
			HeadTail h=new HeadTail();
			h.head=head;h.tail=head;
			return h;
		}
		HeadTail h1=reverse3(head.next);
		h1.tail.next=head;
		head.next=null;
		
		HeadTail h=new HeadTail();
		h.head=h1.head;
		h.tail=head;	
		return h;
	}
	public static Node<Integer> reverse2(Node<Integer> head)
	{
		if(head==null||head.next==null)
			return head;
		Node<Integer> finalLL=reverse2(head.next);
		Node<Integer> temp=finalLL;
		while(temp.next!=null)
		{
			temp=temp.next;
		}
		temp.next=head;
		head.next=null;
		return finalLL;
	}
	public static Node<Integer> reverse1(Node<Integer> head)
	{
		Node<Integer> head2=null,tail2=null,ptr=null;
		while(head!=null)
		{
			ptr=head;
			head=head.next;
			ptr.next=null;
			if(head2==null)
				head2=tail2=ptr;
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
			HeadTail h=reverse3(head);
			print(h.head);
		}		
		s.close();

	}

}
