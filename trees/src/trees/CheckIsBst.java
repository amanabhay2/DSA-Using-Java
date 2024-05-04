package trees;
import java.util.Scanner;
public class CheckIsBst {
	public static int max(BinaryTreeNode<Integer> root)
	{
		if(root==null) return Integer.MIN_VALUE;
		return Math.max(root.data, Math.max( max(root.left),max(root.right)));
	}
	public static int min(BinaryTreeNode<Integer> root)
	{
		if(root==null) return Integer.MAX_VALUE;
		return Math.min(root.data, Math.min( min(root.left),min(root.right)));
	}
	public static boolean isBst(BinaryTreeNode<Integer> root)
	{
		if(root==null) return true;
		int a=max(root.left);
		int b=min(root.right);
		boolean c=a<root.data&&b>root.data;
		boolean left=isBst(root.left);
		boolean right=isBst(root.right);
		return c&&left&&right;
	}
	
	public static Triplet<Integer,Integer,Boolean> isBstBetter(BinaryTreeNode<Integer> root)
	{
		if(root==null)
		{
			Triplet<Integer,Integer,Boolean> t=new Triplet<Integer,Integer,Boolean>();
			t.first=Integer.MIN_VALUE;
			t.second=Integer.MAX_VALUE;
			t.third=true;
			return t;
		}
		Triplet<Integer,Integer,Boolean> left=isBstBetter(root.left);
		Triplet<Integer,Integer,Boolean> right=isBstBetter(root.right);
		Triplet<Integer,Integer,Boolean> op=new Triplet<Integer,Integer,Boolean>();
		op.first=Math.max(root.data, Math.max(left.first, right.first));
		op.second=Math.min(root.data, Math.min(left.second, right.second));
		boolean a=left.first<root.data&&right.second>root.data;
		op.third=a&&left.third&&right.third;
		return op;
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
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		BinaryTreeNode<Integer> root=input(s);
		//System.out.println(isBst(root));
		System.out.println(isBstBetter(root).third);
		s.close();
	}

}
