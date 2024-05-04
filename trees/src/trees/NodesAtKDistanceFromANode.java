package trees;
import java.util.Scanner;
public class NodesAtKDistanceFromANode {

	public static BinaryTreeNode<Integer> input(Scanner s) throws QueueEmptyException
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
			BinaryTreeNode<Integer> temp=queue.dequeue();
			System.out.println("Enter data for Left Child of "+temp.data);
			data=s.nextInt();
			if(data!=-1)
			{
				BinaryTreeNode<Integer> l=new BinaryTreeNode<Integer>(data);
				queue.enqueue(l);
				root.left=l;
			}
			System.out.println("Enter data for Right Child of "+temp.data);
			data=s.nextInt();
			if(data!=-1)
			{
				BinaryTreeNode<Integer> r=new BinaryTreeNode<Integer>(data);
				queue.enqueue(r);
				root.right=r;
			}
		}
		return root;
	}
	
	public static void print(BinaryTreeNode<Integer> root) throws QueueEmptyException
	{
		if(root==null) return;
		QueueUsingLinkedList<BinaryTreeNode<Integer>> queue=new QueueUsingLinkedList<BinaryTreeNode<Integer>>();
		queue.enqueue(root);
		queue.enqueue(null);
		while(!queue.isEmpty())
		{
			BinaryTreeNode<Integer> temp=queue.dequeue();
			if(temp==null)
			{
				System.out.println();
				if(!queue.isEmpty())
					queue.enqueue(null);
			}
			else
			{
				System.out.print(temp.data);
				if(temp.left!=null)
				{
					queue.enqueue(temp.left);
				}
				if(temp.right!=null)
				{
					queue.enqueue(temp.right);
				}				
			}
		}
		
		
	}
	public static BinaryTreeNode<Integer> getNode(BinaryTreeNode<Integer> root,int nodeData)
	{
		if(root==null) return null;
		QueueUsingLinkedList<BinaryTreeNode<Integer>> queue=new QueueUsingLinkedList<BinaryTreeNode<Integer>>();
		queue.enqueue(root);
		while(!queue.isEmpty())
		{
			try {
				BinaryTreeNode<Integer> temp = queue.dequeue();
				if(temp.data==nodeData)
					return temp;
				if(temp.left!=null)
				{
					queue.enqueue(temp.left);
				}
				if(temp.right!=null)
				{
					queue.enqueue(temp.right);
				}	
			} catch (QueueEmptyException e) {}
						
		}
		return null;
	}
	public static void printNodesatK(BinaryTreeNode<Integer> node,int k)
	{
		if(node==null)	
			return;
		else if(k==0)
		{
			System.out.print(node.data+"  ");
			return;
		}
		k--;
		printNodesatK(node.left,k);
		
		printNodesatK(node.right,k);
	}
	public static void main(String[] args) throws QueueEmptyException {
		Scanner s=new Scanner(System.in);
		BinaryTreeNode<Integer> root=input(s);
		
		System.out.println("Enter Node data");
		int nodeData=s.nextInt();
		
		BinaryTreeNode<Integer> node=getNode(root,nodeData);
		
		System.out.println("Enter Distance");
		//System.out.println(node.data);
		int k=s.nextInt();
		printNodesatK(node,k);
		s.close();
	}

}
