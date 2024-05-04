package trees;
import java.util.Scanner;
public class CheckBalanced {

	public static BinaryTreeNode<Integer> input(Scanner s)
	{
		System.out.println("Enter Data");
		int data=s.nextInt();
		if(data==-1) return null;
		BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(data);
		QueueUsingLinkedList<BinaryTreeNode<Integer>> queue=new QueueUsingLinkedList<BinaryTreeNode<Integer>>();
		queue.enqueue(root);
		while(!queue.isEmpty())
		{
			try {
				BinaryTreeNode<Integer> temp=queue.dequeue();
				System.out.println("Enter Data for Left child of "+temp.data);
				data=s.nextInt();
				if(data!=-1)
				{
					BinaryTreeNode<Integer> l=new BinaryTreeNode<Integer>(data);
					temp.left=l;
					queue.enqueue(l);
				}
				System.out.println("Enter Data for Right child of "+temp.data);
				data=s.nextInt();
				if(data!=-1)
				{
					BinaryTreeNode<Integer> r=new BinaryTreeNode<Integer>(data);
					temp.right=r;
					queue.enqueue(r);
				}
			} catch (QueueEmptyException e) {}
		}
		return root;
	}
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
					str+=temp.left.data;
				}
				else	str+=" L -1 ";
				if(temp.right!=null)
				{
					queue.enqueue(temp.right);
					str+=temp.right.data;
				}
				else	str+=" R -1 ";
				System.out.println(str);
			} catch (QueueEmptyException e) {}			
		}
	}
	public static int height(BinaryTreeNode<Integer> node)
	{
		if(node==null) return 0;
		return 1+Math.max(height(node.left), height(node.right));
	}
	public static boolean checkBalanced(BinaryTreeNode<Integer> root)
	{
		if(root==null) return true;
		int hleft=height(root.left);
		int hright=height(root.right);
		boolean a1=((hleft-hright)==0||(hleft-hright)==1||(hleft-hright)==-1);
		boolean a2=checkBalanced(root.left);
		boolean a3=checkBalanced(root.right);
		if(a1&&a2&&a3)
			return true;
		return false;
	}
	public static Pair<Integer,Boolean> checkBalancedBetter(BinaryTreeNode<Integer> root)
	{
		if(root==null)
		{
			Pair<Integer,Boolean> op=new Pair<>();
			op.first=0;
			op.second=true;
			return op;
		}
		Pair<Integer,Boolean> cl=checkBalancedBetter(root.left);
		Pair<Integer,Boolean> cr=checkBalancedBetter(root.right);
		Pair<Integer,Boolean> output=new Pair<Integer,Boolean>();
		output.first=1+Math.max(cl.first, cr.first);
		output.second=true;
		
		if(Math.abs(cl.first-cr.first)>1)
			output.second=false;
		if(!cl.second||!cr.second)
			output.second=false;
		
		return output;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		BinaryTreeNode<Integer> root=input(s);
		System.out.println(checkBalancedBetter(root).second);
		print(root);
		s.close();
	}

}
