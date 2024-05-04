package trees;

import java.util.Scanner;

public class TreeNoOfNodes {

	
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
	public static void print(TreeNode<Integer> root)
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
	public static int countOfRoots1(TreeNode<Integer> root)
	{
		int count =1;
		for(int i=0;i<root.child.size();i++)
		{
			count+=countOfRoots1(root.child.get(i));
		}
		return count;
	}
	public static int countOfRoots(TreeNode<Integer> root)
	{
		if(root==null)
			return 0;
		int ount=0;
		QueueUsingLinkedList<TreeNode<Integer>> queue=new QueueUsingLinkedList<TreeNode<Integer>>();
		queue.enqueue(root);
		while(!queue.isEmpty())
		{
			try {
				TreeNode<Integer> temp=queue.dequeue();
				for(int i=0;i<temp.child.size();i++)
				{
					queue.enqueue(temp.child.get(i));
				}
				ount++;
			} catch (QueueEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return ount;
	}
	public static TreeNode<Integer> largest(TreeNode<Integer> root)
	{
		TreeNode<Integer>  temp=root;
		for(int i=0;i<root.child.size();i++)
		{
			int largest=root.child.get(i).data;
			if(largest>temp.data)
				temp=root.child.get(i);
		}
		return temp;
	}
	public static int height(TreeNode<Integer> root)
	{
		int largest=0;
		for(int i=0;i<root.child.size();i++)
		{
			int temp=height(root.child.get(i));
			if(temp>largest)
				largest=temp;
		}
		return largest+1;
	}
	public static int depth(TreeNode<Integer> root, int x)
	{
		if(root.data==x)
			return 1;
		int largest=0;
		for(int i=0;i<root.child.size();i++)
		{
			int temp=height(root.child.get(i));
			if(temp>largest)
				largest=temp;
		}
		return largest+1;
		
	}
	public static void printLevel(TreeNode<Integer> root, int l)
	{
		if(l<0)
			return;
		if(l==0)
		{
			System.out.println(root.data);
		}
		for(int i=0;i<root.child.size();i++)
		{
			printLevel(root.child.get(i),l-1);
		}
	}
	public static int leafNodes(TreeNode<Integer> root)
	{
		if(root.child.size()==0)
			return 1;
		int sum=0;
		for(int i=0;i<root.child.size();i++)
		{
			sum=sum+leafNodes(root.child.get(i));
		}
		return sum;
	}
	public static void main(String[] args) throws QueueEmptyException {
		Scanner s=new Scanner(System.in);
		
		TreeNode<Integer> root=input(s);
		//print(root);
		//System.out.println(countOfRoots1(root));
		TreeNode<Integer> large=largest(root);
		System.out.println(height(root));
		printLevel(root,2);
		System.out.println(leafNodes(root));
		s.close();

	}

}
//4 2 3 4 0 0