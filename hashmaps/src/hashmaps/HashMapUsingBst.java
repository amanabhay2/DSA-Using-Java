package hashmaps;

public class HashMapUsingBst<T,V> {
private MapTreeNode<T, V> root;
	
	public HashMapUsingBst()
	{
		root=null;
	}

	public void insert(T key,V value) 
	{
		root=insertHelper(root,key,value);
	}
	public MapTreeNode<T, V> insertHelper(MapTreeNode<T, V> root,T key,V value)
	{
		
		if(root==null)
			return new MapTreeNode<T,V>(key,value);
		
		if((int)root.key>(int)key)
			root.left=insertHelper(root.left,key,value);
		else if((int)root.key<(int)key)
			root.right=insertHelper(root.right,key,value);
		else
		{
			root.value=value;
		}
		return root;
	}
	
	public V getValueHelper(MapTreeNode<T, V> root,T key)
	{
		if(root==null)
			return null;
		if(root.key==key)
			return root.value;
		else if((int)root.key>(int)key)
			return getValueHelper(root.left,key);
		else
			return getValueHelper(root.right,key);
	}
	public V getValue(T key)
	{
		return getValueHelper(root,key);
	}
	
	public MapTreeNode<T,V> deleteHelper(MapTreeNode<T,V> root,T key)
	{
		if(root==null)
			return null;
		if((int)root.key>(int)key)
			root.left=deleteHelper(root.left,key);
		else if((int)root.key<(int)key)
			root.right=deleteHelper(root.right,key);
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
				MapTreeNode<T,V> temp=root.left;
				while(temp.right!=null)
				{
					temp=temp.right;
				}
				root.key=temp.key;
				root.value=temp.value;
				root.left=deleteHelper(root.left,temp.key);
			}
		}
		return root;
	}
	public void delete(T key)
	{
		root=deleteHelper(root,key);
	}
	
}
