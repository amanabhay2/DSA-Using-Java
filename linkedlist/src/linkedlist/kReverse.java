package linkedlist;

import java.util.Scanner;

public class kReverse {

	public static void print(Node<Integer> head)
	{
		while(head!=null)
		{
			System.out.print(head.data+" ");
			head=head.next;
		}
		System.out.println();
	}
	public static Node<Integer> kreverse(Node<Integer> head1,int k)
	{
		if(head1==null||head1.next==null)
			return head1;
		Node<Integer> head =null,tail=null,temp=null;
		int i=k;
		while(head1!=null&&i!=0)
		{
				if(head==null)
				{
					head=tail=head1;
					head1=head1.next;
				}
					else
				{
					temp=head1;
					head1=head1.next;
					temp.next=head;
					head=temp;
				}
				i--;
		}
		if(head1==null)
			tail.next=null;
		tail.next=	kreverse(head1,k);
	
		return head;
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int i=0;i<t;i++)
		{
			int data = s.nextInt();
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
			int k=s.nextInt();
			head=kreverse(head,k);
			print(head);
			
		}	
		s.close();
	}

}
