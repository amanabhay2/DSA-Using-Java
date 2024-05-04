package trees;

import java.util.ArrayList;
import java.util.Scanner;

public class RootToNodePath {

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
	
	public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root,int x)
	{
		if(root==null)
			return null;
		if(root.data==x)
		{
			ArrayList<Integer> op=new ArrayList<Integer>();
			op.add(root.data);
			return op;
		}
		ArrayList<Integer> left=getPath(root.left,x);
		if(left!=null)
		{
			left.add(root.data);
			return left;
		}
		ArrayList<Integer> right=getPath(root.right,x);
		if(right!=null)
		{
			right.add(root.data);
			return right;
		}
		
		return null;
	}
	
	public static ArrayList<Integer> getPathForBST(BinaryTreeNode<Integer> root,int x)
	{
		if(root==null)
			return null;
		if(root.data==x)
		{
			ArrayList<Integer> op=new ArrayList<Integer>();
			op.add(root.data);
			return op;
		}
		else if(root.data>x)
		{
			ArrayList<Integer> a=getPathForBST(root.left,x);
			if(a!=null)
				a.add(root.data);
			return a;
		}
		else
		{
			ArrayList<Integer> a=getPathForBST(root.right,x);
			if(a!=null)
				a.add(root.data);
			return a;
		}
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		BinaryTreeNode<Integer> root=input(s);
		int x=s.nextInt();
		//ArrayList<Integer> path=getPath(root,x);
		ArrayList<Integer> path=getPathForBST(root,x);
		for(int i=0;i<path.size();i++)
		{
			System.out.print(path.get(i)+"  ");
		}
		s.close();
	}

}
