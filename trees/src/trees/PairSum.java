package trees;

import java.util.*;

public class PairSum {

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
	public static void toArray(BinaryTreeNode<Integer> root,ArrayList<Integer> arr)
	{
		if(root==null)
			return;
		toArray(root.left,arr);
		arr.add(root.data);
		toArray(root.right,arr);
			
	}
	public static void printPairSum(BinaryTreeNode<Integer> root,int S)
	{
		if(root==null)
			return;
		ArrayList<Integer> arr=new ArrayList<Integer>();
		toArray(root,arr);
		int i=0;	int j=arr.size()-1;
		while(i<j)
		{
			int sum=arr.get(i)+arr.get(j);
			if(sum>S)
				j--;
			else if(sum<S)
				i++;
			else
			{
				System.out.println(arr.get(i)+"   "+arr.get(j));
				i++;
				j--;
			}
		}
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		BinaryTreeNode<Integer> root=input(s);
		int S=s.nextInt();
		printPairSum(root,S);		
		s.close();
	}

}
