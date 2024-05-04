package linkedlist;

import java.util.Scanner;

public class FindANodeUse {

	
	public static void print(Node<Integer> head)
	{
		while(head!=null)
		{
			System.out.print(head.data+"   ");
			head=head.next;
		}
		System.out.println();
	}
	public static int findANode(Node<Integer> head,int x)
	{
		int i=0;
		while(head!=null)
		{
			if(head.data==x)
				return i;
			i++;
			head=head.next;
		}
		return -1;
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		for(int i=1;i<=n;i++)
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
			
			
			print(head);
			int key=s.nextInt();
			int index=findANode(head,key);
			System.out.println(index);
		}
		s.close();
	}

}
