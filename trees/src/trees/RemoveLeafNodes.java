package trees;

import java.util.Scanner;

public class RemoveLeafNodes {

	public static void print(BinaryTreeNode<Integer> root)
	{
		if(root==null) return;
		QueueUsingLinkedList<BinaryTreeNode<Integer>> queue=new QueueUsingLinkedList<BinaryTreeNode<Integer>>();
		queue.enqueue(root);
		while(!queue.isEmpty())
		{
			try {
				BinaryTreeNode<Integer> temp=queue.dequeue();
				String str=temp.data+"  : ";
				if(temp.left!=null)
				{
					queue.enqueue(temp.left);
					str+=" L "+temp.left.data+"  ";
				}
				if(temp.right!=null)
				{
					queue.enqueue(temp.right);
					str+=" R "+temp.right.data+"  ";
				}
				System.out.println(str);
			} catch (QueueEmptyException e) {}
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
	public static boolean checkLeaf(BinaryTreeNode<Integer> node)
	{
		if(node.right==null&&node.left==null)
			return true;
		return false;
	}
	public static BinaryTreeNode<Integer> deleteLeafNodes(BinaryTreeNode<Integer> root)
	{
		if(root==null)
			return root;
		if(checkLeaf(root))
			return null;
		
			
		root.left=deleteLeafNodes(root.left);
		root.right=deleteLeafNodes(root.right);
		return root;
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		BinaryTreeNode<Integer> root=input(s);
		root=deleteLeafNodes(root);
		
		print(root);
		s.close();
	}

}
