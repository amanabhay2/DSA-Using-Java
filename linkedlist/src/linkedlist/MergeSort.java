package linkedlist;

import java.util.Scanner;

public class MergeSort {

	public static Node<Integer> mergeSort(Node<Integer> head1)
	{
		//Base case
		if(head1==null||head1.next==null)
			return head1;
		//Reach Mid
		Node<Integer> head=null,head2=head1,ptr=head1;
		int count=0;
		while(ptr!=null)
		{
			count++;
			ptr=ptr.next;
		}
		count=count/2;
		while(count!=0)
		{
			ptr=head2;
			head2=head2.next;
			count--;
		}
		//Recursively mergesort
		ptr.next=null;
		head1=mergeSort(head1);
		head2=mergeSort(head2);
		//merge Sorted is answer
		head=mergeSorted(head1,head2);
		return head;
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
	public static void print(Node head)
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
			head=mergeSort(head);
			print(head);
		}		
		s.close();

	}

}
