package trees;
import java.util.ArrayList;
public class TreeNode<T> {
	T data;
	ArrayList<TreeNode<T>> child;
	public TreeNode(T x)
	{
		data=x;
		child=new ArrayList<>();
	}
}
