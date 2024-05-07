package hashmaps;

public class MapTreeNode<T, V> {
	T key;
	V value;
	MapTreeNode<T, V> left;
	MapTreeNode<T, V> right;
	public MapTreeNode(T key,V value)
	{
		this.key=key;
		this.value=value;
		left=null;
		right=null;
	}
}
