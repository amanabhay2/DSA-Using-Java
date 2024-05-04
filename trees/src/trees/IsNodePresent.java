package trees;

import java.util.Scanner;

public class IsNodePresent {

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
	public static boolean isPresent(BinaryTreeNode<Integer> root,int x)
	{
		if(root==null)
			return false;
		if(root.data==x)
			return true;
		boolean b1=isPresent(root.right,x);
		boolean b2=isPresent(root.left,x);
		if(b1==true||b2==true)
			return true;
		
		return false;
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		BinaryTreeNode<Integer> root=input(s);
		System.out.println("Enter search element");
		int data=s.nextInt();
		System.out.println(isPresent(root,data));
		
		s.close();
	}

}
