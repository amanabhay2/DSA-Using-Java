package trees;
import java.util.Scanner;
public class BinaryTreeUse {

	public static BinaryTreeNode<Integer> input1(Scanner s)
	{
		System.out.println("mujhe date chahiye..");
		int data=s.nextInt();
		if(data==-1)
			return null;
		BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(data);
		root.left=input1(s);
		root.right=input1(s);
		return root;
	}
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
	
	public static void print1(BinaryTreeNode<Integer> root)
	{
		if(root==null)
			return;
		String str=root.data+"  : ";
		if(root.left!=null)
			str+=root.left.data+"  ";
		if(root.right!=null)
			str+=root.right.data+"  ";
		System.out.println(str);
		print1(root.left);
		print1(root.right);
	}
	public static void print(BinaryTreeNode<Integer> root)
	{
		if(root==null)return;
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
					str+=" L "+temp.left.data+"   ";
				}
				if(temp.right!=null)
				{
					queue.enqueue(temp.right);
					str+=" R "+temp.right.data+"   ";
				}
				System.out.println(str);
			} catch (QueueEmptyException e) {}
			
		}
	}
	public static void inOrder(BinaryTreeNode<Integer> root)
	{
		if(root==null) return;
		
		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);
	}
	public static void preOrder(BinaryTreeNode<Integer> root)
	{
		if(root==null) return;
		
		System.out.println(root.data);
		preOrder(root.left);
		preOrder(root.right);
	}
	public static void postOrder(BinaryTreeNode<Integer> root)
	{
		if(root==null) return;
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.data);
	}
	public static void main(String[] args) throws QueueEmptyException {
		Scanner s=new Scanner(System.in);
		BinaryTreeNode<Integer> root=input(s);
		print2(root);
		s.close();
	}

}
