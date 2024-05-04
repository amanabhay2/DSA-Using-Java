package trees;

import java.util.Scanner;

public class TreeTraversal {

	public static TreeNode<Integer> input(Scanner s)
	{
		System.out.println("Enter Data");
		int data=s.nextInt();
		TreeNode<Integer> root=new TreeNode<Integer>(data);
		QueueUsingLinkedList<TreeNode<Integer>> queue=new QueueUsingLinkedList<TreeNode<Integer>>();
		queue.enqueue(root);
		while(!queue.isEmpty())
		{
			TreeNode<Integer> temp;
			try {
				temp = queue.dequeue();
				System.out.println("Enter number of Children for "+temp.data);
				int c=s.nextInt();
				for(int i=0;i<c;i++)
				{
					System.out.println("Enter Data");
					data=s.nextInt();
					TreeNode<Integer> child=new TreeNode<Integer>(data);
					temp.child.add(child);
					queue.enqueue(child);
				}
			} catch (QueueEmptyException e) {}
			
		}		
		return root;
	}
	
	public static void print(TreeNode<Integer> root)
	{
		QueueUsingLinkedList<TreeNode<Integer>> queue=new QueueUsingLinkedList<>();
		queue.enqueue(root);
		while(!queue.isEmpty())
		{
			try {
				TreeNode<Integer> temp=queue.dequeue();
				String str=temp.data+":";
				for(int i=0;i<temp.child.size();i++)
				{
					TreeNode<Integer> A=temp.child.get(i);
					queue.enqueue(A);
					str+=A.data;
				}
				System.out.println(str);
			} catch (QueueEmptyException e) {}
			
		}
		
	}
	
	public static void printPreOrder(TreeNode<Integer> root)
	{
		String str=root.data+": ";
		for(int i=0;i<root.child.size();i++)
		{
			str=str+root.child.get(i).data+"  ";
		}
		System.out.println(str);
		
		for(int i=0;i<root.child.size();i++)
		{
			printPreOrder(root.child.get(i));
		}
	}
	
	public static void printPostOrder(TreeNode<Integer> root)
	{
		for(int i=0;i<root.child.size();i++)
		{
			printPostOrder(root.child.get(i));
		}
		
		String str=root.data+": ";
		for(int i=0;i<root.child.size();i++)
		{
			str=str+root.child.get(i).data+"  ";
		}
		System.out.println(str);
		
		
	}

	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		TreeNode<Integer> root=input(s);
		print(root);
		System.out.println("-------------------------------------------------------------");
		
		printPreOrder(root);
		System.out.println("-------------------------------------------------------------");
		
		printPostOrder(root);
		//System.out.println("-------------------------------------------------------------");
		
		//printLevelWise(root);
		s.close();
	}

}
