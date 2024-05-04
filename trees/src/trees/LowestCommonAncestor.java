package trees;

import java.util.Scanner;

public class LowestCommonAncestor {

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
	
	public static Pair<BinaryTreeNode<Integer> ,Boolean> lcaHelper(BinaryTreeNode<Integer> root,int data1,int data2)
	{
		if(root==null)
		{
			Pair<BinaryTreeNode<Integer> ,Boolean> p=new Pair<BinaryTreeNode<Integer> ,Boolean>();
			p.first=null;
			p.second=false;
			return p;
		}
		if(root.data==data1||root.data==data2)
		{
			Pair<BinaryTreeNode<Integer> ,Boolean> p=new Pair<BinaryTreeNode<Integer> ,Boolean>();
			p.first=root;
			p.second=false;
			return p;
		}
		Pair<BinaryTreeNode<Integer> ,Boolean> p1=lcaHelper(root.left,data1,data2);
		Pair<BinaryTreeNode<Integer> ,Boolean> p2=lcaHelper(root.right,data1,data2);
		if(p1.first==null&&p2.first==null)
		{
			Pair<BinaryTreeNode<Integer> ,Boolean> p=new Pair<BinaryTreeNode<Integer> ,Boolean>();
			p.first=null;
			p.second=false;
			return p;
		}
		else if(p1.first==null||p2.first==null)
		{
			if(p1.second==true)
			{
				return p1;
			}
			else if(p2.second==true)
			{
				return p2;
			}
			else
			{
				Pair<BinaryTreeNode<Integer> ,Boolean> p=new Pair<BinaryTreeNode<Integer> ,Boolean>();
				p.first=root;
				p.second=false;
				return p;
			}
		}
		
		else
		{
			Pair<BinaryTreeNode<Integer> ,Boolean> p=new Pair<BinaryTreeNode<Integer> ,Boolean>();
			p.first=root;
			p.second=true;
			return p;
		}
	}
	
	public static int lowestCommonAncestor(BinaryTreeNode<Integer> root,int data1,int data2)
	{
		BinaryTreeNode<Integer> a= lcaHelper(root,data1,data2).first;
		if(a==null)
			return -1;
		else return a.data;
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		BinaryTreeNode<Integer> root=input(s);
		int data1=s.nextInt();
		int data2=s.nextInt();
		
		System.out.println(lowestCommonAncestor(root,data1,data2));
		s.close();
	}

}
