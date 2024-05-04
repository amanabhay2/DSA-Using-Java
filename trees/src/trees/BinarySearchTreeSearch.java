package trees;

import java.util.Scanner;

public class BinarySearchTreeSearch {

	public static void print2(BinaryTreeNode<Integer> root) throws QueueEmptyException
	{
		if(root==null) return;
		QueueUsingLinkedList<BinaryTreeNode<Integer>> queue=new QueueUsingLinkedList<BinaryTreeNode<Integer>>();
		queue.enqueue(root);
		queue.enqueue(null);
		while(!queue.isEmpty())
		{
			BinaryTreeNode<Integer> temp=queue.dequeue();
			if(temp==null)
			{
				System.out.println();
				if(!queue.isEmpty())
					queue.enqueue(null);
			}
			else
			{
				System.out.print(temp.data);
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
		
		
	}
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
	public static boolean search(BinaryTreeNode<Integer> root,int data)
	{
		if(root==null) 
			return false;
		if(root.data>data)
		{
			return search(root.left,data);
		}
		else if(root.data<data)
		{
			return search(root.right,data);
		}
		else
			return true;
	}
	public static void printInRange(BinaryTreeNode<Integer> root,int from,int to)
	{
		if(root==null)
			return;
		if(root.data>to)
		{
			printInRange(root.left,from,to);
		}
		else if (root.data<from)
		{
			printInRange(root.right,from,to);
		}
		else
		{
			System.out.print(root.data+"  ");
			printInRange(root.left,from,to);
			printInRange(root.right,from,to);
		}
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		BinaryTreeNode<Integer> root=input(s);
		int from=s.nextInt();int to=s.nextInt();
		//System.out.println(search(root,data));
		printInRange(root,from,to);
		s.close();
	}

}
