package trees;

import java.util.Scanner;

public class NodesWithoutSiblings {

	public static BinaryTreeNode<Integer> input(Scanner s)
	{
		System.out.println("EnterData");
		int data=s.nextInt();
		if(data==-1)return null;
		BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(data);
		QueueUsingLinkedList<BinaryTreeNode<Integer>> queue=new QueueUsingLinkedList<BinaryTreeNode<Integer>>();
		queue.enqueue(root);
		while(!queue.isEmpty())
		{
			try {
				BinaryTreeNode<Integer> temp=queue.dequeue();
				System.out.println("Enter left chile of "+temp.data);
				data=s.nextInt();
				if(data!=-1)
				{
					BinaryTreeNode<Integer> l=new BinaryTreeNode<Integer>(data);
					temp.left=l;
					queue.enqueue(l);
				}
				System.out.println("Enter Right chile of "+temp.data);
				data=s.nextInt();
				if(data!=-1)
				{
					BinaryTreeNode<Integer> r=new BinaryTreeNode<Integer>(data);
					temp.right=r;
					queue.enqueue(r);
				}
			} catch (QueueEmptyException e) {}
			
		}
		
		return root;
	}
	public static void printWithoutSibling(BinaryTreeNode<Integer> root)
	{
		if(root==null) return;
		
		if(root.right==null&&root.left!=null)
		{
			System.out.print(root.left.data+"   ");
		}
		if(root.left==null&&root.right!=null)
		{
			System.out.print(root.right.data+"   ");
		}
		
		
		printWithoutSibling(root.left);
		printWithoutSibling(root.right);
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		BinaryTreeNode<Integer> root=input(s);
		printWithoutSibling(root);
		
		s.close();
	}

}
