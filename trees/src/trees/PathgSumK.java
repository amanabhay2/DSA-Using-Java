package trees;

import java.util.Scanner;
import java.util.ArrayList;
public class PathgSumK {

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
	public static void printPath(BinaryTreeNode<Integer> root,ArrayList<Integer> a,int sum,int k)
	{
		
		
		ArrayList<Integer> b=new ArrayList<>();
		for(int i=0;i<a.size();i++)
		{
			b.add(a.get(i));
		}
		b.add(root.data);sum=sum+root.data;
		if(root.left!=null)
			printPath(root.left,b,sum,k);
		if(root.right!=null)
			printPath(root.right,b,sum,k);
		
		if(root.left==null&&root.right==null)
		{
			if(sum==k)
			{
				for(int i=0;i<b.size();i++)
				{
					System.out.print(b.get(i)+"  ");
				}
				System.out.println();
				return;
			}
			else
				return;
		}
	}
	public static void main(String[] args) throws QueueEmptyException {
		Scanner s=new Scanner(System.in);
		BinaryTreeNode<Integer> root=input(s);
		ArrayList<Integer> a=new ArrayList<>();
		System.out.println("Enter path sum");
		int k=s.nextInt();
		printPath(root,a,0,k);
		//print(root);
		s.close();
	}

}
