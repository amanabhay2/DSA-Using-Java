package linkedlist;

import java.util.Scanner;

public class MergeTwoSortedList {

	
		
	
	public static void print(Node head)
	{
		while(head!=null)
		{
			System.out.print(head.data+"  ");
			head=head.next;
		}
		System.out.println();
	}
	
	public static Node<Integer> mergeSorted(Node<Integer> head1,Node<Integer> head2)
	{
		if(head1==null)
			return head2;
		else if(head2==null)
			return head1;
		else
		{
			Node<Integer> head=null,ptr=null,tail=null;
			while(head1!=null&&head2!=null)
			{
				if(head1.data>head2.data)
				{
					ptr=head2;
					head2=head2.next;
					ptr.next=null;
				}
				else
				{
					ptr=head1;
					head1=head1.next;
					ptr.next=null;
				}
				if(head==null)
					head=tail=ptr;
				else
				{
					tail.next=ptr;
					tail=ptr;
				}
			}
			while(head1!=null)
			{
				ptr=head1;
				head1=head1.next;
				ptr.next=null;
				if(head==null)
					head=tail=ptr;
				else
				{
					tail.next=ptr;
					tail=ptr;
				}
			}
			while(head2!=null)
			{
				ptr=head2;
				head2=head2.next;
				ptr.next=null;
				if(head==null)
					head=tail=ptr;
				else
				{
					tail.next=ptr;
					tail=ptr;
				}
			}
			return head;
		}
	}
	
	public static void main(String[] args) {
		//Input 1
		Scanner s=new Scanner(System.in);
		Node<Integer> head1=null,tail1=null;
		int data=s.nextInt();
		while(data!=-1)
		{
			Node<Integer> newNode=new Node<Integer>(data);
			if(head1==null)
			{
				tail1=head1=newNode;
			}
			else
			{
				tail1.next=newNode;
				tail1=newNode;
			}
			data=s.nextInt();
		}
		//Input 2
		Node<Integer> head2=null,tail2=null;
		data=s.nextInt();
		while(data!=-1)
		{
			Node<Integer> newNode=new Node<Integer>(data);
			if(head2==null)
			{
				tail2=head2=newNode;
			}
			else
			{
				tail2.next=newNode;
				tail2=newNode;
			}
			data=s.nextInt();
		}
		//-------------------------------------
		
		Node<Integer> head=mergeSorted(head1,head2);
		print(head);
		s.close();
	}

}
