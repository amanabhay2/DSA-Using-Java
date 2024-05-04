package trees;

public class BinarySearchTree {
	BinaryTreeNode<Integer> root;
	public BinarySearchTree()
	{
		root=null;
	}
	
	private BinaryTreeNode<Integer> deleteHelper(int data,BinaryTreeNode<Integer> root)
	{
		if(root==null)
			return null;
		if(root.data>data)
		{
			root.left=deleteHelper(data,root.left);
		}
		else if(root.data<data)
		{
			root.right=deleteHelper(data,root.right);
		}
		else
		{
			if(root.left==null&&root.right==null)
				return null;
			else if(root.left==null)
				return root.right;
			else if(root.right==null)
				return root.left;
			else
			{
				int max=maximum(root.left);
				root.data=max;
				root.left=deleteHelper(max,root.left);
			}
		}
		return root;
	}
	
	private int maximum(BinaryTreeNode<Integer> node)
	{
		if(node==null)
			return Integer.MIN_VALUE;
		return Math.max(node.data, Math.max(maximum(node.left), maximum(node.right)));
	}
	
	public void delete(int data)
	{
		deleteHelper(data,root);
	}
	
	private boolean presentHelper(int data,BinaryTreeNode<Integer> root)
	{
		if(root==null)
			return false;
		if(root.data==data)
			return true;
		else if(root.data>data)
			return presentHelper(data,root.left);
		else
			return presentHelper(data,root.right);
	}
	
	public boolean present(int data)
	{
		return presentHelper(data,root);
	}
	
	private BinaryTreeNode<Integer> insertHelper(int data,BinaryTreeNode<Integer> root)
	{
		if(root==null)
		{
			BinaryTreeNode<Integer> node=new BinaryTreeNode<Integer>(data);
			root=node;
			return root;
		}
		if(root.data>data)
		{
			root.left=insertHelper(data,root.left);
		}
		else
		{
			root.right=insertHelper(data,root.right);
		}
		return root;
	}
	
	public void insert(int  data)
	{
		root= insertHelper(data,root);
	}
	
	public void print()
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

	
	
	
}
