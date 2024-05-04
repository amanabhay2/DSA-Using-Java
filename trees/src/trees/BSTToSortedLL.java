package trees;

import java.util.Scanner;

public class BSTToSortedLL {

	public static BinaryTreeNode<Integer> input(Scanner s)
	{
		System.out.println("Enter data");
		int data=s.nextInt();
		if(data==-1)
			return null;
		BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(data);
		QueueUsingLinkedList<BinaryTreeNode<Integer>> queue=new QueueUsingLinkedList<BinaryTreeNode<Integer>>();
		queue.enqueue(root);
		while(!queue.isEmpty())
		{
			try {
				BinaryTreeNode<Integer> temp=queue.dequeue();
				System.out.println("Enter data for Left child of "+temp.data);
				data=s.nextInt();
				if(data!=-1)
				{
					BinaryTreeNode<Integer> left=new BinaryTreeNode<Integer>(data);
					temp.left=left;
					queue.enqueue(left);
				}
				System.out.println("Enter data for Right child of "+temp.data);
				data=s.nextInt();
				if(data!=-1)
				{
					BinaryTreeNode<Integer> right=new BinaryTreeNode<Integer>(data);
					temp.right=right;
					queue.enqueue(right);
				}	
			} catch (QueueEmptyException e) {}
			
		}
		return root;
	}
	public static void toLinkedList(BinaryTreeNode<Integer> root,LinkedList<Integer> l)
	{
		if(root==null) return;
		toLinkedList(root.left,l);
		//----------------------------------
		l.insert(root.data);		
		//----------------------------------
		toLinkedList(root.right,l);
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		BinaryTreeNode<Integer> root=input(s);
		LinkedList<Integer> ll=new LinkedList<Integer>();
		toLinkedList(root,ll);
		while(ll.head!=null)
		{
			System.out.print(ll.head.data+"   ");
			ll.head=ll.head.next;
		}
		s.close();
	}

}
