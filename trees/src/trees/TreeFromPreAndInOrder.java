package trees;

import java.util.Scanner;

public class TreeFromPreAndInOrder {

	public static void print(BinaryTreeNode<Integer> root)
	{
		if(root==null) return;
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
					str+=" L "+temp.left.data+"  ";
				}
				if(temp.right!=null)
				{
					queue.enqueue(temp.right);
					str+=" R "+temp.right.data+"  ";
				}
				System.out.println(str);
			} catch (QueueEmptyException e) {}
		}
	}
	
	public static BinaryTreeNode<Integer> constructBinaryTree(int[] pre,int pStart,int pEnd,int[] in,int iStart,int iEnd)
	{
		if(pStart>pEnd||iStart>iEnd)
		{
			return null;
		}
		int x=pre[pStart];
		BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(x);
		int leftSize=0;
		for(int i=iStart;i<=iEnd;i++)
		{
			if(in[i]==x)
				break;
			leftSize++;
		}
		
		root.left=constructBinaryTree(pre,pStart+1,pStart+leftSize,in,iStart,iStart+leftSize-1);
		
		root.right=constructBinaryTree(pre,pStart+leftSize+1,pEnd,in,iStart+leftSize+1,iEnd);
		
		return root;
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter number of elements");
		int size=s.nextInt();
		int[] pre=new int[size];
		int[] in=new int[size];
		System.out.println("Enter Pre Order Elements");
		for(int i=0;i<size;i++)
		{
			pre[i]=s.nextInt();
		}
		System.out.println("Enter In Order Elements");
		for(int i=0;i<size;i++)
		{
			in[i]=s.nextInt();
		}
		//construct tree
		BinaryTreeNode<Integer> root=constructBinaryTree(pre,0,size-1,in,0,size-1);
		//Print tree
		print(root);
		s.close();
	}

}
