package linkedlist;

import java.util.Scanner;

public class PrintMid {

	public static int getMid(Node<Integer> head)
	{
		if(head==null)
			return -1;
		Node<Integer> slow=head;
		Node<Integer> fast=head;
		while(fast!=null&&fast.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow.data;
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
			int mid=getMid(head);
			System.out.println(mid);
		}		
		s.close();
	}

}
