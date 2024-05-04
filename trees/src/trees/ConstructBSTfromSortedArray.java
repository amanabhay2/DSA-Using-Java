package trees;

import java.util.Scanner;

public class ConstructBSTfromSortedArray {

	public static BinaryTreeNode<Integer> constructBST(int[] arr,int start,int end)
	{
		if(start>end) 
			return null;
		int  mid=(start+end)/2;
		BinaryTreeNode<Integer> node=new BinaryTreeNode<Integer>(arr[mid]);
		node.left=constructBST(arr,start,mid-1);
		node.right=constructBST(arr,mid+1,end);
		return node;
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
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter size if Sorted Array");
		int size=s.nextInt();
		int[] arr=new int[size];
		for(int i=0;i<size;i++)
		{
			arr[i]=s.nextInt();
		}
		BinaryTreeNode<Integer> root=constructBST(arr,0,size-1);
		print(root);		
		s.close();
	}

}
