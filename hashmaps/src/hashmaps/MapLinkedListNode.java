package hashmaps;

public class MapLinkedListNode<K,V> {
	K key;
	V value;
	MapLinkedListNode<K,V> next;
	public MapLinkedListNode(K key,V value)
	{
		this.key=key;
		this.value=value;
		next=null;
	}
}
