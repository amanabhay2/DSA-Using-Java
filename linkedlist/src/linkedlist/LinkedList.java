package linkedlist;
import java.util.Scanner;
public class LinkedList {

	public static void print(Node head)
	{
		while(head!=null)
		{
			System.out.print(head.data+"  ");
			head=head.next;
		}
		System.out.println();
	}
	public static void traverse(Node head)
	{
		while(head!=null)
		{
			System.out.println(head.data+" wow");
			head=head.next;
		}
	}
	public static Node insertInBeg(Node<Integer> head,int x)
	{
		Node<Integer> temp=new Node<Integer>(x);
		temp.next=head;
		head=temp;
		return head;
	}
	public static Node deleteInBeg(Node<Integer> head)
	{
		head=head.next;
		return head;
	}
	public static Node<Integer> input()
	{
		Scanner s=new Scanner(System.in);
		Node<Integer> head=null,tail=null;
		int data=s.nextInt();
		while(data!=-1)
		{
			Node<Integer> newNode=new Node<Integer>(data);
			if(head==null)
			{
				tail=head=newNode;
			}
			else
			{
				tail.next=newNode;
				tail=newNode;
			}
			data=s.nextInt();
		}
		s.close();
		return head;
	}
	public static void insertAtPos(Node<Integer> head,int pos)
	{
		int i=1;
		Node<Integer> temp=head;
		while(i<pos-1&&temp!=null)
		{
			temp=temp.next;
			i++;
		}
		if(temp!=null)
		{
			Node<Integer> newNode=new Node<Integer>(100);
			newNode.next=temp.next;
			temp.next=newNode;		
		}
	}
	public static void delInEnd(Node<Integer> head)
	{
		if(head==null)
			return;
		else if (head.next==null)
			head=null;
		else
		{
			while(head.next.next!=null)
			{
				head=head.next;
			}
			head.next=null;
		}
	}
	public static void main(String[] args) {
		Node<Integer> head=input();
		print(head);
		insertAtPos(head,3);
		print(head);
		delInEnd(head);
		print(head);
	}

}
