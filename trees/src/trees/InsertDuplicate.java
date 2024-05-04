package trees;

import java.util.Scanner;

public class InsertDuplicate {

	public static void print(BinaryTreeNode<Integer> root) throws QueueEmptyException
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
	public static void insertDuplicates(BinaryTreeNode<Integer> root) throws QueueEmptyException
	{
		if(root==null) return;
		QueueUsingLinkedList<BinaryTreeNode<Integer>> queue=new QueueUsingLinkedList<BinaryTreeNode<Integer>>();
		queue.enqueue(root);
		while(!queue.isEmpty())
		{
			BinaryTreeNode<Integer> temp=queue.dequeue();
			BinaryTreeNode<Integer> dupli=new BinaryTreeNode<Integer>(temp.data);
			dupli.left=temp.left;
			temp.left=dupli;
			if(dupli.left!=null)
				queue.enqueue(dupli.left);
			if(temp.right!=null)
				queue.enqueue(temp.right);
		}
		
	}
	public static Pair<Integer,Integer> maxMIN(BinaryTreeNode<Integer> root)
	{
		if(root==null)
		{
			Pair<Integer,Integer> op=new Pair<Integer,Integer>();
			op.first=Integer.MIN_VALUE;
			op.second=Integer.MAX_VALUE;
			return op;
		}
		
		Pair<Integer,Integer> A1=maxMIN(root.left);
		Pair<Integer,Integer> A2=maxMIN(root.right);
		Pair<Integer,Integer> op=new Pair<Integer,Integer>();
		op.first=Math.max(root.data, Math.max(A1.first, A2.first));
		op.second=Math.min(root.data,Math.min(A1.second, A2.second));
		return op;
	}
	public static void main(String[] args) throws QueueEmptyException {
		Scanner s=new Scanner(System.in);
		BinaryTreeNode<Integer> root=input(s);
		insertDuplicates(root);
		//print(root);
		System.out.println("Max : "+maxMIN(root).first);
		System.out.println("Min : "+maxMIN(root).second);
		s.close();
	}

}
