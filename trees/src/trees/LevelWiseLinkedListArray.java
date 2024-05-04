package trees;

import java.util.*;

public class LevelWiseLinkedListArray {

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
	public static int height(BinaryTreeNode<Integer> root)
	{
		if(root==null)
			return 0;
		return 1+Math.max(height(root.left), height(root.right));
	}
	public static ArrayList<Node<Integer>> levelWiseLL(BinaryTreeNode<Integer> root) throws QueueEmptyException
	{
		if(root==null)
		{
			ArrayList<Node<Integer>> arr=null;
			return arr;
		}
		QueueUsingLinkedList<BinaryTreeNode<Integer>> queue=new QueueUsingLinkedList<BinaryTreeNode<Integer>>();
		ArrayList<Node<Integer>> arr=new ArrayList<Node<Integer>>();
		queue.enqueue(root);
		queue.enqueue(null);
		LinkedList<Integer> ll=new LinkedList<Integer>();
		while(!queue.isEmpty())
		{
			BinaryTreeNode<Integer> temp=queue.dequeue();
			if(temp==null)
			{
				arr.add(ll.head);
				ll=new LinkedList<Integer>();
				if(!queue.isEmpty())
				{
					queue.enqueue(null);
				}
			}
			else
			{
				ll.insert(temp.data);
				if(temp.left!=null)
				{
					queue.enqueue(temp.left);
				}
				if(temp.right!=null)
				{
					queue.enqueue(temp.right);
				}
			}			
		}
		return arr;
	}
	
	public static void main(String[] args) throws QueueEmptyException {
		Scanner s=new Scanner(System.in);
		BinaryTreeNode<Integer> root=input(s);
		//int h=height(root);
		ArrayList<Node<Integer>> arr=levelWiseLL(root);
		for(int i=0;i<arr.size();i++)
		{
			Node<Integer> head=arr.get(i);
			while(head!=null)
			{
				System.out.print(head.data+"   ");
				head=head.next;
			}
			System.out.println();
		}		
		s.close();
	}

}
