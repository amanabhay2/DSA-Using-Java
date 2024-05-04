package linkedlist;

import java.util.Scanner;

public class EliminateDuplicates {

	public static void print(Node<Integer> head)
	{
		while(head!=null)
		{
			System.out.print(head.data+"  ");
			head=head.next;
		}
		System.out.println();
	}
	public static void eliminateDuplicates(Node<Integer> head)
	{
		Node<Integer> temp=head;
		head=head.next;
		while(head!=null)
		{
			if(head.data!=temp.data)
			{
				temp=temp.next;
				temp.data=head.data;
			}
			head=head.next;
		}
		temp.next=null;
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int i=0;i<t;i++)
		{
			//LLInput
			Node<Integer> head=null,tail=null;
			int data=s.nextInt();
			while(data!=-1)
			{
				Node<Integer> newNode=new Node<Integer>(data);
				if(head==null)
				{
					head=tail=newNode;
				}
				else
				{
					tail.next=newNode;
					tail=newNode;
				}
				data=s.nextInt();
			}
			//------------------
			eliminateDuplicates(head);
			print(head);
		}
		s.close();
	}

}
