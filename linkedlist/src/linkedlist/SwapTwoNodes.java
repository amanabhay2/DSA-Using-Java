package linkedlist;

import java.util.Scanner;

public class SwapTwoNodes {

	
	public static void print(Node<Integer> head)
	{
		while(head!=null)
		{
			System.out.print(head.data+"  ");
			head=head.next;
		}
		System.out.println();
	}
	public static Node<Integer> swaplist(Node<Integer> head,int i,int j)
	{
		if(i==j)
			return head;
		Node<Integer> current=head,currentPrev=null;
		Node<Integer> first=null,firstPrev=null;
		Node<Integer> second=null,secondPrev=null;
		int pos=0;
		while(current!=null)
		{
			if(pos==i)
			{
				firstPrev=currentPrev;
				first=current;
			}
			else if(pos==j)
			{
				secondPrev=currentPrev;
				second=current;
			}
			currentPrev=current;
			current=current.next;
			pos++;
		}
		
		if(firstPrev!=null)
		{
			firstPrev.next=second;
		}
		else
		{
			head=second;
		}
		if(secondPrev!=null)
		{
			secondPrev.next=first;
		}
		else
		{
			head=first;
		}
		Node<Integer> temp=first.next;
		first.next=second.next;
		second.next=temp;
		
		return head;
	}
	
	/*
	public static Node<Integer> swaplist(Node<Integer> head,int j,int k)
	{
		Node<Integer> head1=head,ptr=null;
		Node<Integer> n1=null,pos1=null,n2=null,pos2=null;
		if(j==k)
			return head1;
		if(j==0||k==0)
		{
			if(j==0)
			{
				while(head!=null)
				{
					if(k==0)
					{
						pos2=ptr;
						n2=head;
						pos2.next=head.next;
					}
					k--;
					ptr=head;
					head=head.next;
				}
				n1=head1;
				head1=n2;
				n2.next=n1.next;
				n1.next=pos2.next;
				pos2.next=n1;
				return head1;
			}
			else 
			{
				while(head!=null)
				{
					if(j==0)
					{
						pos2=ptr;
						n2=head;
						pos2.next=head.next;
					}
					j--;
					ptr=head;
					head=head.next;
				}
				n1=head1;
				head1=n2;
				n2.next=n1.next;
				n1.next=pos2.next;
				pos2.next=n1;
				return head1;
			}			
		}
		else if (k-j==1||j-k==1)
		{
			if(j<k)
			{
				while(head!=null)
				{
					if(j==0)
					{
						pos1=ptr;
						n1=head;
						break;
					}
					j--;
					ptr=head;
					head=head.next;
				}
				n2=n1.next;
				n1.next=n2.next;
				n2.next=n1;
				pos1.next=n2;
				return head1;
			}
			else
			{
				while(head!=null)
				{
					if(k==0)
					{
						pos1=ptr;
						n1=head;
						break;
					}
					k--;
					ptr=head;
					head=head.next;
				}
				n2=n1.next;
				n1.next=n2.next;
				n2.next=n1;
				pos1.next=n2;
				return head1;
			}
			
		}
		else if((j==0&&k==1)||(j==1&&k==0))
		{
				n1=head1;
				head1=head1.next;
				pos1=head1;
				n1.next=pos1.next;
				pos1.next=n1;
				return head1;
		}
		else
		{
			while(head!=null)
			{
				if(j==0)
				{
					pos1=ptr;
					n1=head;
					pos1.next=head.next;
				}
				if(k==0)
				{
					pos2=ptr;
					n2=head;
					pos2.next=head.next;
				
				}
				k--;
				j--;
				ptr=head;
				head=head.next;
			}
			n2.next=pos1.next;
			pos1.next=n2;
		
			n1.next=pos2.next;
			pos2.next=n1;
		}
		return head1;
	}
	
	*/
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
			int j=s.nextInt();
			int k=s.nextInt();
			head=swaplist(head,j,k);
			print(head);			
		}	
		s.close();
	}

}
