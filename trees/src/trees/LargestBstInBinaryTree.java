package trees;

import java.util.Scanner;

public class LargestBstInBinaryTree {

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
	
	public static Quad<Boolean,Integer,Integer,Integer> findLargestBst(BinaryTreeNode<Integer> root)
	{
		if(root==null)
		{
			Quad<Boolean,Integer,Integer,Integer> q=new Quad<Boolean,Integer,Integer,Integer>();
			q.first=true;	q.second=Integer.MIN_VALUE;		q.third=Integer.MAX_VALUE;	q.fourth=0;
			return q;
		}
		Quad<Boolean,Integer,Integer,Integer> output=new Quad<Boolean,Integer,Integer,Integer>();
		Quad<Boolean,Integer,Integer,Integer> left=findLargestBst(root.left);
		Quad<Boolean,Integer,Integer,Integer> right=findLargestBst(root.right);
		output.first=left.first&&right.first&&(left.second<root.data&&right.third>root.data);
		output.second=Math.max(root.data, Math.max(left.second, right.second));
		output.third=Math.min(root.data, Math.min(left.third, right.third));
		if(output.first==true)
			output.fourth=1+Math.max(left.fourth, right.fourth);
		else
			output.fourth=Math.max(left.fourth, right.fourth);
		return output;
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		BinaryTreeNode<Integer> root=input(s);
		System.out.println(findLargestBst(root).fourth);
		s.close();
	}

}
