package linkedlist;

import java.util.Scanner;

public class LastNToFirst {

	public static Node<Integer> lastNtoFirst(Node<Integer> head,int n)
	{
		if(head==null||n==0)
			return head;
		
		int total=1;
		Node<Integer> temp=head,temp2=head;
		while(temp.next!=null)
		{
			temp=temp.next;
			total++;
		}
		temp.next=head;
		while(total-1!=n)
		{
			temp2=temp2.next;
			total--;
		}
		head=temp2.next;
		temp2.next=null;		
		return head;
	}
	public static void print(Node<Integer> head)
	{
		while(head!=null)
		{
			System.out.print(head.data+"   ");
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
			print(head);
			int x=s.nextInt();
			head=lastNtoFirst(head,x);
			print(head);
		}
		s.close();
	}

}
