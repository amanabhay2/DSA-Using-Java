package linkedlist;

import java.util.Scanner;

public class DeleteEveryNafterM {

	public static void print(Node<Integer> head)
	{
		while(head!=null)
		{
			System.out.print(head.data+"  ");
			head=head.next;
		}
		System.out.println();
	}
	
	public static Node<Integer> newlist(Node<Integer> head,int m,int n)
	{
		if(head==null)
			return head;
		Node<Integer> head1=null,tail1=null;
		while(head!=null)
		{
			int i=m,j=n;
			while(i!=0&&head!=null)
			{
				if(head1==null)
					head1=tail1=head;
				else
				{
					tail1.next=head;
					tail1=head;
				}
				//--------------
				head=head.next;
				i--;
			}
			while(j!=0&&head!=null)
			{
				//--------------
				head=head.next;
				j--;
			}			
		}
		tail1.next=null;
		return head1;
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int i=0;i<t;i++)
		{
			//LL Input
			Node<Integer> head=null,tail=null;
			int data=s.nextInt();/**/
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
			//----------------------
			int m=s.nextInt();
			int n=s.nextInt();
			head=newlist(head,m,n);
			print(head);			
		}	
		s.close();
	}

}
