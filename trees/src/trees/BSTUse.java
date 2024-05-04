package trees;

import java.util.Scanner;

public class BSTUse {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		BinarySearchTree tree=new BinarySearchTree();
		System.out.println("Enter size of the tree");
		int size=s.nextInt();
		for(int i=0;i<size;i++)
		{
			tree.insert(s.nextInt());
		}
		//tree.delete(4);
		tree.print();
		s.close();
	}

}
