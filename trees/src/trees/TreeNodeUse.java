package trees;

import java.util.Scanner;

public class TreeNodeUse {

	public static void print1(TreeNode<Integer> root)
	{
		if(root==null)
			return;
		System.out.print(root.data+"   ");
		for(int i=0;i<root.child.size();i++)
		{
			print1(root.child.get(i));
		}
		
	}
	public static void print2(TreeNode<Integer> root)
	{
		if(root==null)
			return;
		String str=root.data+":";
		for(int i=0;i<root.child.size();i++)
		{
			str=str+root.child.get(i).data+",";
		}
		System.out.println(str);
		for(int i=0;i<root.child.size();i++)
		{
			print2(root.child.get(i));
		}
		
	}
	public static void print3(TreeNode<Integer> root)
	{
		QueueUsingLinkedList<TreeNode<Integer>> queue=new QueueUsingLinkedList<TreeNode<Integer>>();
		queue.enqueue(root);
		while(!queue.isEmpty())
		{
			try {
				TreeNode<Integer> temp=queue.dequeue();
				String str=temp.data+":";
				for(int i=0;i<temp.child.size();i++)
				{
					TreeNode<Integer> c=temp.child.get(i);
					queue.enqueue(c);
					str=str+c.data+"  ";
				}
				System.out.println(str);
				
			} catch (QueueEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
		}
	}
	
	public static TreeNode<Integer> input1(Scanner s)
	{
		System.out.println("Enter data");
		int n=s.nextInt();
		System.out.println("Number of childen for :"+n);
		int c=s.nextInt();
		TreeNode<Integer> root=new TreeNode<>( n);
		for(int i=0;i<c;i++)
		{
			TreeNode<Integer> child=input1(s);
			root.child.add(child);
		}
		return root;
	}
	/*public static TreeNode<Integer> input2(TreeNode<Integer> root,Scanner s)
	{
		if(root==null)
			return root;
		System.out.println("Number of childen for :"+root.data);
		int c=s.nextInt();
		
		for(int i=0;i<c;i++)
		{
			System.out.println("Enter data");
			int n=s.nextInt();
			TreeNode<Integer> child=new TreeNode<>(n);
			root.child.add(child);
		}
		for(int i=0;i<c;i++)
		{
			input2(root.child.get(i),s);
		}
		return root;
		
	}*/
	public static TreeNode<Integer> input(Scanner s) throws QueueEmptyException
	{
		System.out.println("Enter Data");
		int n=s.nextInt();
		TreeNode<Integer> root=new TreeNode<>(n);
		QueueUsingLinkedList<TreeNode<Integer>> queue=new QueueUsingLinkedList<TreeNode<Integer>>();
		queue.enqueue(root);
		while(!queue.isEmpty())
		{
			TreeNode<Integer> temp=queue.dequeue();
			System.out.println("Number of childen for :"+temp.data);
			int c=s.nextInt();
			
			for(int i=0;i<c;i++)
			{
				System.out.println("Enter data");
				TreeNode<Integer> child=new TreeNode<>(s.nextInt());
				queue.enqueue(child);
				temp.child.add(child);
			}
		}		
		return root;
	}
	public static void main(String[] args) throws QueueEmptyException {
		Scanner s=new Scanner(System.in);
		
		TreeNode<Integer> root=input(s);
		print3(root);
		
		s.close();
	}

}
