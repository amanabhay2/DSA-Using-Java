package trees;

public class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode left;
	BinaryTreeNode right;
	
	public BinaryTreeNode(T data)
	{
		this.data=data;
		left=null;
		right=null;
	}
}
