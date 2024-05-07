package hashmaps;

public class HashMapUse {

	public static void main(String[] args) {
		/*
		HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
		h.insert(1, 1000);
		h.insert(2, 300);
		h.insert(3, 1800);
		h.insert(1, 1000);
		System.out.println(h.gwtValue(3));
		 
		HashMapUsingBst<Integer,Integer> hashMap=new HashMapUsingBst<Integer,Integer>();
		hashMap.insert(1, 1000);
		hashMap.insert(2, 300);
		hashMap.insert(3, 1800);
		hashMap.insert(3, 20000);
		hashMap.delete(1);
		System.out.println(hashMap.getValue(3));
		*/
		HashTable<String,Integer> ht=new HashTable<>();
		for(int i=0;i<20;i++)
		{
			ht.insert("abc"+i, i);
		}
		for(int i=0;i<20;i++)
		{
			System.out.println(ht.search("abc"+i));
		}
		
	}

}
