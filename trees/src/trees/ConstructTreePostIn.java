package trees;

import java.util.Scanner;

public class ConstructTreePostIn {

	
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
					str+=" L "+temp.left.data;
				}
				else	str+=" L -1 ";
				if(temp.right!=null)
				{
					queue.enqueue(temp.right);
					str+=" R "+temp.right.data;
				}
				else	str+=" R -1 ";
				System.out.println(str);
			} catch (QueueEmptyException e) {}			
		}
	}
	
	public static BinaryTreeNode<Integer> constructTree(int[] post,int pStart,int pEnd,int[] in,int iStart,int iEnd)
	{
		if(pStart>pEnd) return null;
		
		int data=post[pEnd];
		BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(data);
		int pos=0;
		for(int i=iStart;i<=iEnd;i++)
		{
			if(in[i]==data)
				break;
			pos++;
		}
		root.left=constructTree(post,pStart,pStart+pos-1,in,iStart,iStart+pos-1);
		root.right=constructTree(post,pStart+pos,pEnd-1,in,iStart+pos+1,iEnd);
		
		return root;
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter size of the tree");
		int size=s.nextInt();
		int[] post=new int[size];
		int[] in=new int[size];
		System.out.println("Enter elements in Pre-Order");
		for(int i=0;i<size;i++)
		{
			post[i]=s.nextInt();
		}
		System.out.println("Enter elements in In-Order");
		for(int i=0;i<size;i++)
		{
			in[i]=s.nextInt();
		}
		BinaryTreeNode<Integer> root=constructTree(post,0,size-1,in,0,size-1);
		print(root);
		s.close();

	}

}
