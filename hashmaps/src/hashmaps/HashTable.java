package hashmaps;
import java.util.ArrayList;

public class HashTable<K,V> {
	ArrayList<MapLinkedListNode<K,V>> bucketArray;
	int bucketSize;
	int size;
	
	public HashTable()
	{
		bucketArray=new ArrayList<MapLinkedListNode<K,V>>();
		bucketSize=5;
		size=0;
		for(int i=0;i<5;i++)
		{
			bucketArray.add(null);
		}
	}
	
	public int getIndex(K key)
	{
		int hash=key.hashCode();
		return hash%bucketSize;		
	}
	public void insert(K key,V value)
	{
		int index=getIndex(key);
		MapLinkedListNode<K,V> head=bucketArray.get(index);
		while(head!=null)
		{
			if(head.key.equals(key))
			{
				head.value=value;
				return;
			}
			head=head.next;
		}
		head=bucketArray.get(index);
		MapLinkedListNode<K,V> node=new MapLinkedListNode<K,V>(key,value);
		node.next=head;
		bucketArray.set(index, node);
		size++;
		double loadFactor=(double)size/(double)bucketSize;
		if(loadFactor>0.7)
		{
			reHashing();
		}
	}
	private void reHashing()
	{
		System.out.println("Hashing");
		ArrayList<MapLinkedListNode<K,V>> tempArray=bucketArray;
		int tempSize=bucketSize;	
		bucketSize=2*bucketSize;
		bucketArray=new ArrayList<MapLinkedListNode<K,V>>();
		for(int i=0;i<bucketSize;i++)
		{
			bucketArray.add(null);
		}
		size=0;
		//Fetch elements from old arraylist
		for(int i=0;i<tempSize;i++)
		{
			MapLinkedListNode<K,V> head=tempArray.get(i);
			//Fetch every node  from old arraylist
			while(head!=null)
			{
				//Hash into new ArrayList
				insert(head.key,head.value);
				head=head.next;
			}
		}
		
	}
	public int getSize()
	{
		return size;
	}
	public V delete(K key)
	{
		int index=key.hashCode();
		MapLinkedListNode<K,V> head=bucketArray.get(index);
		MapLinkedListNode<K,V> prev=null;
		while(head!=null)
		{
			if(head.key.equals(key))
			{
				if(prev==null)
					bucketArray.set(index, head.next);
				else
				{
					prev.next=head.next;
				}
				size--;
				return head.value;
			}
			prev=head;
			head=head.next;
		}
		return null;
	}
	public V search(K key)
	{
		int index=getIndex(key);
		MapLinkedListNode<K,V> head=bucketArray.get(index);
		while(head!=null)
		{
			if(head.key.equals(key))
				return head.value;
			head=head.next;
		}
		return null;
	}
	
}










