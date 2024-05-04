package linkedlist;
import java.util.Scanner;
public class CheckPalindromeLL {

	public static Node<Integer> reverseLL(Node<Integer> head)
	{
		Node<Integer> head2=null,ptr=null;
		while(head!=null)
		{
			ptr=head;
			head=head.next;
			if(head2==null)
			{
				head2=ptr;
				head2.next=null;
			}
			else
			{
				ptr.next=head2;
				head2=ptr;
			}
		}
		return head2;
	}
	
	public static boolean checkPalindrome(Node<Integer> head1)
	{
		int count=0;
		Node<Integer> temp=head1,head2=head1;
		while(temp!=null)
		{
			count++;
			temp=temp.next;
		}
		count=count/2;
		while(count!=1)
		{
			head2=head2.next;
			count--;
		}
		temp=head2;
		head2=head2.next;
		temp.next=null;
		head2=reverseLL(head2);
		//
		while(head1!=null&&head2!=null)
		{
			if(head1.data!=head2.data)
				return false;
			head1=head1.next;
			head2=head2.next;			
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		for(int i=0;i<t;i++)
		{
			//LL Input
			Node<Integer> head=null,tail=null;
			int data=s.nextInt();
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
			//check palindrome
			boolean isPalindrome= checkPalindrome(head);
			System.out.println(isPalindrome);			
		}
		s.close();
	}

}
