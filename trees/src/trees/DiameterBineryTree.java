package trees;

import java.util.Scanner;

public class DiameterBineryTree {

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
				System.out.println("Enter left child of "+temp.data);
				data=s.nextInt();
				if(data!=-1)
				{
					BinaryTreeNode<Integer> l=new BinaryTreeNode<Integer>(data);
					temp.left=l;
					queue.enqueue(l);
				}
				System.out.println("Enter Right child of "+temp.data);
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
	public static int height(BinaryTreeNode<Integer> root)
	{
		if(root==null)
			return 0;
		return 1+Math.max(height(root.left), height(root.right));
	}
	public static int getDiameter(BinaryTreeNode<Integer> root)
	{
		if(root==null)
			return 0;
		int option1=height(root.left)+height(root.right);
		int option2=getDiameter(root.left);
		int option3=getDiameter(root.right);
		return Math.max(option3, Math.max(option2, option1));
	}
	public static Pair<Integer,Integer> heightAndDiameter(BinaryTreeNode<Integer> root)//better code with O(n)complexity
	{
		if(root==null)
		{
			Pair<Integer,Integer> p=new Pair<Integer,Integer>();
			p.first=0;p.second=0;return p;
		}
		Pair<Integer,Integer> lc=heightAndDiameter(root.left);
		Pair<Integer,Integer> rc=heightAndDiameter(root.right);
		Pair<Integer,Integer> output=new Pair<Integer,Integer>();
		//height
		output.first=1+Math.max(lc.first, rc.first);
		//diameter
		output.second=Math.max(Math.max(lc.first+rc.first, lc.second), rc.second);
		return output;
		
		
		//int o1=lc.first+rc.first;
	//	int o2=lc.second;
	//	int o3=rc.second;
		//output.second=Math.max(Math.max(o1, o2), o3);
		
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		BinaryTreeNode<Integer> root=input(s);
		int diameter=heightAndDiameter(root).second;
		System.out.println(diameter);
		
		s.close();

	}

}
